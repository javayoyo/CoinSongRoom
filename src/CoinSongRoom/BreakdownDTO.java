package CoinSongRoom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BreakdownDTO {

	private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");

	private String cno;
	private String division;
	private long dealMoney;
	private long totalMoney;
	private String dealDate;

	public BreakdownDTO() {
		this.dealDate = DTF.format(LocalDateTime.now());
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public long getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(long dealMoney) {
		this.dealMoney = dealMoney;
	}

	public long getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(long totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Override
	public String toString() {
		String str = cno + "\t" + division + "\t" + dealMoney + "\t" + totalMoney + "\t" + dealDate;
		return str;

	}
}