package menu;
/**
 * 菜单类
 * @author qp
 *
 */

public class Buttons {
	
/*	JSON样例
 * {
	  
	        "button": [
	            {
	                "type": "click",
	                "name": "获取优惠券",
	                "key": "get_groupon"
	            },
	            {
	                "type": "click",
	                "name": "查询客服电话",
	                "key": "the_big_brother_need_your_phone"
	            },
	            {
	                "name": "菜单",
	                "sub_button": [
	                    {
	                        "type": "view",
	                        "name": "网上4S店",
	                        "url": "http://apps.weibo.com/1838358847/8rYu1uHD"
	                    },
	                    {
	                        "type": "view",
	                        "name": "砍价团",
	                        "url": "http://apps.weibo.com/1838358847/8s1i6v74"
	                    },
	                    {
	                        "type": "click",
	                        "name": "么么哒",
	                        "key": "memeda"
	                    }
	                ]
	            }
	        ]
	    }
	}
*/	
	//type 选填 （与二级菜单sub_button同级时可不填）菜单的响应动作类型，目前有click
	private String type;
	//name 必填 菜单标题，不超过16个字节，子菜单不超过40个字节
	private String name;
	//url 选填 type为view时必填，网页链接，用户点击菜单可打开链接，不超过256字节
	private String url;
	//菜单的key，唯一
	private String key;
	//二级菜单对象
	private Sub_button[] sub_button;
	/**
	 * @param sub_button the sub_button to set
	 */
	public void setSub_button(Sub_button[] sub_button) {
		this.sub_button = sub_button;
	}
	
	//button数组对象
	private Buttons button[];
	
	
	/**
	 * @return the button
	 */
	public Buttons[] getButton() {
		return button;
	}
	/**
	 * @param button the button to set
	 */
	public void setButton(Buttons[] button) {
		this.button = button;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
