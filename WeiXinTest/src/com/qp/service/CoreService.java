
package com.qp.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;



import respMessage.Article;
import respMessage.NewsMessage;
import respMessage.TextMessage;

import com.baidu.translate.demo.BaiDuTransLate;
import com.message.util.MessageUtil;
import com.message.util.TuLin;





/**
 * 核心服务类
 * 
 * @author qp
 * @date 2018-05-07
 */
public class CoreService {
	//响应消息
	public static TextMessage textMessage;
	//请求消息
	public static reqMessage.TextMessage reqMessage;
	// 发送方帐号（open_id）
	static String fromUserName;
	//消息类型
	static String msgType;
	//创建时间
	static String createTime;
	public static String showDate;
	
	public static String content ;
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = "";
		NewsMessage newsMessage = new NewsMessage();
		MessageUtil messageUtil = new MessageUtil();
		
		
		TuLin snippet = new TuLin();
		//内容
		
		
		try {
			// 默认返回的文本消息内容
			String respContent = "";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			fromUserName = requestMap.get("FromUserName");
			
			//创建时间
			createTime = requestMap.get("CreateTime");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			msgType = requestMap.get("MsgType");
			//获取的内容
			content =requestMap.get("Content");
			
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			showDate = dateFormat.format(date);
			
			
			//将消息封装到请求消息类中
			/*reqMessage.setContent(content);
			reqMessage.setFromUserName(fromUserName);*/
			// 控制台打印消息
			System.out.println("发送者：" + fromUserName);
			System.out.println("接收者：" + toUserName);
			System.out.println("消息类型：" + msgType);
			System.out.println("内容：" + requestMap.get("Content"));
			System.out.println(requestMap.get("Event"));

			// 回复文本消息
			textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			/*Date now = new Date();//默认实例化的Date表示当前系统时间
			//时间的格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//格式化当前时间
			String time = dateFormat.format(now);
			*/
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			//textMessage.setFuncFlag(0);
			/**
			 * 对事件的反应，如订阅等
			 */
			if (msgType.equals("event")) {
				//textMessage.setFromUserName("oUIYb1JruuNltArNKq_4677sEei8");
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = " 谢谢您的关注！/:rose "+"\n"
							
							+ "  1、图文/:rose"+"\n" 
							+ "  2、微信开发资源/:rose "+"\n" 
							+ "  3、公众号介绍/:rose "+"\n" 
							+ "  4、黄冈天气/:rose "+"\n" 
							+ "  5、电影资源/:rose "+"\n"
							+ "	 6、翻译（直接输入翻译内容，如：翻译中国）"+"\n";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					String eventKey = requestMap.get("EventKey");

					if(eventKey.equals("bt1")){
						respContent = TuLin.getTuLinAnswer("黄冈天气");
						
					}else if(eventKey.equals("bt2")) {
						respContent = "请输入要翻译的句子，格式为：翻译中国你好";
					}
				}
			}else if (content.equals("1") || content.equals("图文")) {
				// 创建图文消息

				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				
			
				newsMessage.setCreateTime( System.currentTimeMillis());
				newsMessage.setMsgType(messageUtil.RESP_MESSAGE_TYPE_NEWS);
				// newsMessage.setFuncFlag(0);

				List<Article> articleList = new ArrayList<Article>();
				// 单图文消息

				Article article = new Article();
				article.setTitle("图片");
				article.setDescription("开发测试 @author:秦鹏");
				article.setPicUrl(
						"http://www.iteye.com/upload/logo/user/603624/2dc5ec35-073c-35e7-9b88-274d6b39d560.jpg");
				article.setUrl("http://45.40.205.96/Login/");
				articleList.add(article);
				// 设置图文消息个数
				newsMessage.setArticleCount(articleList.size());
				// 设置图文消息包含的图文集合
				newsMessage.setArticles(articleList);
				// 将图文消息对象转换成xml字符串
				respMessage = messageUtil.newsMessageToXml(newsMessage);
				System.out.println(respMessage);
				return respMessage;
			}else if(content.equals("2") || content.equals("微信开发资源") ) {
				//多图文消息
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(messageUtil.RESP_MESSAGE_TYPE_NEWS);
				
				List<Article> articleList = new ArrayList<Article>();
				Article article1 = new Article();
				article1.setTitle("微信开发资源");
				article1.setDescription("");
				article1.setPicUrl("http://www.iteye.com/upload/logo/user/603624/2dc5ec35-073c-35e7-9b88-274d6b39d560.jpg");
				article1.setUrl("http://tuposky.iteye.com/blog/2008583");

				Article article2 = new Article();
				article2.setTitle("微信公众平台开发教程Java版（二）接口配置 ");
				article2.setDescription("");
				article2.setPicUrl("http://www.isic.cn/viewResourcesAction//logo/20131021/2013102111243367254.jpg");
				article2.setUrl("http://tuposky.iteye.com/blog/2008655");

				Article article3 = new Article();
				article3.setTitle("微信公众平台开发教程Java版(三) 消息接收和发送");
				article3.setDescription("");
				article3.setPicUrl("http://www.isic.cn/viewResourcesAction//logo/20131021/2013102111291287031.jpg");
				article3.setUrl("http://tuposky.iteye.com/blog/2017429");

				articleList.add(article1);
				articleList.add(article2);
				articleList.add(article3);
				newsMessage.setArticleCount(articleList.size());
				newsMessage.setArticles(articleList);
				respMessage = messageUtil.newsMessageToXml(newsMessage);
				System.out.println(respMessage);
				return respMessage;
			} else if(content.equals("3") || content.equals("公众号介绍") ) {
				//公众号介绍
				respContent = "您好！欢迎关注我的公众号/:rose/:rose"+"\n"
							+"  本公众号是本人用来做微信开发的"+"\n"
							+"功能暂时还不完善,敬请期待/:rose/:rose";
				
			}else if(content.equals("黄冈天气") || content.equals("4")
					|| content.equals("天气")) {
				//天气信息
				
				
				String tuLingRsp = snippet.getTuLinAnswer("黄冈天气");
				
				respContent = tuLingRsp;
				
			}else if(content.equals("你是谁")){
				String tuLingRsp = snippet.getTuLinAnswer("你是谁");
				
				respContent = tuLingRsp+"\n"+
						 "        请输入以下关键字/:rose"+"\n"
					     + "  1、图文/:rose"+"\n"
					     + "  2、微信开发资源/:rose"+"\n"
					     + "  3、公众号介绍/:rose"+"\n"
					     + "  4、黄冈天气/:rose"+"\n"
					     + "  5、电影资源/:rose"+"\n";;
				
				
				
			}else if(content.equals("5") || content.equals("电影") || content.equals("电影资源")) {
				
				// 创建电影图文消息，资源来自我的百度云盘分享
				
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(messageUtil.RESP_MESSAGE_TYPE_NEWS);
				// newsMessage.setFuncFlag(0);

				List<Article> articleList = new ArrayList<Article>();
				

				Article article = new Article();
				article.setTitle("我滴个神啊 ，极力推荐的一部印度片   云盘密码：yrs2");
				article.setDescription("");
				article.setPicUrl(
						"http://img31.mtime.cn/mg/2015/10/25/171834.31683959.jpg");
				article.setUrl("https://pan.baidu.com/s/1-__PZOqz85TJjHaWrO8EnQ");
				articleList.add(article);
				
				
				Article article2 = new Article();
				article2.setTitle("红海行动，不可错过的一部电影  "+"\n"+"云盘密码：pobf");
				article2.setDescription("云盘密码：pobf");
				article2.setPicUrl("https://tse1-mm.cn.bing.net/th?id=OIP._iBVeX9odkv2Pto3_wWe0QHaEK&w=252&h=160&c=7&o=5&pid=1.7");
				article2.setUrl("https://pan.baidu.com/s/1MpWRiaN-qP_iYLp8bg8rRg");
				
				//链接：https://pan.baidu.com/s/1GqliBDE4IxFp7Z3s4_EJ8A 密码：g5ye
				Article article3 = new Article();
				article3.setTitle("无问西东  云盘密码：g5ye ");
				article3.setDescription("");
				article3.setPicUrl("http://ent.chinadaily.com.cn/img/attachement/jpg/site1/20171130/64006a47a4491b89b3360a.jpg");
				article3.setUrl("https://pan.baidu.com/s/1GqliBDE4IxFp7Z3s4_EJ8A");
				
				Article article4 = new Article();
				article4.setTitle("更多电影 ");
				article4.setDescription("");
				article4.setPicUrl("");
				article4.setUrl("http://45.40.205.96/MyVideo/");
				
				//将article 添加到集合中，形成多图文
				articleList.add(article);
				articleList.add(article2);
				articleList.add(article3);
				articleList.add(article4);
				// 设置图文消息个数
				newsMessage.setArticleCount(articleList.size());
				// 设置图文消息包含的图文集合
				newsMessage.setArticles(articleList);
				// 将图文消息对象转换成xml字符串
				respMessage = messageUtil.newsMessageToXml(newsMessage);
				System.out.println(respMessage);
				return respMessage;
			}else if(requestMap.get("Content").startsWith("翻译")){
				
				String transLate = BaiDuTransLate.transLate(requestMap.get("Content").substring(2));
				respContent = "翻译内容为"+transLate;
			}else {
				//告诉客户关键字查询
				String tuLinMess =TuLin.getTuLinAnswer(requestMap.get("Content"));
				respContent =tuLinMess+"\n"+
						"        请输入以下关键字/:rose"+"\n"
						     + "  1、图文/:rose"+"\n"
						     + "  2、微信开发资源/:rose"+"\n"
						     + "  3、公众号介绍/:rose"+"\n"
						     + "  4、黄冈天气/:rose"+"\n"
						     + "  5、电影资源/:rose"+"\n"
						     + "  6、翻译（直接输入翻译内容，如：翻译中国）"+"\n";
			}
			
			textMessage.setContent(respContent);
			respMessage = MessageUtil.MessageToXml(textMessage);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}

