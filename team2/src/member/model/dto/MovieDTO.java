package member.model.dto;

import java.sql.Date;

public class MovieDTO {
	
	private String movieName;
	private String genre;
	private Date releaseDate;
	private int runingTime;
	private int ageLimit;
	
	public MovieDTO() {}

	public MovieDTO(String movieName, String genre, Date releaseDate, int runingTime, int ageLimit) {
		super();
		this.movieName = movieName;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.runingTime = runingTime;
		this.ageLimit = ageLimit;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRuningTime() {
		return runingTime;
	}

	public void setRuningTime(int runingTime) {
		this.runingTime = runingTime;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieName=" + movieName + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", runingTime=" + runingTime + ", ageLimit=" + ageLimit + "]";
	}
	
	
}


