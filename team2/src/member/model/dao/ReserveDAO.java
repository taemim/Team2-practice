package member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.dto.MovieDTO;
import static common.JDBCTemplate.*;

public class ReserveDAO {
	
	private Properties prop = new Properties();

	public ReserveDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/reserve-query.xml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	public List<MovieDTO> selectAllMovie(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		List<MovieDTO> movieList = null; 
		
		String query = prop.getProperty("selectAllmovies");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MovieDTO movie =new MovieDTO();
				
				movieList= new ArrayList<>();
				
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



}
