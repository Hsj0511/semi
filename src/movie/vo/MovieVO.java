package movie.vo;

public class MovieVO {

	private String rank;
	private String title;
	private String percent;
	private String egg;
	private String imgurl;
	
	
	
	
	public String getImgurl() {
		return imgurl;
	}



	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}



	public MovieVO(String rank, String title, String percent, String egg, String imgurl) {
		this.rank = rank;
		this.title = title;
		this.percent = percent;
		this.egg = egg;
		this.imgurl = imgurl;
	}
	





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
		return "movieVo [rank=" + rank + ", title=" + title + ", percent=" + percent + ", egg=" + egg + ", imgurl="
				+ imgurl + "]";
	}
	
	

}
