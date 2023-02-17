package semi.movie.vo;

public class movieVo {

	private int ranks;
	private String title;
	private double percent;
	private double egg;
	@Override
	public String toString() {
		return "movieVo [ranks=" + ranks + ", title=" + title + ", percent=" + percent + ", egg=" + egg + "]";
	}
	public int getRanks() {
		return ranks;
	}
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public double getEgg() {
		return egg;
	}
	public void setEgg(double egg) {
		this.egg = egg;
	}
	
	
	
	

	

}
