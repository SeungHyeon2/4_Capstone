package ParcelProject.vo;

public class KeepRequest {
	private String name;
	private String phone;
	private String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public KeepRequest(String name, String phone, String code) {
		super();
		this.name = name;
		this.phone = phone;
		this.code = code;
	}
	public KeepRequest() {
		super();
	}
	
}
