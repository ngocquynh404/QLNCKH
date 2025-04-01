package Models;



public class detai {
	private String madetai;
	private String tendetai;
	private String makhoa;
	private String msgv;
	private String ngaythuchien;
	private String ngayketthuc;
	private String kinhphidukien;
	private String linkdetai;
	
	public detai() {
		super();
	}

	public detai(String madetai, String tendetai, String makhoa, String msgv, String ngaythuchien,
			String ngayketthuc, String kinhphidukien, String linkdetai) {
		super();
		this.madetai = madetai;
		this.tendetai = tendetai;
		this.makhoa = makhoa;
		this.msgv = msgv;
		this.ngaythuchien = ngaythuchien;
		this.ngayketthuc = ngayketthuc;
		this.kinhphidukien = kinhphidukien;
		this.linkdetai = linkdetai;
	}

	public String getMadetai() {
		return madetai;
	}

	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}

	public String getTendetai() {
		return tendetai;
	}

	public void setTendetai(String tendetai) {
		this.tendetai = tendetai;
	}

	public String getmakhoa() {
		return makhoa;
	}

	public void setmakhoa(String makhoa) {
		this.makhoa = makhoa;
	}

	public String getMsgv() {
		return msgv;
	}

	public void setMsgv(String msgv) {
		this.msgv = msgv;
	}

	public String  getNgaythuchien() {
		return ngaythuchien;
	}

	public void setNgaythuchien(String ngaythuchien) {
		this.ngaythuchien = ngaythuchien;
	}

	public String getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public String getKinhphidukien() {
		return kinhphidukien;
	}

	public void setKinhphidukien(String kinhphidukien) {
		this.kinhphidukien = kinhphidukien;
	}

	public String getLinkdetai() {
		return linkdetai;
	}

	public void setLinkdetai(String linkdetai) {
		this.linkdetai = linkdetai;
	}
	
	
}
