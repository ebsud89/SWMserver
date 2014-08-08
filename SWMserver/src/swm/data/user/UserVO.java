package swm.data.user;

public class UserVO {
	
	int uid;
	String uname = null;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", uname=" + uname + "]";
	}

}
