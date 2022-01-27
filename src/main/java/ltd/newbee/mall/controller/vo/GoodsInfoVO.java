package ltd.newbee.mall.controller.vo;



public class GoodsInfoVO{
    private Long id;

    private  String name;

    private String size;

    private String pa;

    private String weight;

    private String housyou;

    private String time;

    private String sizeOfPackage;

    
	@Override
	public String toString() {
		return "GoodsInfo [getId()=" + getId() + ", getName()=" + getName() + ", getSize()=" + getSize() + ", getPa()="
				+ getPa() + ", getWeight()=" + getWeight() + ", getHousyou()=" + getHousyou() + ", getTime()="
				+ getTime() + ", getSizeOfPackage()=" + getSizeOfPackage() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHousyou() {
		return housyou;
	}

	public void setHousyou(String housyou) {
		this.housyou = housyou;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSizeOfPackage() {
		return sizeOfPackage;
	}
	
	public void setSizeOfPackage(String sizeOfPackage) {
		this.sizeOfPackage = sizeOfPackage;
	}
    
}