package CoinSongRoom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class CoinSongRoomDTO {
	
private static int number = 100;
private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");

private String cno;
private String id;
private String password;
private String nickname;
private long balance;
private String joinDate;

public CoinSongRoomDTO() {
this.cno = "C"+number++;
this.joinDate = DTF.format(LocalDateTime.now());
}
public String getCno() {
return cno;
}



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public long getBalance() {
	return balance;
}

public void setBalance(long balance) {
	this.balance = balance;
}

@Override
public String toString() {
	String str = cno +"\t" + id + "\t" + password + "\t" + nickname + "\t" + balance +"\t" + joinDate ;
	return str;
}





}