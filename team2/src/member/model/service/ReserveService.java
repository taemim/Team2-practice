package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import member.model.dao.ReserveDAO;
import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.dto.ReserveDTO;
import member.model.dto.UserDTO;

public class ReserveService {
	/* 커넥션 연결하고 DAO로 전달하고 리턴받은 뒤 오토커밋 */
	Connection con = null;
	private ReserveDAO reserveDAO = new ReserveDAO();
	
	/* 회원 등록용 메소드 */
	public int insertUser(UserDTO user) {
		
		con = getConnection();
		
		int result = 0;
		
		result = reserveDAO.insertUser(con, user);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	/* 모든 영화 조회용 메소드 */
	public List<MovieDTO> selectAllMovie() {
		
		con = getConnection();
		
		List<MovieDTO> movieList = new ArrayList();
		
		movieList = reserveDAO.selectAllMovie(con);
		
		close(con);
		
		return movieList;
				
	}

	
	/* 상영관 이름 조회용 메소드 */
	public List<CinemaDTO> selectAllCinema() {
		con = getConnection();
		
		List<CinemaDTO> cinemaList = new ArrayList<>();
		
		cinemaList = reserveDAO.selectAllCinemaName(con);
		
		close(con);
		
		return cinemaList;
	}
	
	/* 모든 상영관 조회용 메소드 */
	public CinemaDTO selectCinema(String cineName) {
		
		con = getConnection();
		
		CinemaDTO cinema = new CinemaDTO();
		
		cinema= reserveDAO.selectCinema(con, cineName);
		
		close(con);
		
		return cinema;
	}

	public List<ReserveDTO> selectReservation(String inputUserId) {
		
		Connection con = getConnection();
		
		List<ReserveDTO> reserve = reserveDAO.selectRevervation(con, inputUserId);
		
		close(con);
		
		return reserve;
	}

	public int deleteReservation(String inputUserId) {
		
		Connection con = getConnection();

		int result = 0;
		
		result = reserveDAO.deleteReserve(con, inputUserId);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
						
		return result;
	}

}
