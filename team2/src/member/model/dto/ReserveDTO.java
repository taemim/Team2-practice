package member.model.dto;

public class ReserveDTO {
	
	private int reserveNo;
	private String userId;
	private String cinemaNo;
	private int pplNum;
	private String seatsNo;
	private int price;
	
	public ReserveDTO() {}

	public ReserveDTO(int reserveNo, String userId, String cinemaNo, int pplNum, String seatsNo, int price) {
		super();
		this.reserveNo = reserveNo;
		this.userId = userId;
		this.cinemaNo = cinemaNo;
		this.pplNum = pplNum;
		this.seatsNo = seatsNo;
		this.price = price;
	}

	public int getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCinemaNo() {
		return cinemaNo;
	}

	public void setCinemaNo(String cinemaNo) {
		this.cinemaNo = cinemaNo;
	}

	public int getPplNum() {
		return pplNum;
	}

	public void setPplNum(int pplNum) {
		this.pplNum = pplNum;
	}

	public String getSeatsNo() {
		return seatsNo;
	}

	public void setSeatsNo(String seatsNo) {
		this.seatsNo = seatsNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ReserveDTO [reserveNo=" + reserveNo + ", userId=" + userId + ", cinemaNo=" + cinemaNo + ", pplNum="
				+ pplNum + ", seatsNo=" + seatsNo + ", price=" + price + "]";
	}

}
