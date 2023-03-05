package movie.vo;

public class CarVo {
	public String maker;
	public String carname;
	public String info ;
	public String imgurl;
	
	
	
	public CarVo(String carname,String info, String imgurl) {

		this.carname=carname;
		this.info=info;
		this.imgurl=imgurl;
	}
	@Override
	public String toString() {
		return "carVo [maker=" + maker + ", carname=" + carname + ", info=" + info + ", imgurl=" + imgurl + "]";
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
