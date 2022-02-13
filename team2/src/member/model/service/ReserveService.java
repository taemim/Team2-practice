package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import member.model.dao.ReserveDAO;
import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.dto.ReserveDTO;
import member.model.dto.ShowMovieDTO;
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
		
		List<MovieDTO> movieList = new ArrayList<>();
		
		movieList = reserveDAO.selectAllMovie(con);
		
		close(con);
		
		return movieList;
				
	}
	/* 장르별 영화 조회 메소드 */
	public List<MovieDTO> selectMovByGanre(String genre) {
		con = getConnection();
		
		List<MovieDTO> movieList = new ArrayList<>();
		
		movieList = reserveDAO.selectMovieByGenre(con, genre);
		
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

	/* 예매 조회용 메소드 */
	public List<ReserveDTO> selectReservation(String inputUserId) {
		
		Connection con = getConnection();
		
		List<ReserveDTO> reserve = reserveDAO.selectReservation(con, inputUserId);
		
		close(con);
		
		return reserve;
	}
	
	/* 예매 삭제용 메소드 */
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


	/* id로 회원 조회용 메소드 */
	public UserDTO selectById(String userId) {
		
		Connection con = getConnection();
		
		UserDTO user = new UserDTO();
		
		user = reserveDAO.selectById(con, userId);
		
		close(con);
		
		return user;
	}

	/* 영화 예매 - 상영관의 예매 가능 영화 조회용 메소드 */
	public List<ShowMovieDTO> selectAllCineMovie(String cinemaName) {
		
		Connection con = getConnection();
		
		List<ShowMovieDTO> smList = reserveDAO.selectAllCineMovie(con, cinemaName);
		
		close(con);
		
		return smList;
	}
	
	/* 영화 예매 insert 메소드*/
	public int insertReserve(UserDTO user ,ShowMovieDTO showMovie, int peopleNo , String seatNo) {
		Connection con = getConnection();
		int result =0;
		
		result = reserveDAO.insertReserve(con, user, showMovie, peopleNo, seatNo);
		
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
		
		return result;
	
	}

}
