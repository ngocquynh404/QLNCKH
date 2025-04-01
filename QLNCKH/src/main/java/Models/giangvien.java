package Models;

public class giangvien {
	private String msgv;
	private String tengiangvien;
	private String makhoa;
	private String trinhdo;
	private String ngaysinh;
	private String cccd;
	private String sdt;
	private String gioitinh;
	private String diachi;
	private String matk;
	public giangvien() {
		super();
	}
	
	public giangvien(String msgv, String tengiangvien, String makhoa, String trinhdo, String ngaysinh, String cccd,
			String sdt, String gioitinh, String diachi,String matk) {
		super();
		this.msgv = msgv;
		this.tengiangvien = tengiangvien;
		this.makhoa = makhoa;
		this.trinhdo = trinhdo;
		this.ngaysinh = ngaysinh;
		this.cccd = cccd;
		this.sdt = sdt;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.matk = matk;
	}

	public String getMatk() {
		return matk;
	}

	public void setMatk(String matk) {
		this.matk = matk;
	}

	public String getMsgv() {
		return msgv;
	}
	public void setMsgv(String msgv) {
		this.msgv = msgv;
	}
	public String getTengiangvien() {
		return tengiangvien;
	}
	public void setTengiangvien(String tengiangvien) {
		this.tengiangvien = tengiangvien;
	}
	public String getMakhoa() {
		return makhoa;
	}
	public void setMakhoa(String makhoa) {
		this.makhoa = makhoa;
	}
	public String getTrinhdo() {
		return trinhdo;
	}
	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
}
