package member.view;

import java.util.List;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;

public class ReserveResult {

	/* 출력할 결과 메소드 작성 */
	public void displayDmlResult(String code) {
		
		switch(code) {
			case "insertFailed" : System.out.println("회원 가입 실패!"); break;
			case "updateFailed" : System.out.println("회원 정보 수정 실패!"); break;
			case "deleteFailed" : System.out.println("회원 탈퇴 실패!"); break;
			case "selectFailed" : System.out.println("회원 조회 실패!"); break;
			case "insertSuccess" : System.out.println("insert 성공!"); break;
			case "updateSuccess" : System.out.println("update 성공!"); break;		
			case "deleteSuccess" : System.out.println("delete 성공!"); break;		
			default : System.out.println("알 수 없는 에러 발생!"); break;
		}
		
	}

	public static void display(List<MovieDTO> movieList) {
		for(MovieDTO movie : movieList) 
			System.out.println(movie);
	}

	public static void display(CinemaDTO cinema) {
		System.out.println(cinema);
	}
}