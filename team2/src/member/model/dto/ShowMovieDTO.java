package member.model.dto;

import java.sql.Date;

public class ShowMovieDTO {

	private String cinemaNo;
	private String cinemaName;
	private String movieName;
	private Date runDay;
	private String runTime;
	private int seatCapacity;
	private int price;
	
	public ShowMovieDTO() {}

	public ShowMovieDTO(String cinemaNo, String cinemaName, String movieName, Date runDay, String runTime,
			int seatCapacity, int price) {
		super();
		this.cinemaNo = cinemaNo;
		this.cinemaName = cinemaName;
		this.movieName = movieName;
		this.runDay = runDay;
		this.runTime = runTime;
		this.seatCapacity = seatCapacity;
		this.price = price;
	}

	public String getCinemaNo() {
		return cinemaNo;
	}

	public void setCinemaNo(String cinemaNo) {
		this.cinemaNo = cinemaNo;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getRunDay() {
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

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShowMovieDTO [cinemaNo=" + cinemaNo + ", cinemaName=" + cinemaName + ", movieName=" + movieName
				+ ", runDay=" + runDay + ", runTime=" + runTime + ", seatCapacity=" + seatCapacity + ", price=" + price
				+ "]";
	}
	
}
