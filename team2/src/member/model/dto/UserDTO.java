package member.model.dto;

public class UserDTO {
	
	private String userId;
	private String userPwd;
	private String name;
	private String phone;
	private int age;

	public UserDTO() {}

	public UserDTO(String userId, String userPwd, String name, String phone, int age) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userPwd=" + userPwd + ", name=" + name + ", phone=" + phone + ", age="
				+ age + "]";
	}
	
	
}
