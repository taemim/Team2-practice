package member.controller;

import java.util.ArrayList;
import java.util.List;

import member.model.dto.MovieDTO;
import member.model.service.ReserveService;

public class ReserveController {
	/* view단에서 입력받은 정보를 가공하여 service로 전달*/
	ReserveService reserveService = new ReserveService();
	/* 회원 등록용 메소드 */
	
	/* 영화 조회용 메소드 */
	public void selectAllMovie() {
		
		List<MovieDTO> movieList = new ArrayList();
		
		movieList = reserveService.selectAllMovie();
		
		for(MovieDTO movie : movieList) {
			System.out.println(movie);
		}
	}
		
	/* 상영관 조회용 메소드 */
	
	/* 영화 예매 메소드 */
	
	/* 영화 예매 취소 메소드 */

}
