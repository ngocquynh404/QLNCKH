package Models;

public class chitietdongiahan {
	private String machitiet;
	private String msgv;
	private String madetai;
	private String ngaygiahan;
	private String ngaynhoanthanhcu;
	private String ngayhoanthanhmoi;
	private String linkdonxin;
	private String isaccept;
	public chitietdongiahan() {
		super();
	}
	public chitietdongiahan(String machitiet, String msgv, String madetai, String ngaygiahan,
			String ngaynhoanthanhcu, String ngayhoanthanhmoi, String linkdonxin, String isaccept) {
		super();
		this.machitiet = machitiet;
		this.msgv = msgv;
		this.madetai = madetai;
		this.ngaygiahan = ngaygiahan;
		this.ngaynhoanthanhcu = ngaynhoanthanhcu;
		this.ngayhoanthanhmoi = ngayhoanthanhmoi;
		this.linkdonxin = linkdonxin;
		this.isaccept = isaccept;
	}
	public String getMachitiet() {
		return machitiet;
	}
	public void setMachitiet(String machitiet) {
		this.machitiet = machitiet;
	}
	public String getMsgv() {
		return msgv;
	}
	public void setMsgv(String msgv) {
		this.msgv = msgv;
	}
	public String getMadetai() {
		return madetai;
	}
	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}
	public String getNgaygiahan() {
		return ngaygiahan;
	}
	public void setNgaygiahan(String ngaygiahan) {
		this.ngaygiahan = ngaygiahan;
	}
	public String getNgaynhoanthanhcu() {
		return ngaynhoanthanhcu;
	}
	public void setNgaynhoanthanhcu(String ngaynhoanthanhcu) {
		this.ngaynhoanthanhcu = ngaynhoanthanhcu;
	}
	public String getNgayhoanthanhmoi() {
		return ngayhoanthanhmoi;
	}
	public void setNgayhoanthanhmoi(String ngayhoanthanhmoi) {
		this.ngayhoanthanhmoi = ngayhoanthanhmoi;
	}
	public String getLinkdonxin() {
		return linkdonxin;
	}
	public void setLinkdonxin(String linkdonxin) {
		this.linkdonxin = linkdonxin;
	}
	public String getIsaccept() {
		return isaccept;
	}
	public void setIsaccept(String isaccept) {
		this.isaccept = isaccept;
	}
	
	
	
}
