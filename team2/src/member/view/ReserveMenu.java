package member.view;

import java.util.List;
import java.util.Scanner;

import member.controller.ReserveController;
import member.model.dto.CinemaDTO;

public class ReserveMenu {

	Scanner sc = new Scanner(System.in);
	ReserveController reserveController = new ReserveController();

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
			case 1 : break; 
			case 2 : reserveController.selectAllMovie(); break; 
			case 3 : reserveController.selectCinema(selectCinema()); break; 
			case 4 : break; 
			case 5 : break; 
			case 6 : break; 
			case 0 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요."); break;
			
			}

		} while (true);
	}
	/* 회원 등록을 위한 정보를 입력받기*/

	
	/* 상영관 조회 메뉴 */
	public String selectCinema() {
		
		System.out.println("\n*** 상영관 목록 조회 ***");
				
		List<CinemaDTO> cinemaList = reserveController.selectCinemaList();
		int num=1;
		
		for(CinemaDTO cinema : cinemaList) {
			System.out.println(num+". "+cinema.getCinemaName());
			num++;
		}
		String cineName =null;
		int no = 0;
		
		do{
			System.out.print("조회하실 상영관을 선택하세요 : ");
			no=sc.nextInt();
			
			switch(no) {
			case 1 : cineName = "씨네역삼"; no=0; continue;
			case 2 : cineName = "씨네인천"; no=0; continue;
			case 3 : cineName = "씨네부산"; no=0; continue; 
			case 4 : cineName = "씨네광주"; no=0; continue;
			case 5 : cineName = "씨네울산"; no=0; continue;
			case 6 : cineName = "씨네부천"; no=0; continue;
			default : System.out.println("잘못된 번호입니다."); continue;
			
			}
		}while(no!=0 && no<num);

		return cineName; 
	}
		
	
	/* 영화 수정 입력단 */
	
	
}
