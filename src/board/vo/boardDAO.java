package board.vo;

import java.sql.Date;

public class boardDAO {
/**
 * board_num number,
board_writer varchar2(15),
board_content varchar2(1000),
board_date date
 */
	
	private int boardNum;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "boardDAO [boardNum=" + boardNum + ", boardWriter=" + boardWriter + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + "]";
	}
public boardDAO(int boardNum, String boardWriter, String boardContent, Date boardDate) {
	super();
	this.boardNum = boardNum;
	this.boardWriter = boardWriter;
	this.boardContent = boardContent;
	this.boardDate = boardDate;
}
}
