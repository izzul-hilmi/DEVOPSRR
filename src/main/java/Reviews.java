
public class Reviews {
	
	
	protected String name;
	
	public Reviews(String name, String review) {
		super();
		this.name = name;
		this.review = review;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	protected String review;
}
