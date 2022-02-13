package member.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.dto.ReserveDTO;
import member.model.dto.ShowMovieDTO;
import member.model.dto.UserDTO;
import member.model.service.ReserveService;
import member.view.ReserveResult;

public class ReserveController {
	/* view단에서 입력받은 정보를 가공하여 service로 전달*/
	private ReserveService reserveService = new ReserveService();
	private ReserveResult reserveResult = new ReserveResult();
	
	/* 회원 등록용 메소드 */
	public void registNewMember(Map<String, String> requestMap) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(requestMap.get("id"));
		userDTO.setUserPwd(requestMap.get("pwd"));
		userDTO.setName(requestMap.get("name"));
		userDTO.setPhone(requestMap.get("phone"));
		userDTO.setAge(requestMap.get("age"));
		
		int registResult = reserveService.insertUser(userDTO);
		
		if(registResult > 0) {
			reserveResult.displayDmlResult("insertSuccess");
		} else {
			reserveResult.displayDmlResult("insertFailed");
		}
	}
	
	
	/* 모든 영화 조회용 메소드 */
	public int selectAllMovie() {
		int result = -1;
		
		List<MovieDTO> movieList = reserveService.selectAllMovie();
		
		if(!movieList.isEmpty()) {
			reserveResult.displayMovie1(movieList);
		 	result=1;
		}else {
			System.out.println("영화 목록이 없습니다.");			
		}
		return result;
	}
	
	public int selectIsRunMovie(int no) {
		
		int result= -1;
		List<MovieDTO> movieList = reserveService.selectAllMovie();
		
		if(!movieList.isEmpty()) {
			if(no==2) 
				reserveResult.displayMovie2(movieList);
			if(no==3)
				reserveResult.displayMovie3(movieList);
		 	result=1;
		}else {
			System.out.println("영화 목록이 없습니다.");			
		}
		
		return result;
	}
	
	
	/* 상영관 목록 조회용 메소드 */
	public List<CinemaDTO> selectCinemaList() {
		
		List<CinemaDTO> cinemaList = reserveService.selectAllCinema();
		
		return cinemaList;
		
	}
	
	/* 선택한 상영관 조회용 메소드 */
	public int selectCinema(int cineNo) {
		
		String cineName = null;
		int result = -1;
		
		switch(cineNo) {
		case 1 : cineName = "씨네역삼"; break;
		case 2 : cineName = "씨네인천"; break;
		case 3 : cineName = "씨네부산"; break;
		case 4 : cineName = "씨네광주"; break;
		case 5 : cineName = "씨네울산"; break;
		case 6 : cineName = "씨네부천"; break;
		default : System.out.println("잘못된 번호입니다. 다시 입력해주세요."); break;
		}
		
		if(cineName != null) {
			CinemaDTO cinema = reserveService.selectCinema(cineName);
			ReserveResult.display(cinema);
			result = 1;
		}
		return result;
	}

	/* 영화 예매 내역 조회용 메소드 */
	public void selectReservation(String inputUserId) {
		
		List<ReserveDTO> reserve = reserveService.selectReservation(inputUserId);
		
		if(!reserve.isEmpty()) {
			reserveResult.display(reserve);			
		} else {
			reserveResult.displayDmlResult("selectFailed");
		}
		
	}

	/* 영화 예매 취소용 메소드 */
	public void deleteReservation(String inputUserId) {
		
		int registResult = reserveService.deleteReservation(inputUserId);
		
		if(registResult > 0) {
			reserveResult.displayDmlResult("deleteSuccess");
		} else {
			reserveResult.displayDmlResult("deleteFailed");
		}	
		
	}

	/* id로 회원 조회용 메소드 */
	public List<UserDTO> searchUserById(String userId) {
		
		List<UserDTO> userList = reserveService.selectById(userId);
		
		return userList;
	}

	/* 영화 예매 - 상영관 조회용 메소드 */
	public List<CinemaDTO> selectAllCinema() {
		
		List<CinemaDTO> cinemaList = reserveService.selectAllCinema();
		
		return cinemaList;
	}

	/* 영화 예매 - 상영관의 예매 가능 영화 조회용 메소드 */
	public List<ShowMovieDTO> selectAllCineMovie(String cinemaName) {
		
		List<ShowMovieDTO> smList = reserveService.selectAllCineMovie(cinemaName);
		
		return smList;
	}

}
