package respMessage;
/**
 * 音乐消息
 * 
 * @author qp
 * @date 2018-05-7
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}