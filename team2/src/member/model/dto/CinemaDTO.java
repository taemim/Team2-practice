package member.model.dto;

public class CinemaDTO {
	
	private int cinemaNo;
	private String cinemaName;
	private String address;
	private String phone;
	private String closeDay;
	
	public CinemaDTO() {}
	
	public CinemaDTO(String cinemaName, String address, String phone, String closeDay) {
		super();
		this.cinemaName = cinemaName;
		this.address = address;
		this.phone = phone;
		this.closeDay = closeDay;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCloseDay() {
		return closeDay;
	}

	public void setCloseDay(String closeDay) {
		this.closeDay = closeDay;
	}

	@Override
	public String toString() {
		return "[" +cinemaName + " | 주소 : " + address + " | 영업번호 : " + phone +  " | 휴점일 : "
				+ closeDay + "]";
	}

}
