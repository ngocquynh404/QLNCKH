package Models;

public class thongbao {
	private String mathongbao;
	private String tenthongbao;
	private String noidung;
	private String ngaygui;
	private String matk;
	public thongbao() {
		super();
	}
	public thongbao(String mathongbao, String tenthongbao, String noidung, String ngaygui, String matk) {
		super();
		this.mathongbao = mathongbao;
		this.tenthongbao = tenthongbao;
		this.noidung = noidung;
		this.ngaygui = ngaygui;
		this.matk = matk;
	}
	public String getMathongbao() {
		return mathongbao;
	}
	public void setMathongbao(String mathongbao) {
		this.mathongbao = mathongbao;
	}
	public String getTenthongbao() {
		return tenthongbao;
	}
	public void setTenthongbao(String tenthongbao) {
		this.tenthongbao = tenthongbao;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getNgaygui() {
		return ngaygui;
	}
	public void setNgaygui(String ngaygui) {
		this.ngaygui = ngaygui;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	
	
}
