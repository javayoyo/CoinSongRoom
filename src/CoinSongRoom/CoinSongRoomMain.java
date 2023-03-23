package CoinSongRoom;

import java.util.Scanner;

public class CoinSongRoomMain {

	private static final CoinSongRoomService CoinSongRoomservice = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CoinSongRoomService service = CoinSongRoomService.getInstance();

		boolean loginOk = false;

		while (true) {
			System.out.println("=🎙=🎵=🎵=🎵=♬=♪=🎙=코 인 노 래 방=🎙=♪=♬=🎵=🎵=🎵=🎙=");

			if (loginOk) {
				System.out.println("┌──────────────────────────────────────────────┐");
				System.out.println("|  1.코인충전 2.가수검색 3.노래시작 4.통합내역            |");
				System.out.println("| 5.추천노래 6.비밀번호수정 7.회원탈퇴 8.로그아웃 0.종료    |");
				System.out.println("└──────────────────────────────────────────────┘");

			} else {
				System.out.println("┌──────────────────────────────────────────────┐");
				System.out.println("|       1.회원가입  2.로그인  3.리스트 0.종료          |");
				System.out.println("└──────────────────────────────────────────────┘");
			}

			System.out.print("선택 > ");

			int menu = sc.nextInt();

			if (menu == 1) {
				if (loginOk) {

					service.coinCharge();

				} else {
					service.save();
				}

			} else if (menu == 2) {
				if (loginOk) {
					service.search();

				} else {
					loginOk = service.loginCheck();
				}

			} else if (menu == 3) {

				if (loginOk) {
					service.singStart();
					service.coinUse();
					
					

				} else {
					service.findAll();
				}
			} else if (menu == 4 && loginOk) {
				service.findById();

			} else if (menu == 5 && loginOk) {
				service.recommend();

			} else if (menu == 6 && loginOk) {
				service.update();

			} else if (menu == 7 && loginOk) {
				service.delete();
				loginOk = false;

			} else if (menu == 8 && loginOk) {
				service.logout();
				loginOk = false;

			} else if (menu == 0) {

				break;

			} else {
				System.out.println("다시입력");
			}
			System.out.println();

		}
		System.out.println("프로그램 종료");
	}

}
