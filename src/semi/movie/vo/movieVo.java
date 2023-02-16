package semi.movie.vo;

public class movieVo {

	private int book_ranks;
	private String book_title;
	private double book_percent;
	private double book_egg;
	
	
	
	
	@Override
	public String toString() {
		return "movieVo [book_ranks=" + book_ranks + ", book_title=" + book_title + ", book_percent=" + book_percent
				+ ", book_egg=" + book_egg + ", rating_ranks=" + rating_ranks + ", rating_title=" + rating_title
				+ ", rating_percent=" + rating_percent + ", rating_egg=" + rating_egg + "]";
	}
	public int getBook_ranks() {
		return book_ranks;
	}
	public void setBook_ranks(int book_ranks) {
		this.book_ranks = book_ranks;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public double getBook_percent() {
		return book_percent;
	}
	public void setBook_percent(double book_percent) {
		this.book_percent = book_percent;
	}
	public double getBook_egg() {
		return book_egg;
	}
	public void setBook_egg(double book_egg) {
		this.book_egg = book_egg;
	}
	public int getRating_ranks() {
		return rating_ranks;
	}
	public void setRating_ranks(int rating_ranks) {
		this.rating_ranks = rating_ranks;
	}
	public String getRating_title() {
		return rating_title;
	}
	public void setRating_title(String rating_title) {
		this.rating_title = rating_title;
	}
	public double getRating_percent() {
		return rating_percent;
	}
	public void setRating_percent(double rating_percent) {
		this.rating_percent = rating_percent;
	}
	public double getRating_egg() {
		return rating_egg;
	}
	public void setRating_egg(double rating_egg) {
		this.rating_egg = rating_egg;
	}
	private int rating_ranks;
	private String rating_title;
	private double rating_percent;
	private double rating_egg;
	

}
