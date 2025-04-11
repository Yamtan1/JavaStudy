package MemberPack0411;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private String bno;
	private String title;
	private String content;
	private String writter;
	private String regdate;
	private static List<Board> boardList = new ArrayList<>();
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public static List<Board> getBoardList() {
		return boardList;
	}

	// 멤버를 추가하는 메서드
	public static void addBoard(Board b) {
		boardList.add(b);
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writter=" + writter + ", regdate="
				+ regdate + "]";
	}
}
