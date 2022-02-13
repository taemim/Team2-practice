package member.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import member.controller.ReserveController;
import member.model.dto.CinemaDTO;

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
			case 2 : reserveController.selectAllMovie(); break; 
			case 3 : selectCinema(); break; 
			case 4 : break; 
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
	
	/* 상영관 조회 메뉴 */
	public void selectCinema() {
		
		System.out.println("\n*** 상영관 목록 조회 ***");

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
	
	
	
	/* 영화 수정 입력단 */
	
	
}
