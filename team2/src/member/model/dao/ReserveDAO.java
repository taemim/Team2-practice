package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.dto.ReserveDTO;
import member.model.dto.ShowMovieDTO;
import member.model.dto.UserDTO;

public class ReserveDAO {
	
	private Properties prop = new Properties();

	public ReserveDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/reserve-query.xml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertUser(Connection con, UserDTO user) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertUser");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getAge());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
 
 
	public List<MovieDTO> selectAllMovie(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		List<MovieDTO> movieList = null; 
		
		String query = prop.getProperty("selectAllmovies");
		
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			movieList= new ArrayList<>();
			while(rset.next()) {
				
				MovieDTO movie =new MovieDTO();

				movie.setMovieName(rset.getString("MOVIE_NAME"));
				movie.setGenre(rset.getString("GENRE"));
				movie.setReleaseDate(rset.getDate("RELEASE_DATE"));
				movie.setRuningTime(rset.getInt("RUNINGTIME"));
				movie.setAgeLimit(rset.getInt("AGE_LIMIT"));
				
				movieList.add(movie);
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return movieList;
	}

	public List<MovieDTO> selectMovieByGenre(Connection con, String genre) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		List<MovieDTO> movieList = null; 
		
		String query = prop.getProperty("selectmoviesByGenre");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, genre);
			rset = pstmt.executeQuery();
			
			movieList= new ArrayList<>();
			while(rset.next()) {
				
				MovieDTO movie =new MovieDTO();

				movie.setMovieName(rset.getString("MOVIE_NAME"));
				movie.setGenre(rset.getString("GENRE"));
				movie.setReleaseDate(rset.getDate("RELEASE_DATE"));
				movie.setRuningTime(rset.getInt("RUNINGTIME"));
				movie.setAgeLimit(rset.getInt("AGE_LIMIT"));
				
				movieList.add(movie);
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return movieList;
	}

	public List<CinemaDTO> selectAllCinemaName(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		List<CinemaDTO> cinemaList = null; 
		
		String query = prop.getProperty("selectAllCinema");
		
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			cinemaList= new ArrayList<>();
			while(rset.next()) {
				
				CinemaDTO cinema =new CinemaDTO();

				cinema.setCinemaName(rset.getString("CINEMA_NAME"));
				cinema.setAddress(rset.getString("ADDRESS"));
				cinema.setPhone(rset.getString("PHONE"));
				cinema.setCloseDay(rset.getString("CLOSE_DAY"));
				
				cinemaList.add(cinema);
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return cinemaList;
	}

	public CinemaDTO selectCinema(Connection con, String cineName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		CinemaDTO cinema =new CinemaDTO();
		
		String query = prop.getProperty("selectCinema");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cineName);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				cinema.setCinemaName(rset.getString("CINEMA_NAME"));
				cinema.setAddress(rset.getString("ADDRESS"));
				cinema.setPhone(rset.getString("PHONE"));
				cinema.setCloseDay(rset.getString("CLOSE_DAY"));
				
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return cinema;
	}

	/*예매 조회용 메소드*/
	public List<ReserveDTO> selectReservation(Connection con, String inputUserId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReserveDTO> reserveList = null;
		
		String query = prop.getProperty("selectReservation");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputUserId);
			
			rset = pstmt.executeQuery();
			
			reserveList = new ArrayList<>();

			while(rset.next()) {
				ReserveDTO reserve = new ReserveDTO();
				reserve.setReserveNo(rset.getInt("RESERVE_NO"));				
				reserve.setMovieName(rset.getString("MOVIE_NAME"));
				reserve.setCinemaName(rset.getString("CINEMA_NAME"));
				reserve.setRunDay(rset.getDate("RUN_DAY"));
				reserve.setRunTime(rset.getString("RUN_TIME"));
				reserve.setUserName(rset.getString("NAME"));
				reserve.setPplNum(rset.getInt("PPL_NUM"));
				reserve.setSeatsNo(rset.getString("SEATS_NO"));
				reserve.setPrice(rset.getInt("PRICE"));
				
				reserveList.add(reserve);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reserveList;
	}

	public int deleteReserve(Connection con, String inputUserId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReservation");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputUserId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/* id로 회원 조회용 메소드 */
	public UserDTO selectUser(Connection con, String userId, String inputPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserDTO user = new UserDTO();
			
		String query = prop.getProperty("selectUser");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, inputPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				user.setUserId(rset.getString("USER_ID"));
				user.setUserPwd(rset.getString("USER_PWD"));
				user.setName(rset.getString("NAME"));
				user.setPhone(rset.getString("PHONE"));
				user.setAge(rset.getString("AGE"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}

	/* 예매 가능 영화 조회용 메소드 */
	public List<ShowMovieDTO> selectAllCineMovie(Connection con, String cinemaName) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ShowMovieDTO> cineMovieList = null;
		
		String query = prop.getProperty("selectAllCineMovie");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cinemaName);
			
			rset = pstmt.executeQuery();
			
			cineMovieList = new ArrayList<>();
			
			while(rset.next()) {
				ShowMovieDTO sm = new ShowMovieDTO();
				
				sm.setCinemaNo(rset.getString("CINEMA_NO"));
				sm.setCinemaName(rset.getString("CINEMA_NAME"));
				sm.setMovieName(rset.getString("MOVIE_NAME"));
				sm.setRunDay(rset.getDate("RUN_DAY"));
				sm.setRunTime(rset.getString("RUN_TIME"));
				sm.setSeatCapacity(rset.getInt("SEAT_CAPACITY"));
				
				cineMovieList.add(sm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cineMovieList;
	}

	public int insertReserve(Connection con, UserDTO user, ShowMovieDTO showMovie, int peopleNo , String seatNo) {
		
		PreparedStatement pstmt = null; 
		int result = 0;
		
		String query = prop.getProperty("insertReserve");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, showMovie.getCinemaNo());
			pstmt.setInt(3, peopleNo);
			pstmt.setString(4, seatNo);
			pstmt.setInt(5, (peopleNo*12000));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}

}


