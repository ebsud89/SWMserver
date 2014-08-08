package swm.chat.message;

public class MessageVO {

	int mid;
	int fromid;
	int toid;
	String text = null;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getFromid() {
		return fromid;
	}
	public void setFromid(int fromid) {
		this.fromid = fromid;
	}
	public int getToid() {
		return toid;
	}
	public void setToid(int toid) {
		this.toid = toid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", fromid=" + fromid + ", toid="
				+ toid + ", text=" + text + "]";
	}
}
