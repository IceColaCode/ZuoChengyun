package ua_fea;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @ClassName Regexes
 * @Description TODO
 * @Author hylz
 * @Date 2020/2/1520:41
 * @Version 1.0
 **/
public class Regexes {
	private static ArrayList<UserAgentParser> USER_AGENT_PARSERS = new ArrayList<>();
	private static ArrayList<OSParser> OS_PARSERS = new ArrayList<>();
	private static ArrayList<DeviceParser> DEVICE_PARSERS = new ArrayList<>();

	static {
		System.out.println("hello");
		Yaml yaml = new Yaml();
		File f = new File("D:\\code\\test\\java\\ZuoChengyun\\src\\main\\resources\\regexes.yaml");
		Object result = null;
		try {
			result = yaml.load(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		HashMap<String, ArrayList<LinkedHashMap<String, String>>> map =
				(HashMap<String, ArrayList<LinkedHashMap<String, String>>>) result;
		for (LinkedHashMap<String, String> ua : map.get("user_agent_parsers")){
			USER_AGENT_PARSERS.add(new UserAgentParser(ua.get("regex"), ua.get("family_replacement"),
					ua.get("v1_replacement"), ua.get("v2_replacement")));
		}

		for (LinkedHashMap<String, String> os : map.get("os_parsers")){
			OS_PARSERS.add(new OSParser(os.get("regex"), os.get("os_replacement"), os.get("os_v1_replacement"),
					os.get("os_v2_replacement"),os.get("os_v3_replacement"),os.get("os_v4_replacement")));
		}

		for (LinkedHashMap<String, String> device : map.get("device_parsers")){
			DEVICE_PARSERS.add(new DeviceParser(device.get("regex"), device.get("regex_flag"),
					device.get("device_replacement"), device.get("brand_replacement"),device.get("model_replacement")));
		}




//		USER_AGENT_PARSERS.add(new UserAgentParser("(ESPN)[%20| ]+Radio/(\\d+)\\.(\\d+)\\.(\\d+) CFNetwork",
//				null, null, null));
//		USER_AGENT_PARSERS.add(new UserAgentParser("(Antenna)/(\\d+) CFNetwork",
//				"AntennaPod", null, null));
//		USER_AGENT_PARSERS.add(new UserAgentParser("(PlayBook).+RIM Tablet OS (\\d+)\\.(\\d+)\\.(\\d+)",
//				"BlackBerry WebKit", null, null));
//		USER_AGENT_PARSERS.add(new UserAgentParser("(Black[bB]erry|BB10).+Version/(\\d+)\\.(\\d+)\\.(\\d+)",
//				"BlackBerry WebKit", null, null));
//		USER_AGENT_PARSERS.add(new UserAgentParser("(Black[bB]erry)\\s?(\\d+)",
//				"BlackBerry", null, null));
//
//		OS_PARSERS.add(new OSParser("(BB10);.+Version/(\\d+)\\.(\\d+)\\.(\\d+)", "BlackBerry OS",
//				null, null, null, null));
//		OS_PARSERS.add(new OSParser("(Black[Bb]erry)[0-9a-z]+/(\\d+)\\.(\\d+)\\.(\\d+)(?:\\.(\\d+))?",
//				"BlackBerry OS", null, null, null, null));
//		OS_PARSERS.add(new OSParser("(Black[Bb]erry).+Version/(\\d+)\\.(\\d+)\\.(\\d+)(?:\\.(\\d+))?", "BlackBerry OS",
//				null, null, null, null));
//		OS_PARSERS.add(new OSParser("(Black[Bb]erry)", "BlackBerry OS",
//				null, null, null, null));
//
//		DEVICE_PARSERS.add(new DeviceParser("Black[Bb]erry ([0-9]+);", null,
//				"BlackBerry $1", "BlackBerry", "$1"));
//		DEVICE_PARSERS.add(new DeviceParser("Black[Bb]erry([0-9]+)", null,
//				"BlackBerry $1", "BlackBerry", "$1"));

	}

	public static ArrayList<UserAgentParser> getUSER_AGENT_PARSERS() {
		return USER_AGENT_PARSERS;
	}

	public static ArrayList<OSParser> getOS_PARSERS() {
		return OS_PARSERS;
	}

	public static ArrayList<DeviceParser> getDEVICE_PARSERS(){
		return DEVICE_PARSERS;
	}
}
