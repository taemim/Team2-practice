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
			pstmt.setInt(5, user.getAge());
			
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

}


