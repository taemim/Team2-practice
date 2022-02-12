package member.controller;

import java.util.ArrayList;
import java.util.List;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.service.ReserveService;
import member.view.ReserveResult;

public class ReserveController {
	/* view단에서 입력받은 정보를 가공하여 service로 전달*/
	ReserveService reserveService = new ReserveService();
	/* 회원 등록용 메소드 */
	
	/* 영화 조회용 메소드 */
	public void selectAllMovie() {
		
		List<MovieDTO> movieList = reserveService.selectAllMovie();
		
		if(!movieList.isEmpty()) 
			ReserveResult.display(movieList);
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
	
		
	/* 상영관 조회용 메소드 */
	
	/* 영화 예매 메소드 */
	
	/* 영화 예매 취소 메소드 */

}
