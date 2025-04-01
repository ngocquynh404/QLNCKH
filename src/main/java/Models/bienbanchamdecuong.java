package Models;

public class bienbanchamdecuong {
	private String mabienban;
	private String madetai;
	private String diem;
	private String danhgia;
	private String linkbienban;
	public bienbanchamdecuong() {
		super();
	}
	public bienbanchamdecuong(String mabienban, String madetai, String diem, String danhgia, String linkbienban) {
		super();
		this.mabienban = mabienban;
		this.madetai = madetai;
		this.diem = diem;
		this.danhgia = danhgia;
		this.linkbienban = linkbienban;
	}
	public String getMabienban() {
		return mabienban;
	}
	public void setMabienban(String mabienban) {
		this.mabienban = mabienban;
	}
	public String getMadetai() {
		return madetai;
	}
	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}
	public String getDiem() {
		return diem;
	}
	public void setDiem(String diem) {
		this.diem = diem;
	}
	public String getDanhgia() {
		return danhgia;
	}
	public void setDanhgia(String danhgia) {
		this.danhgia = danhgia;
	}
	public String getLinkbienban() {
		return linkbienban;
	}
	public void setLinkbienban(String linkbienban) {
		this.linkbienban = linkbienban;
	}
}
