package member.view;

import java.util.List;

import member.model.dto.CinemaDTO;
import member.model.dto.MovieDTO;

public class ReserveResult {

	/* 출력할 결과 메소드 작성 */

	public static void display(List<MovieDTO> movieList) {
		for(MovieDTO movie : movieList) 
			System.out.println(movie);
	}

	public static void display(CinemaDTO cinema) {
		System.out.println(cinema);
	}
}