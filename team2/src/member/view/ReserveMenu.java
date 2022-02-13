package member.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import member.controller.ReserveController;
import member.model.dto.CinemaDTO;
import member.model.dto.ReserveDTO;
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
			case 4 : inputId(); break; 
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
		
		System.out.println("*** 영화 조회 메뉴 ***");
		System.out.println("1. 모든 영화 목록 조회");
		System.out.println("2. 현재 개봉작 조회");
		System.out.println("3. 개봉 예정작 조회");
		System.out.println("4. 영화 장르별 조회");
		System.out.println("5. 메인 메뉴로 돌아가기");
		int result;
		
		do {
			System.out.print("메뉴를 선택하세요 : ");
			int no = sc.nextInt();
		
			switch(no) {
			case 1 : result = reserveController.selectAllMovie(); break;
			case 2 : result = reserveController.selectIsRunMovie(2); break; 
			case 3 : result = reserveController.selectIsRunMovie(3); break; 
			case 4 : result = 0; break; 
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요."); 
					  result= -1; break;
		}
		
		} while(result < 0);
		
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
	
	/* 영화 예매 */

	public void inputId() {
		
		List<UserDTO> userList = new ArrayList<>();
		List<ReserveDTO> reserveList = new ArrayList<>();

		int totalReservePrice = 0;
		
		System.out.println("\n *** 영화 예매를 위한 고객 정보 확인 *** \n");
		System.out.print("고객 아이디를 입력하세요 : ");
		String userId = sc.nextLine();

		userList = reserveController.searchUserById(userId);
		
		for(UserDTO user : userList) {
			if(user.getUserId().equals(userId)) {
				System.out.println("\n *** 고객 정보가 존재합니다 *** \n");
				
				List<CinemaDTO> cinemaList = reserveController.selectAllCinema();
				
				System.out.println(" *** 예매 가능 극장 *** \n");
				
				for(int i = 0; i < cinemaList.size(); i++) {
					System.out.println((i + 1) + ". " + cinemaList.get(i).getCinemaName() + " / 주소 : " + cinemaList.get(i).getAddress() + " / 휴무일 : " + cinemaList.get(i).getCloseDay());
				}
				
				System.out.println("\n *** 영화관 선택 *** \n");
				System.out.print("영화관을 선택해 주세요 : ");
				String inputCine = sc.nextLine();
				
				String cinemaName = "";
				for(CinemaDTO cine : cinemaList) {
					if(cine.getCinemaName().equals(inputCine)) {
						cinemaName = cine.getCinemaName();
					}
				}
				
				System.out.println("\n *** 예매 가능 영화 *** \n");
				List<ShowMovieDTO> movieList = reserveController.selectAllCineMovie(cinemaName);
				for(int i = 0; i < movieList.size(); i++) {
					System.out.println((i + 1) + ". " + movieList.get(i).getMovieName() + " / 상영일 : " + movieList.get(i).getRunDay() + " / 상영 시간 : " + movieList.get(i).getRunTime() + " / 잔여 좌석 수 : " + movieList.get(i).getSeatCapacity());
				}
				

				System.out.print("\n 예매하실 영화를 선택해 주세요 : ");
				String inputMovie = sc.nextLine();
				System.out.println("\n *** 예매할 영화 *** \n");
				
				int moviePrice = 0;
				String cinemaNo = "";
				for(int i = 0; i < movieList.size(); i++) {
					
					ShowMovieDTO movie = movieList.get(i);
					
					if(movie.getMovieName().equals(inputMovie)) {
						moviePrice = movie.getPrice();
						cinemaNo = movie.getCinemaNo();
						System.out.println((i + 1) + ". " + inputMovie + " / 상영 시간 : " + movie.getRunTime() + " / 잔여 좌석 수 : " + movie.getSeatCapacity());
					}
				}
				
				System.out.print("\n 예매하실 시간을 선택해 주세요 : ");
				for(int i = 0; i < movieList.size(); i++) {
					
					ShowMovieDTO movie = movieList.get(i);
					
					String inputTime = sc.nextLine();
					movie.setRunTime(inputTime);
				}

			}
			
		}
	
	/* 영화 수정 입력단 */
	
	}
}
