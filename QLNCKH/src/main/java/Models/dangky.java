package Models;

public class dangky {
	private String madk;
	private String madetai;
	private String msgv;
	private String manhom;
	private String ngaydangky;
	private String linkdecuong;
	private String ghichu;
	
	public dangky() {
		super();
	}
	public dangky(String madk, String madetai, String msgv, String manhom, String ngaydangky, String linkdecuong,
			String ghichu) {
		super();
		this.madk = madk;
		this.madetai = madetai;
		this.msgv = msgv;
		this.manhom = manhom;
		this.ngaydangky = ngaydangky;
		this.linkdecuong = linkdecuong;
		this.ghichu = ghichu;
	}
	public String getMadk() {
		return madk;
	}
	public void setMadk(String madk) {
		this.madk = madk;
	}
	public String getMadetai() {
		return madetai;
	}
	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}
	public String getMsgv() {
		return msgv;
	}
	public void setMsgv(String msgv) {
		this.msgv = msgv;
	}
	public String getManhom() {
		return manhom;
	}
	public void setManhom(String manhom) {
		this.manhom = manhom;
	}
	public String getNgaydangky() {
		return ngaydangky;
	}
	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}
	public String getLinkdecuong() {
		return linkdecuong;
	}
	public void setLinkdecuong(String linkdecuong) {
		this.linkdecuong = linkdecuong;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
}
