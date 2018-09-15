package reqMessage;
/**
 * 文本消息
 * 
 * @author qp
 * @date 2018/5/7
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}