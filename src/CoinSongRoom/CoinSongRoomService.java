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
			System.out.print("아이디 > ");
			coinSongRoomDTO.setId(sc.next());

			System.out.print("비밀번호 > ");
			coinSongRoomDTO.setPassword(sc.next());
			System.out.print("닉네임 > ");
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
		System.out.print("아이디 > ");
		String id = sc.next();
		System.out.print("비밀번호 > ");
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
		
		System.out.println("-----------------\t현재잔액 :" + "원"+ "----------");
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
			System.out.println("20220405 아이브 - LOVE DIVE");
		}else if(singer == "임영웅") {
			System.out.println("20221017 아이들 - Nxde");
		}else {
			System.out.println("조회할 수 없습니다. 다시 입력하세요. ");
		}
	}
	
	public void singStart() {
		System.out.println("번호 입력 > ");
		int num = sc.nextInt();
		
		if(num ==20230102) {
			System.out.println("🎙 : I got no time to lose / 내 길었던 하루 / 난 보고 싶어 / Ra-ta-ta-ta 울린 심장 (Ra-ta-ta-ta)");
			System.out.println("🎙 : I got nothing to lose / 널 좋아한다고 / wooah wooah wooah / Ra-ta-ta-ta 울린 심장 (Ra-ta-ta-ta)");
			
			
		}else if(num ==20230206) {
			System.out.println("🎙 : 반복되는 하루에 / 시작이 되는 이 노래 / 네 옆에서 불러주겠어 / 힘내야지 뭐 어쩌겠어");
			System.out.println("🎙 : 파이팅 해야지 파이팅 해야지 / Don’t give it up Never give it up yeah / 파이팅 해야지 파이팅 해야지");
			
		}else if(num ==20220330) {
			
			System.out.println("🎙 : Let’s go! / 새로운 길의 탐험가 / Beyond the road / 껍질을 깨뜨려버리자");
			System.out.println("🎙 : 두려움은 이제 거둬 / 오로지 나를 믿어 / 지금이 바로 time to fly");
			
		}else if(num ==20220405) {
			System.out.println("🎙 : Narcissistic, my god I love it / 서로를 비춘 밤");
			System.out.println("🎙 : 아름다운 까만 눈빛 더 빠져 깊이 / (넌 내게로 난 네게로) / 숨 참고 love dive");
			
		}else if(num ==20221017) {
			System.out.println("🎙 : Yes I’m a nude / Nude 따따랏따라 / Yes I’m a nude / Nude I don’t give a love ");
			System.out.println("🎙 : Baby how do I look, how do I look / 아리따운 날 입고 따따랏따라 ");
			
		}else {
			System.out.println("조회할 수 없습니다. 다시 입력하세요.");
		}
		
		
		
		
	}
	
	
	
	
	

}
