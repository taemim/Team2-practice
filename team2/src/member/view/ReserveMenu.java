package member.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import member.controller.ReserveController;
import member.model.dto.CinemaDTO;
import member.model.dto.ShowMovieDTO;
import member.model.dto.UserDTO;

public class ReserveMenu {

	private Scanner sc = new Scanner(System.in);
	private ReserveController reserveController = new ReserveController();

	public void displayMenu() {
		
		
		do {
			System.out.println("\n *** 영화 예매 프로그램 *** \n");
			System.out.println("1. 회원 등록");
			System.out.println("2. 영화 조회");
			System.out.println("3. 상영관 조회");
			System.out.println("4. 영화 예매");
			System.out.println("5. 영화 예매 조회");
			System.out.println("6. 영화 예매 취소");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			
			switch(no) {
			case 1 : reserveController.registNewMember(inputMember()); break;
			case 2 : inputMovieMenu(); break; 
			case 3 : inputCinemaMenu(); break; 
			case 4 : inputReserve(); break; 
			case 5 : reserveController.selectReservation(inputUserId()); break; 
			case 6 : reserveController.deleteReservation(inputUserId()); break; 
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요."); break;
			
			}

		} while (true);
	}
	/* 회원 등록을 위한 정보를 입력받기*/
	public Map<String, String> inputMember() {
		
		Map<String, String> map = new HashMap<>();
		System.out.print("입력할 아이디 : ");
//		sc.nextLine();
		map.put("id", sc.nextLine());
		System.out.print("입력할 비밀번호 : ");
		map.put("pwd", sc.nextLine());
		System.out.print("입력할 이름 : ");
		map.put("name", sc.nextLine());
		System.out.print("입력할 전화번호 : ");
		map.put("phone", sc.nextLine());
		System.out.print("입력할 나이 : ");
		map.put("age", sc.nextLine());	
		
		return map;

	}
	
	/* 영화 조회 메뉴 */
	public void inputMovieMenu() {
		
		System.out.println("\n*** 영화 조회 메뉴 ***\n");
		System.out.println("1. 모든 영화 목록 조회");
		System.out.println("2. 현재 개봉작 조회");
		System.out.println("3. 개봉 예정작 조회");
		System.out.println("4. 영화 장르별 조회");
		System.out.println("0. 메인 메뉴로 돌아가기");
		int result;
		
		do {
			System.out.print("메뉴를 선택하세요 : ");
			int no = sc.nextInt();
			sc.nextLine();
		
			switch(no) {
			case 1 : result = reserveController.selectAllMovie(); break;
			case 2 : result = reserveController.selectIsRunMovie(2); break; 
			case 3 : result = reserveController.selectIsRunMovie(3); break; 
			case 4 : result = reserveController.selectMovieByGenre(inputGenre()); break; 
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요."); 
					  result= -1; break;
		}
		
		} while(result < 0);
		
	}
	
	/* 장르별 영화 조회용 장르 입력 메소드 */
	private String inputGenre() {
		System.out.print("조회할 장르를 입력해주세요 : ");
		String genre = sc.nextLine();
		
		return genre;
	}
	
	/* 상영관 조회 메뉴 */
	public void inputCinemaMenu() {
		
		System.out.println("\n*** 상영관 조회 메뉴 ***");

		List<CinemaDTO> cinemaList = reserveController.selectCinemaList();
		
		int num = 1;
		
		for(CinemaDTO cinema : cinemaList) {
			System.out.println(num+". "+cinema.getCinemaName());
			num++;
		}
		
		String cineName =null;
		int cineNo;
		int result;
		
		do{
			System.out.print("조회하실 상영관을 선택하세요: ");
			cineNo=sc.nextInt();
			result = reserveController.selectCinema(cineNo);
		}while(result < 0);
	}
	
	public String inputUserId() {
		
		System.out.print("회원 아이디 : ");
		return sc.nextLine();
	}
	
	public String inputPassword() {
		
		System.out.print("회원 비밀번호 : ");
		
		return sc.nextLine();
	}
	
	/* 영화 예매 메소드 */
	public void inputReserve() {
		
		System.out.println("\n *** 회원 로그인 *** \n");
		System.out.print("회원 아이디를 입력하세요 : ");
		String inputId = sc.nextLine();
		
		/* 회원 정보 PK등록 메소드*/
		UserDTO user = new UserDTO();
		user = reserveController.searchUserById(inputId);	
		
		if(user.getName() !=null) {
		/* 상영 정보 PK등록 메소드 */
		ShowMovieDTO showMovie = inputMovie();
		
		/* 인원 입력받기 */
		System.out.print("관람하실 인원을 입력하세요 : ");
		int peopleNo = sc.nextInt();
		
		
		/* 좌석 입력받기 */
		System.out.print("좌석번호를 입력하세요 : ");
		sc.nextLine();
		String seatNo = sc.nextLine();

		reserveController.insertReserve(user, showMovie, peopleNo, seatNo);
		}
		
	}
	
	/* 상영 영화 선택 메소드 */
	public ShowMovieDTO inputMovie() {
		
		System.out.println("\n *** 영화관 선택 *** \n");
		List<CinemaDTO> cinemaList = reserveController.selectCinemaList();
		
		int num = 1;
		int No = 0;
		
		for(CinemaDTO cinema : cinemaList) {
			System.out.println(num+". "+cinema.getCinemaName());
			num++;
		}
		
		System.out.print("영화관을 선택해 주세요 : ");
		No = sc.nextInt();
		
		CinemaDTO cinema = new CinemaDTO();
		cinema = cinemaList.get(No-1);

		
		System.out.println("\n *** 예매 가능 영화 *** \n");
		List<ShowMovieDTO> movieList = reserveController.selectAllCineMovie(cinema.getCinemaName());
		
		num = 1;
		for(ShowMovieDTO showMovie : movieList) {
			System.out.println(num+". "+showMovie);
			num++;
		}
		
		System.out.print("관람하실 영화 번호를 선택하세요 : ");
		No= sc.nextInt();
		
		ShowMovieDTO inputMovie = new ShowMovieDTO();
		inputMovie = movieList.get(No-1);

		return inputMovie;
	}
				
}

