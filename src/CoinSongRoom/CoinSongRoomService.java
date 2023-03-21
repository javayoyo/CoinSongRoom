package CoinSongRoom;

import java.util.List;
import java.util.Scanner;

public class CoinSongRoomService {

	
	private static CoinSongRoomService service = new CoinSongRoomService();
	private CoinSongRoomService() {
	}
	public static CoinSongRoomService getInstance() {
	return service;
	}
	private Scanner sc = new Scanner(System.in);
	private CoinSongRoomRepository repository = CoinSongRoomRepository.getInstance();
	private String loginId = null; // 전역변수로 선언
	private String loginPassword = null;

	public void save() {
		CoinSongRoomDTO coinSongRoomDTO = new CoinSongRoomDTO();
		while (true) { // 아이디 중복체크 , 중복이면 멘트, 아니면 비밀번호 입력 진행
			System.out.print("Id > ");
			coinSongRoomDTO.setId(sc.next());

			System.out.print("Password > ");
			coinSongRoomDTO.setPassword(sc.next());
			System.out.print("Nickname > ");
			coinSongRoomDTO.setNickname(sc.next());
			
			if (repository.save(coinSongRoomDTO)) {
				System.out.println( "회원가입 성공");
				break;	
			} else {
				System.out.println("회원가입 실패");
			}
		}

	}
	public boolean loginCheck() {
		System.out.print("id> ");
		String id = sc.next();
		System.out.print("password> ");
		String password = sc.next();

		if (repository.loginCheck(id, password)) { 
			loginId = id;
			loginPassword = password;
			System.out.println("로그인성공");
			return true;
		} else {
			System.out.println("로그인실패");
			return false;
		}
	}
	public void findAll() {
		List<CoinSongRoomDTO> list = repository.findAll();
		System.out.println("아이디\t\t비밀번호\t\t닉네임\t\t잔액\t\t가입일");
		System.out.println("-----------------------------------------------------------------");
		for(CoinSongRoomDTO s : list) {
			
			s.print();
		}
		
	}
	public void coinCharge() {
		System.out.println("충전금액 > ");
		long money = sc.nextLong();
		
	while (true) {

		if (money <= 0) {
		System.out.println("잔액이 부족합니다");
		System.out.println("1.충전 2.종료");
		int btn = sc.nextInt();
		if(btn == 1) {
		System.out.print("충전금액 > ");
		money = sc.nextInt()+money;
		}else if(btn == 2) {

		break;

		}
		}

	}
	}
	
	public void search() {
		System.out.println("가수 검색 > ");
		String singer = sc.next();
		
		if(singer == "뉴진스") {
			System.out.println("20230102 뉴진스 - Ditto");
		}else if(singer == "부석순") {
			System.out.println("20230206 부석순 - 파이팅해야지");
		}else if(singer == "윤하") {
			System.out.println("20220330 윤하 - 오르트 구름");
		}else if(singer == "지민") {
			System.out.println("20230317 지민 - Set Me Free Pt.2");
		}else if(singer == "임영웅") {
			System.out.println("20221017 아이들 - Nxde");
		}else {
			System.out.println("조회할 수 없습니다. 다시 입력하세요. ");
		}
	}
	
	
	
	
	

}
