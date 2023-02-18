package semi.movie.vo;

public class movieVo {

	private String rank;
	private String title;
	private String percent;
	private String egg;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getEgg() {
		return egg;
	}
	public void setEgg(String egg) {
		this.egg = egg;
	}
	@Override
	public String toString() {
		return "movieVo [rank=" + rank + ", title=" + title + ", percent=" + percent + ", egg=" + egg + "]";
	}
	
	

}
