package CoinSongRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CoinSongRoomRepository {

	Map<String, CoinSongRoomDTO> sMap = new HashMap<>();

	private static CoinSongRoomRepository repository = new CoinSongRoomRepository();

	private CoinSongRoomRepository() {
	}

	public static CoinSongRoomRepository getInstance() {
		return repository;
	}

	List<CoinSongRoomDTO> cList = new ArrayList<>();
	List<BreakdownDTO> bList = new ArrayList<>();

	public boolean save(CoinSongRoomDTO coinSongRoomDTO) {
		return cList.add(coinSongRoomDTO);
	}

	public boolean loginCheck(String id, String password) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public List<CoinSongRoomDTO> findAll() {
		return cList;

	}

	public String getCno(String id, String password) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				return c.getCno();
			}
		}
		return null;
	}

	public boolean coinCharge(String cno, long dealmoney) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getCno().equals(cno)) {
				c.setBalance(c.getBalance() + dealmoney);
				BreakdownDTO breakdownDTO = new BreakdownDTO();
				breakdownDTO.setCno(cno);
				breakdownDTO.setDivision("충전");
				breakdownDTO.setDealMoney(dealmoney);
				breakdownDTO.setTotalMoney(c.getBalance());
				bList.add(breakdownDTO);
				return true;
			}
		}
		return false;
	}

	public boolean coinUse(String cno, long money) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getCno().equals(cno)) {
				if (c.getBalance() >= money) {
					c.setBalance(c.getBalance() - money);
					BreakdownDTO breakdownDTO = new BreakdownDTO();
					breakdownDTO.setCno(cno);
					breakdownDTO.setDivision("사용");
					breakdownDTO.setDealMoney(money);
					breakdownDTO.setTotalMoney(c.getBalance());
					bList.add(breakdownDTO);
					return true;

				} else {
					System.out.println("잔액이 부족합니다");

				}
			}
		}
		return false;
	}

	public CoinSongRoomDTO singStart() {
		for (CoinSongRoomDTO c : cList) {
			return c;
		}
		return null;
	}

	public CoinSongRoomDTO findByHistory(String id, String password) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				return c;
			}
		}
		return null;
	}

	public List<BreakdownDTO> breakList(String cno) {
		List<BreakdownDTO> list = new ArrayList<>();
		for (BreakdownDTO b : bList) {
			if (b.getCno().equals(cno)) {
				list.add(b);
			}
		}
		return list;
	}

	public boolean update(String id, String password, String updatePassword) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				c.setPassword(updatePassword);
				return true;
			}
		}
		return false;
	}

	public boolean delete(String id, String password) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getId().equals(id) && c.getPassword().equals(password)) {
				cList.remove(c);
				return true;
			}
		}
		return false;
	}

	public boolean dupCheck(String id) {
		for (CoinSongRoomDTO c : cList) {
			if (c.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

}