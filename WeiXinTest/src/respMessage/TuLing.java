package respMessage;

public class TuLing {
	//图灵接口
	//输入类型:0-文本(默认)、1-图片、2-音频
	private int reqType;
	//输入信息
	private  String perception;
	//用户参数
	private String userInfo;
	

	public String getApiPass() {
		return apiPass;
	}
	public String getUrl() {
		return url;
	}
	//图灵机器人密码
	private final String apiPass = "84bf20d571247c5b";
	
	//接口地址
	private final String url = "http://openapi.tuling123.com/openapi/api/v2";
	
	//得到输入类型
	public int getReqType() {
		return reqType;
	}
	//设置输入类型
	public void setReqType(int reqType) {
		this.reqType = reqType;
	}
	//得到输入信息
	public String getPerception() {
		return perception;
	}
	//设置输入信息
	public void setPerception(String perception) {
		this.perception = perception;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getApikey() {
		// TODO Auto-generated method stub
		return null;
	}

}
