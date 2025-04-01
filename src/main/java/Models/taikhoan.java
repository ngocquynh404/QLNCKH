package Models;

public class taikhoan {
	private String MaTK;
	private String UserName;
	private String Email;
	private String Password;
	private String MaLTK;
	
	public taikhoan() {
		super();
		
	}
	public taikhoan( String userName, String password) {
		super();		
		this.UserName = userName;		
		this.Password = password;		
	}
	public taikhoan(String maTK, String userName, String email, String password, String maLTK) {
		super();
		MaTK = maTK;
		UserName = userName;
		Email = email;
		Password = password;
		MaLTK = maLTK;
	}
	public String getMaTK() {
		return MaTK;
	}
	public void setMaTK(String maTK) {
		MaTK = maTK;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getMaLTK() {
		return MaLTK;
	}
	public void setMaLTK(String maLTK) {
		MaLTK = maLTK;
	}
	
}
