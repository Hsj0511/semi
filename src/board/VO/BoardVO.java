package board.VO;


public class BoardVO {
/**
 * board_num number,
board_writer varchar2(15),
board_content varchar2(1000),
board_date date
 */


	private int num;
	private String name;
	private String content;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", name=" + name + ", content=" + content + "]";
	}
	public void setContent(String content) {
		this.content = content;
	}

	

	
	
}