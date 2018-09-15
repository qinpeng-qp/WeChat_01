package respMessage;
/**
 * 文本消息
 * 
 * @author qp
 * @date 2018-05-7
 */
public class TextMessage extends BaseMessage {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setFuncFlag(int i) {
		// TODO Auto-generated method stub
		
	}
}