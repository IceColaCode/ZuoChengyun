package ua_fea;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName Parsers
 * @Description TODO
 * @Author hylz
 * @Date 2020/2/1520:53
 * @Version 1.0
 **/
public class Parsers {
	public static UserAgent parse(String user_agent_string) {
		return new UserAgent(user_agent_string);
	}

}

class UserAgent {
	private HashMap<String, Object> uaDict;
	private String uaString;
	private HashMap<String, String> os;
	private HashMap<String, String> browser;

	public HashMap<String, String> getOs() {
		return os;
	}

	public HashMap<String, String> getBrowser() {
		return browser;
	}

	public HashMap<String, String> getDevice() {
		return device;
	}

	private HashMap<String, String> device;

	public UserAgent(String user_agent_string) {
		this.uaDict = user_agent_parser.Parse(user_agent_string);
		this.uaString = user_agent_string;
		this.os = parse_operating_system(this.uaDict.get("os"));
		this.browser = parse_browser(this.uaDict.get("user_agent"));
		this.device = (HashMap<String, String>) this.uaDict.get("device");

	}

	private HashMap<String, String> parse_operating_system(Object os) {
		HashMap<String, String> osMap = (HashMap<String, String>) os;
		String family = osMap.get("family");
		String major = osMap.get("major");
		String minor = osMap.get("minor");
		String patch = osMap.get("patch");
		String patch_minor = osMap.get("patch_minor");
		ArrayList<String> version = parse_version(major, minor, patch, null);
		StringBuilder builder = new StringBuilder();
		for (String ver : version) {
			builder.append(ver).append('.');
		}
		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		String version_string = builder.toString();
		HashMap<String, String> res = new HashMap<>();
		res.put("family", family);
		res.put("version", version.toString());
		res.put("version_string", version_string);
		return res;
	}

	private HashMap<String, String> parse_browser(Object user_agent) {
		HashMap<String, String> user_agent_map = (HashMap<String, String>) user_agent;
		String family = user_agent_map.get("family");
		String major = user_agent_map.get("major");
		String minor = user_agent_map.get("minor");
		String patch = user_agent_map.get("patch");
		ArrayList<String> version = parse_version(major, minor, patch, null);
		StringBuilder builder = new StringBuilder();
		for (String ver : version) {
			builder.append(ver).append('.');
		}
		if (builder.length() > 0){
			builder.deleteCharAt(builder.length() - 1);
		}
		String version_string = builder.toString();
		HashMap<String, String> res = new HashMap<>();
		res.put("family", family);
		res.put("version", version.toString());
		res.put("version_string", version_string);
		return res;
	}

	private ArrayList<String> parse_version(String major, String minor, String patch, String patch_minor) {
		ArrayList<String> list = new ArrayList<>();
		if (major != null) {
//			list.add(Integer.parseInt(major));
			list.add(major);
		}
		if (minor != null) {
//			list.add(Integer.parseInt(minor));
			list.add(minor);
		}
		if (patch != null) {
//			list.add(Integer.parseInt(patch));
			list.add(patch);
		}
		if (patch_minor != null) {
//			list.add(Integer.parseInt(patch_minor));
			list.add(patch_minor);
		}
		return list;
	}
}
