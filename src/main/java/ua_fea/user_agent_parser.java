package ua_fea;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName UserAgentParser
 * @Description TODO
 * @Author hylz
 * @Date 2020/2/1520:34
 * @Version 1.0
 **/

public class user_agent_parser {
	private static HashMap<String, HashMap<String, Object>> _parse_cache = new HashMap<>();
	private static final int MAX_CACHE_SIZE = 20;

	public static HashMap<String, Object> Parse(String user_agent_string, HashMap<Object, String>... jsParseBits) {
		HashMap<Object, String>[] jsParseBit = new HashMap[1];
		if (jsParseBits != null) {
			jsParseBit = jsParseBits;
		}
		String key = user_agent_string + jsParseBit.toString();
		HashMap<String, Object> cached = _parse_cache.get(key);
		if (cached != null) {
			return cached;
		}
		if (_parse_cache.size() > MAX_CACHE_SIZE) {
			_parse_cache.clear();
		}

		HashMap<String, Object> v = new HashMap<>();
		v.put("user_agent", ParseUserAgent(user_agent_string, jsParseBits));
		v.put("os", ParseOS(user_agent_string));
		v.put("device", ParseDevice(user_agent_string));
		v.put("string", user_agent_string);

		_parse_cache.put(key, v);
		return v;
	}

	public static HashMap<String, String> ParseUserAgent(String user_agent_string, HashMap<Object, String>... jsParseBits) {
		String family = null;
		String v1 = null;
		String v2 = null;
		String v3 = null;
		if (jsParseBits.length != 0 && jsParseBits[0].containsKey("js_user_agent_family") &&
				jsParseBits[0].get("js_user_agent_family“") != "") {

		} else {
			for (UserAgentParser uaParser : Regexes.getUSER_AGENT_PARSERS()) {
				String[] parse = uaParser.ParseUA(user_agent_string);
				family = parse[0];
				v1 = parse[1];
				v2 = parse[2];
				v3 = parse[3];
				if (family != null) {
					break;
				}
			}
		}

		if (jsParseBits.length != 0 && jsParseBits[0].containsKey("js_user_agent_string")) {
			String js_user_agent_string = jsParseBits[0].get("js_user_agent_string");
			if (js_user_agent_string != null && js_user_agent_string.indexOf("Chrome/") > -1 &&
					user_agent_string.indexOf("chromeframe") > -1) {
				HashMap<String, String> jsOverride = ParseUserAgent(js_user_agent_string);
				family = "Chrome Frame (" + family + " " + v1 + ")";
				v1 = jsOverride.get("major");
				v2 = jsOverride.get("minor");
				v3 = jsOverride.get("patch");
			}
		}

		family = family == null ? "Other" : family;
		HashMap<String, String> res = new HashMap<>();
		res.put("family", family);
		res.put("major", v1);
		res.put("minor", v2);
		res.put("patch", v3);
		return res;
	}

	public static HashMap<String, String> ParseOS(String user_agent_string) {
		String os = null;
		String os_v1 = null;
		String os_v2 = null;
		String os_v3 = null;
		String os_v4 = null;
		for (OSParser osParser : Regexes.getOS_PARSERS()) {
			String[] parse = osParser.ParseOS(user_agent_string);
			os = parse[0];
			os_v1 = parse[1];
			os_v2 = parse[2];
			os_v3 = parse[3];
			os_v4 = parse[4];
			if (os != null) {
				break;
			}
		}
		os = os == null ? "Other" : os;
		HashMap<String, String> res = new HashMap<>();
		res.put("family", os);
		res.put("major", os_v1);
		res.put("minor", os_v2);
		res.put("patch", os_v3);
		res.put("patch_minor", os_v4);
		return res;
	}

	public static HashMap<String, String> ParseDevice(String user_agent_string) {
		String device = null;
		String brand = null;
		String model = null;
		for (DeviceParser deviceParser : Regexes.getDEVICE_PARSERS()) {
			String[] parse = deviceParser.ParseDevice(user_agent_string);
			device = parse[0];
			brand = parse[1];
			model = parse[2];
			if (device != null) {
				break;
			}
		}
		device = device == null ? "Other" : device;
		HashMap<String, String> res = new HashMap<>();
		res.put("family", device);
		res.put("brand", brand);
		res.put("model", model);
		return res;
	}

}

class UserAgentParser {
	private String pattern;
	private Pattern user_agent_re;
	private String family_replacement;
	private String v1_replacement;
	private String v2_replacement;

	public UserAgentParser(String pattern, String familyReplacement, String v1Replacement, String v2Replacement) {
		this.pattern = pattern;
		user_agent_re = Pattern.compile(pattern);
		this.family_replacement = familyReplacement;
		this.v1_replacement = v1Replacement;
		this.v2_replacement = v2Replacement;
	}

	public String[] ParseUA(String userAgentString) {
		String family = null;
		String v1 = null;
		String v2 = null;
		String v3 = null;
		Matcher match = this.user_agent_re.matcher(userAgentString);
		if (match.find()) {
			if (this.family_replacement != null) {
				if (Pattern.matches(".*\\$1.*", this.family_replacement)) {
					family = Pattern.compile("\\$1").matcher(this.family_replacement).replaceAll(match.group(1));
				} else {
					family = this.family_replacement;
				}
			} else {
				family = match.group(1);
			}

			if (this.v1_replacement != null) {

			} else if (match.groupCount() >= 2) {
				v1 = match.group(2);
			}

			if (this.v2_replacement != null) {

			} else if (match.groupCount() >= 3) {
				v2 = match.group(3);
			}

			if (match.groupCount() >= 4) {
				v3 = match.group(4);
			}
		}

		return new String[]{family, v1, v2, v3};
	}

}

class OSParser {
	private String pattern;
	private Pattern user_agent_re;
	private String os_replacement;
	private String os_v1_replacement;
	private String os_v2_replacement;
	private String os_v3_replacement;
	private String os_v4_replacement;

	public OSParser(String pattern, String os_replacement, String os_v1_replacement, String os_v2_replacement,
	                String os_v3_replacement, String os_v4_replacement) {
		this.pattern = pattern;
		this.user_agent_re = Pattern.compile(pattern);
		this.os_replacement = os_replacement;
		this.os_v1_replacement = os_v1_replacement;
		this.os_v2_replacement = os_v2_replacement;
		this.os_v3_replacement = os_v3_replacement;
		this.os_v4_replacement = os_v4_replacement;
	}

	public String[] ParseOS(String user_agent_string) {
		String os = null;
		String os_v1 = null;
		String os_v2 = null;
		String os_v3 = null;
		String os_v4 = null;
		Matcher match = this.user_agent_re.matcher(user_agent_string);
		if (match.find()) {
			if (this.os_replacement != null) {
				if (Pattern.matches(".*\\$1.*", this.os_replacement)) {
					os = Pattern.compile("\\$1").matcher(this.os_replacement).replaceAll(match.group(1));
				} else {
					os = this.os_replacement;
				}
			} else if (match.groupCount() >= 1) {
				os = match.group(1);
			}

			if (this.os_v1_replacement != null) {
				if (Pattern.matches(".*\\$1.*", this.os_v1_replacement)) {
					os_v1 = Pattern.compile("\\$1").matcher(this.os_v1_replacement).replaceAll(match.group(1));
				} else {
					os_v1 = this.os_v1_replacement;
				}
			} else if (match.groupCount() >= 2) {
				os_v1 = match.group(2);
			}

			if (this.os_v2_replacement != null) {
				os_v2 = this.os_v2_replacement;
			} else if (match.groupCount() >= 3) {
				os_v2 = match.group(3);
			}

			if (this.os_v3_replacement != null) {
				os_v3 = this.os_v3_replacement;
			} else if (match.groupCount() >= 4) {
				os_v3 = match.group(4);
			}

			if (this.os_v4_replacement != null) {
				os_v4 = this.os_v4_replacement;
			} else if (match.groupCount() >= 5) {
				os_v4 = match.group(5);
			}
		}

		return new String[]{os, os_v1, os_v2, os_v3, os_v4};
	}
}

class DeviceParser {
	private String pattern;
	private Pattern user_agent_re;
	private String device_replacement;
	private String brand_replacement;
	private String model_replacement;

	public DeviceParser(String pattern, String regex_flag, String device_replacement, String brand_replacement,
	                    String model_replacement) {
		this.pattern = pattern;
		if ("i".equals(regex_flag)) {
			this.user_agent_re = Pattern.compile(this.pattern, Pattern.CASE_INSENSITIVE);
		} else {
			this.user_agent_re = Pattern.compile(this.pattern);
		}
		this.device_replacement = device_replacement;
		this.brand_replacement = brand_replacement;
		this.model_replacement = model_replacement;
	}

	public String MultiReplace(String string, Matcher match) {
//		String _string = string.replaceAll("\\$(\\d)", multiReplaceAssist("$1", match));
//		_string = _string.replaceAll("^\\s+|\\s+$", "");
//		if ("".equals(_string)) {
//			return null;
//		}
//		return _string;

		Matcher m = Pattern.compile("\\$(\\d)").matcher(string);

		StringBuffer sb = new StringBuffer();

		while (m.find())
			m.appendReplacement(sb, multiReplaceAssist(m.group(1), match));

		m.appendTail(sb);

		return sb.toString();

//		String _string = null;
//		Matcher m = Pattern.compile(".*\\$(\\d).*").matcher(string);
//		if(m.find()){
//			int index = Integer.parseInt(m.group(1));
//			if (index <= match.groupCount()) {
//				_string = string.replaceAll("\\$\\d",match.group(index));
//			} else {
//				_string = m.replaceAll("");
//			}
//		}else{
//			_string = m.replaceAll("");
//		}
//
//		_string = Pattern.compile("^\\s+|\\s+$").matcher(_string).replaceAll("");
//		if (_string == "") {
//			return null;
//		}
//		return _string;
	}

	public String multiReplaceAssist(String string, Matcher match) {
		int index = Integer.parseInt(string);
		if (index <= match.groupCount()) {
			return match.group(index);
		}
		return "";
	}

	public String[] ParseDevice(String user_agent_string) {
		String device = null;
		String brand = null;
		String model = null;
		Matcher match = this.user_agent_re.matcher(user_agent_string);
		if (match.find()) {
			if (this.device_replacement != null) {
				device = this.MultiReplace(this.device_replacement, match);
			} else {
				device = match.group(1);
			}

			if (this.brand_replacement != null) {
				brand = this.MultiReplace(this.brand_replacement, match);
			}

			if (this.model_replacement != null) {
				model = this.MultiReplace(this.model_replacement, match);
			} else if (match.groupCount() > 0) {
				model = match.group(1);
			}
		}
		return new String[]{device, brand, model};
	}
}

