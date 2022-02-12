package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import member.model.dao.ReserveDAO;
import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;

public class ReserveService {
	/* 커넥션 연결하고 DAO로 전달하고 리턴받은 뒤 오토커밋 */
	Connection con = null;
	ReserveDAO reserveDAO = new ReserveDAO();
	
	/* 회원 등록용 메소드 */
	
	
	/* 영화 조회용 메소드 */
	public List<MovieDTO> selectAllMovie() {
		
		Connection con = getConnection();
		
		List<MovieDTO> movieList = new ArrayList();
		
		movieList = reserveDAO.selectAllMovie(con);
		
		close(con);
		
		return movieList;
				
	}
	/* 상영관 이름 조회용 메소드 */
	public List<CinemaDTO> selectAllCinema() {
		Connection con = getConnection();
		
		List<CinemaDTO> cinemaList = new ArrayList();
		
		cinemaList = reserveDAO.selectAllCinemaName(con);
		
		close(con);
		
		return cinemaList;
	}
	
	/* 모든 상영관 조회용 메소드 */
	public CinemaDTO selectCinema(String cineName) {
		
		Connection con = getConnection();
		
		CinemaDTO cinema = new CinemaDTO();
		
		cinema= reserveDAO.selectCinema(con, cineName);
		
		close(con);
		
		return cinema;
	}
	
	
	/* 상영관 조회용 메소드 */
	
	/* 영화 예매 메소드 */
	
	/* 영화 예매 취소 메소드 */
	
}
