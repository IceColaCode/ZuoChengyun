package ua_fea;

import java.util.ArrayList;

/**
 * @ClassName Test
 * @Description TODO
 * @Author hylz
 * @Date 2020/2/1520:22
 * @Version 1.0
 **/

public class Test
{
	public static void main( String args[] ){
		ArrayList<String> uaList = new ArrayList<>();
		// TODO: Browser should be recognized as Chrome, but it returns Safari
		uaList.add("Mozilla/5.0 (X11; CrOS i686 0.12.433) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.77 Safari/534.30");
		// TODO: Browser should be recognized as Chrome, but it returns Safari
		uaList.add("Mozilla/5.0 (Linux; Android 4.4.2; en-us; SAMSUNG SCH-I545 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36");
		uaList.add("Mozilla/5.0 (PlayStation Vita 3.12) AppleWebKit/536.26 (KHTML, like Gecko) Silk/3.2");
		uaList.add("Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-I9300 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
		// TODO: Device should be recognized as "Huawei RIO-AL00", but it returns "RIO-AL00RIO-AL00"
		uaList.add("Dalvik/2.1.0 (Linux; U; Android 6.0.1; HUAWEI RIO-AL00 Build/HuaweiRIO-AL00) NewsArticle/7.3.7");
		uaList.add("Dalvik/2.1.0 (Linux; U; Android 6.0.1; OPPO A57 Build/MMB29M)");
		uaList.add("Dalvik/2.1.0 (Linux; U; Android 6.0.1; vivo Y66L Build/MMB29M) NewsArticle/7.3.0");

		uaList.forEach(uaStr -> {
			UserAgent parse = Parsers.parse(uaStr);
//			System.out.println(parse.getBrowser());
			System.out.println(parse.getDevice());
//			System.out.println(parse.getOs());
			System.out.println("-----------------------------");
		});

	}

}
