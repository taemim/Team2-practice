package member.controller;

import java.util.List;
import java.util.Map;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.dto.ReserveDTO;
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
		userDTO.setAge(Integer.valueOf(requestMap.get("age")));
		
		int registResult = reserveService.insertUser(userDTO);
		
		if(registResult > 0) {
			reserveResult.displayDmlResult("insertSuccess");
		} else {
			reserveResult.displayDmlResult("insertFailed");
		}
	}
	
	
	/* 영화 조회용 메소드 */
	public void selectAllMovie() {
		
		List<MovieDTO> movieList = reserveService.selectAllMovie();
		
		if(!movieList.isEmpty()) 
			reserveResult.display1(movieList);
		else 
			System.out.println("조회실패!");
		
	}
	
	/* 상영관 목록 조회 */
	public List<CinemaDTO> selectCinemaList() {
		
		List<CinemaDTO> cinemaList = reserveService.selectAllCinema();
		
		return cinemaList;
		
	}
	
	public void selectCinema(String cineName) {
		
		if(cineName !=null) {
			CinemaDTO cinema = reserveService.selectCinema(cineName);
			ReserveResult.display(cinema);
		}
		else {
			System.out.println("메인메뉴로 돌아갑니다.");			
		}
	}


	public void selectReservation(String inputUserId) {
		
		List<ReserveDTO> reserve = reserveService.selectReservation(inputUserId);
		
		if(!reserve.isEmpty()) {
			reserveResult.display(reserve);			
		} else {
			reserveResult.displayDmlResult("selectFailed");
		}
		
	}
	
		
	/* 상영관 조회용 메소드 */
	
	/* 영화 예매 메소드 */
	
	/* 영화 예매 취소 메소드 */

}
