
public class Restaurant {
	protected String name;
	 
	 public Restaurant(String name, String hotline, String address) {
		 super();
		 this.name = name;
		 this.hotline = hotline;
		 this.address = address;
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	protected String hotline;
	protected String address;
}
