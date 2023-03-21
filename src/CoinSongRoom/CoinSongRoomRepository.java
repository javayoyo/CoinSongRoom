package CoinSongRoom;

import java.util.ArrayList;
import java.util.List;

public class CoinSongRoomRepository {
	private static CoinSongRoomRepository repository = new CoinSongRoomRepository();

	private CoinSongRoomRepository() {
	}
	public static CoinSongRoomRepository getInstance() {
		return repository;
	}
	List<CoinSongRoomDTO> list = new ArrayList<>();

	public boolean save(CoinSongRoomDTO coinSongRoomDTO) {
		return list.add(coinSongRoomDTO);
	}
	public boolean loginCheck(String id, String password) {
		for (CoinSongRoomDTO s : list) {
			if (s.getId().equals(id) && s.getPassword().equals(password));

			return true;
		}
		return false;
	}
	public List<CoinSongRoomDTO> findAll() {
		return list;
	}

}
