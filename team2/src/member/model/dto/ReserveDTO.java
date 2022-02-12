package member.model.dto;

public class ReserveDTO {
	
	private int reserve_no;
	private String user_id;
	private int cinema_no;
	private int ppl_num;
	private String seats_no;
	private int price;
	
	public ReserveDTO() {}

	public ReserveDTO(int reserve_no, String user_id, int cinema_no, int ppl_num, String seats_no, int price) {
		super();
		this.reserve_no = reserve_no;
		this.user_id = user_id;
		this.cinema_no = cinema_no;
		this.ppl_num = ppl_num;
		this.seats_no = seats_no;
		this.price = price;
	}

	public int getReserve_no() {
		return reserve_no;
	}

	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getCinema_no() {
		return cinema_no;
	}

	public void setCinema_no(int cinema_no) {
		this.cinema_no = cinema_no;
	}

	public int getPpl_num() {
		return ppl_num;
	}

	public void setPpl_num(int ppl_num) {
		this.ppl_num = ppl_num;
	}

	public String getSeats_no() {
		return seats_no;
	}

	public void setSeats_no(String seats_no) {
		this.seats_no = seats_no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ReserveDTO [reserve_no=" + reserve_no + ", user_id=" + user_id + ", cinema_no=" + cinema_no
				+ ", ppl_num=" + ppl_num + ", seats_no=" + seats_no + ", price=" + price + "]";
	}
	
	

}
