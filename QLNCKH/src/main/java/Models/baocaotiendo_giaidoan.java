package Models;

public class baocaotiendo_giaidoan {
	private String magiaidoan;
	private String madetai;
	private String giaidoan;
	private String ngaybatdau;
	private String ngayketthuc;
	private String linkbaocao;
	public baocaotiendo_giaidoan() {
		super();
	}
	
	public baocaotiendo_giaidoan(String magiaidoan, String madetai, String giaidoan, String ngaybatdau,
			String ngayketthuc, String linkbaocao) {
		super();
		this.magiaidoan = magiaidoan;
		this.madetai = madetai;
		this.giaidoan = giaidoan;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
		this.linkbaocao = linkbaocao;
	}

	public String getMagiaidoan() {
		return magiaidoan;
	}
	public void setMagiaidoan(String magiaidoan) {
		this.magiaidoan = magiaidoan;
	}
	public String getMadetai() {
		return madetai;
	}
	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}
	public String getGiaidoan() {
		return giaidoan;
	}
	public void setGiaidoan(String giaidoan) {
		this.giaidoan = giaidoan;
	}
	public String getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(String ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public String getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	public String getLinkbaocao() {
		return linkbaocao;
	}
	public void setLinkbaocao(String linkbaocao) {
		this.linkbaocao = linkbaocao;
	}
	
	
}
