package menu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;

public class MenuManager {

	public static void createMenu(String params) {

		StringBuffer bufferRes = new StringBuffer();

		try {

			URL realUrl = new URL("https://api.weixin.qq.com/cgi-bin/menu/create");

			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

			// 连接超时

			conn.setConnectTimeout(25000);

			// 读取超时 --服务器响应比较慢,增大时间

			conn.setReadTimeout(25000);

			HttpURLConnection.setFollowRedirects(true);

			// 请求方式

			conn.setRequestMethod("POST");

			conn.setDoOutput(true);

			conn.setDoInput(true);

			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

			conn.setRequestProperty("Referer", "https://api.weixin.qq.com/");

			conn.connect();

			// 获取URLConnection对象对应的输出流

			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

			// 发送请求参数

			out.write(params);
			System.out.println(params);

			// out.write(params);

			out.flush();

			out.close();

			InputStream in = conn.getInputStream();

			BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));

			String valueString = null;

			while ((valueString = read.readLine()) != null) {

				bufferRes.append(valueString);

			}

			System.out.println(bufferRes.toString());

			in.close();

			if (conn != null) {

				// 关闭连接

				conn.disconnect();

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException
	 * 
	 */

	public static void main(String[] args) throws UnsupportedEncodingException {
		String accessToken = "10_ZUZs5iXINRm17HKSichhXmJBOiiMC2nkhvW4_TfWje9rPbr2nUSdL2UAQYG5j8dLt7o8ecJtbnys7dNd6_qROgBu0D_pJVV6WOQ9hrbPsS9u_3PZ2rCUI6cwYQjj9k3w7mBfv_0919dSrHR8FRLbAEAMYS";// 你自己的token
		Gson gson = new Gson();

		Buttons button = new Buttons();

		// Sub_button sub_button = new Sub_button();
		// 第一个菜单
		Buttons buttons1 = new Buttons();
		buttons1.setName("查询天气");
		buttons1.setType("click");
		buttons1.setKey("bt1");

		// 第二个菜单
		Buttons buttons2 = new Buttons();
		buttons2.setName("翻译");
		buttons2.setType("click");
		buttons2.setKey("bt2");
		// 点击跳转的URL
		//buttons2.setUrl("http://45.40.205.96/MyVideo");

		// 第三个菜单
		Buttons buttons3 = new Buttons();
		buttons3.setName("菜单");
		/*
		 * buttons3.setType("bt3"); buttons3.setKey("bt3");
		 */

		// 在菜单中添加二级菜单
		// Sub_button sub_button = new Sub_button();

		// 第一个二级菜单
		Sub_button sub_button1 = new Sub_button();
		sub_button1.setName("更多电影");
		sub_button1.setKey("bt31");
		sub_button1.setUrl("http://45.40.205.96/MyVideo");
		sub_button1.setType("view");

		Sub_button[] sub_buttons = new Sub_button[] { sub_button1 };

		buttons3.setSub_button(sub_buttons);

		/*
		 * Sub_button sub_button1 = new Sub_button(); sub_button1.setName("更多电影");
		 * sub_button1.setKey("bt31");
		 * sub_button1.setUrl("http://45.40.205.96/MyVideo");
		 * sub_button1.setType("click");
		 */

		// 创建一个Buttons类型的数组，然后传入对象
		Buttons[] buttons = new Buttons[] { buttons1, buttons2, buttons3 };

		button.setButton(buttons);

		/*
		 * Menus menus = new Menus(); menus.setButton(button);
		 */
		// buttons.setButton(buttons1);

		String json = gson.toJson(button);
		System.out.println(json);

		/*
		 * //主菜单上添加二级菜单 Sub_button sub_button1 = new Sub_button();
		 * sub_button1.setName("精美图片"); sub_button1.setType("click");
		 * sub_button1.setKey("bt31");
		 * 
		 * sub_button.setSub_button(sub_button1);
		 */
		// buttons3.setSub_button(sub_button);
		String p2 = URLEncoder.encode(json, "UTF-8");

		String p = "{\r\n" +

				"        \"button\": [\r\n" + "            {\r\n" + "                \"type\": \"click\",\r\n"
				+ "                \"name\": \"查询天气\",\r\n" + "                \"key\": \"get_groupon\"\r\n"
				+ "            },\r\n" + "            {\r\n" + "                \"type\": \"click\",\r\n"
				+ "                \"name\": \"电影推荐\",\r\n"
				+ "                \"key\": \"the_big_brother_need_your_phone\"\r\n" + "            },\r\n"
				+ "            {\r\n" + "                \"name\": \"菜单\",\r\n"
				+ "                \"sub_button\": [\r\n" + "                    {\r\n"
				+ "                        \"type\": \"view\",\r\n" + "                        \"name\": \"更多电影\",\r\n"
				+ "                        \"url\": \"http://apps.weibo.com/1838358847/8rYu1uHD\"\r\n"
				+ "                    },\r\n" + "                    {\r\n"
				+ "                        \"type\": \"view\",\r\n" + "                        \"name\": \"精美图片\",\r\n"
				+ "                        \"url\": \"http://apps.weibo.com/1838358847/8s1i6v74\"\r\n"
				+ "                    },\r\n" + "                    {\r\n"
				+ "                        \"type\": \"click\",\r\n" + "                        \"name\": \"小故事\",\r\n"
				+ "                        \"key\": \"memeda\"\r\n" + "                    }\r\n"
				+ "                ]\r\n" + "            }\r\n" + "        ]\r\n" + "    }\r\n" + "}";
		String s = "access_token=" + accessToken + "&menus=" + p2;

		createMenu(s);

	}

}