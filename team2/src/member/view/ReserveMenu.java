package member.view;

import java.util.Scanner;

import member.controller.ReserveController;

public class ReserveMenu {

	Scanner sc = new Scanner(System.in);

	public void displayMenu() {

		ReserveController reserveController = new ReserveController();

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
			case 3 : break; 
			case 4 : break; 
			case 5 : break; 
			case 6 : break; 
			case 7 : return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");break;
			
			}

		} while (true);
	}
	/* 회원 등록을 위한 정보를 입력받기*/

	
	/* 영화 조회 메뉴 */

	
	/* 영화 수정 입력단 */
	
	
}
