package Models;

import java.util.Date;

public class sinhvien {
	private String mssv;
	private String hoten;
	private Date ngaysinh;
	private String gioitinh;
	private String cccd;
	private String sdt;
	private String email;
	private String diachi;
	private String manganh;
	private String lop;
	private String nienkhoa;
	private String matk;
	public sinhvien() {
		super();
	}
	public sinhvien(String mssv, String hoten, Date ngaysinh, String gioitinh, String cccd, String sdt, String email,
			String diachi, String manganh, String lop, String nienkhoa,String matk ) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cccd = cccd;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
		this.manganh = manganh;
		this.lop = lop;
		this.nienkhoa = nienkhoa;
		this.matk = matk;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getManganh() {
		return manganh;
	}
	public void setManganh(String manganh) {
		this.manganh = manganh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNienkhoa() {
		return nienkhoa;
	}
	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	
}
