package Models;

public class nguoiquanly {
	private String maql;
	private String hoten;
	private String ngaysinh;
	private String matk;
	public String getMaql() {
		return maql;
	}
	public void setMql(String maql) {
		this.maql = maql;
	}
	
	public nguoiquanly() {
		super();
	}
	public nguoiquanly(String maql,String hoten, String ngaysinh, String matk) {
		super();
		this.maql= maql;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.matk = matk;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public void setMaql(String maql) {
		this.maql = maql;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	
}
