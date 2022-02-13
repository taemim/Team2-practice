package member.model.dto;

import java.sql.Date;

public class ReserveDTO {
	
	private int reserveNo;
	private String movieName;
	private String cinemaName;
	private java.sql.Date runDay;
	private String runTime;
	private String userName;
	private int pplNum;
	private String seatsNo;
	private int price;
	
	public ReserveDTO() {}

	public ReserveDTO(int reserveNo, String movieName, String cinemaName, Date runDay, String runTime, String userName,
		int pplNum, String seatsNo, int price) {
		super();
		this.reserveNo = reserveNo;
		this.movieName = movieName;
		this.cinemaName = cinemaName;
		this.runDay = runDay;
		this.runTime = runTime;
		this.userName = userName;
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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public java.sql.Date getRunDay() {
		return runDay;
	}

	public void setRunDay(Date runDay) {
		this.runDay = runDay;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return  "\n *** 예매 내역 ***" 
				+ "\n예약번호 :" + reserveNo 
				+ "\n영화명 : " + movieName
				+ "\n상영관 : " + cinemaName 
				+ "\n날짜 : " + runDay 
				+ " 시간 : " + runTime
				+ "\n이름 : " + userName 
				+ "\n인원 : " + pplNum
				+ "\n좌석번호 :" + seatsNo 
				+ "\n가격 : " + price +"\n";
	}


}
