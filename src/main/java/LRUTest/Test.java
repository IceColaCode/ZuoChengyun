package LRUTest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName Test
 * @Description TODO
 * @Author hylz
 * @Date 2020/3/9 9:21
 * @Version 1.0
 **/
public class Test {
	private static LRUCache<String, Object> PARSE_CACHE = new LRUCache<>(3);

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		PARSE_CACHE.put("b", "avx");
		PARSE_CACHE.get("a");
		PARSE_CACHE.put("c", "ax");
		PARSE_CACHE.put("d", "v");
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		map.put("q", "qq");
		map.put("qq", "qqq");
		map2.put("p", "pp");
		map2.put("pp", "ppp");

		Dog dog = new Dog("xiaogou", "11", new HashMap[]{map, map2});
		PARSE_CACHE.put("e", dog);
		System.out.println(PARSE_CACHE);
		saveFile(PARSE_CACHE, "data");

		System.out.println(PARSE_CACHE.get("bbb"));

//		HashMap<String, Object> data = readFile("data");
//		System.out.println(data);

	}

	public static void saveFile(HashMap<String, Object> users, String path)
			throws IOException {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("file://172.16.211.8/home/luoyan"))) {
			os.writeObject(users);
		}
//		file://localhost/home/luoyan/device.csv
	}

	public static HashMap<String, Object> readFile(String path)
			throws ClassNotFoundException, IOException {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
			return (HashMap<String, Object>) is.readObject();
		}
	}
}
