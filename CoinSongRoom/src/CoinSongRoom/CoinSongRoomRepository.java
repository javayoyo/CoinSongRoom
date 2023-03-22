package CoinSongRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CoinSongRoomRepository {
	
	Map<String, CoinSongRoomDTO> sMap = new HashMap<>();
	
	
	private static CoinSongRoomRepository repository = new CoinSongRoomRepository();
	private CoinSongRoomRepository() {}
	public static CoinSongRoomRepository getInstance() {
	return repository;
	}

	List<CoinSongRoomDTO> cList = new ArrayList<>();
	List<BreakdownDTO> bList = new ArrayList<>();
	

	public boolean save(CoinSongRoomDTO coinSongRoomDTO) {
	return cList.add(coinSongRoomDTO);
	}

	public boolean loginCheck(String id, String password) {
	for(CoinSongRoomDTO c : cList) {
	if(c.getId().equals(id) && c.getPassword().equals(password)) {
	return true;
	}
	}return false;
	}
	public List<CoinSongRoomDTO> findAll(){
	return cList;
	}
	public String getCno(String id, String password) {
		for(CoinSongRoomDTO c : cList) {
		if(c.getId().equals(id) && c.getPassword().equals(password)) {
		return c.getCno();
		}
		}
		return null;
		}
	
	public boolean coinCharge (String cno, long money) {
		for(CoinSongRoomDTO c : cList) {
		if(c.getCno().equals(cno)) {
		c.setBalance(c.getBalance()+money);
		BreakdownDTO breakdownDTO = new BreakdownDTO();
		breakdownDTO.setCno(cno);
		breakdownDTO.setDivision("충전");
		breakdownDTO.setDealMoney(money);
		breakdownDTO.setTotalMoney(c.getBalance());
		bList.add(breakdownDTO);
		return true;
		}
		}
		return false;
		}
	
	
	public boolean update(String id, String password, String updatePassword) {
		for(CoinSongRoomDTO c : cList) {
		if(c.getId().equals(id) && c.getPassword().equals(password)) {
		c.setPassword(updatePassword);
		return true;
		}
		}
		return false;
		}

		public boolean delete(String id,String password) {
		for(CoinSongRoomDTO c : cList) {
		if(c.getId().equals(id) && c.getPassword().equals(password)) {
		cList.remove(c);
		return true;
		}
		}
		return false;
		}
	

}
