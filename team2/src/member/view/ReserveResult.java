package member.view;

import java.util.List;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;
import member.model.dto.ReserveDTO;

public class ReserveResult {

	/* 출력할 결과 메소드 작성 */
	public void displayDmlResult(String code) {
		
		switch(code) {
			case "insertFailed" : System.out.println("회원 가입 실패!"); break;
			case "updateFailed" : System.out.println("회원 정보 수정 실패!"); break;
			case "deleteFailed" : System.out.println("예매가 취소되지 않았습니다. 다시 시도해주세요."); break;
			case "selectFailed" : System.out.println("예매 내역을 찾을 수 없습니다."); break;
			case "insertSuccess" : System.out.println("insert 성공!"); break;
			case "deleteSuccess" : System.out.println("예매가 정상적으로 취소되었습니다."); break;		
			default : System.out.println("알 수 없는 에러 발생!"); break;
		}
		
	}

	public void display1(List<MovieDTO> movieList) {
		for(MovieDTO movie : movieList) 
			System.out.println(movie);
	}

	public static void display(CinemaDTO cinema) {
		System.out.println(cinema);
	}

	public void display(List<ReserveDTO> reserveList) {
		for(ReserveDTO reserve : reserveList) 
			System.out.println(reserve);
		
	}
}