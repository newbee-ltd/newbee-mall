package ltd.newbee.mall.entity;

public class Student {

	private long id;
	private String name;
	private long age;
	private String gender;
	private String location;
	private String nativePlace;
	private String tel;
	private long totalScore;
	private String className;
	private long ranking;
	private String blacklist;
	private long physical;
	private long chemistry;
	private long biological;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public long getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(long totalScore) {
		this.totalScore = totalScore;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getRanking() {
		return ranking;
	}

	public void setRanking(long ranking) {
		this.ranking = ranking;
	}

	public String getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}

	public long getPhysical() {
		return physical;
	}

	public void setPhysical(long physical) {
		this.physical = physical;
	}

	public long getChemistry() {
		return chemistry;
	}

	public void setChemistry(long chemistry) {
		this.chemistry = chemistry;
	}

	public long getBiological() {
		return biological;
	}

	public void setBiological(long biological) {
		this.biological = biological;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", location=");
		builder.append(location);
		builder.append(", nativePlace=");
		builder.append(nativePlace);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", totalScore=");
		builder.append(totalScore);
		builder.append(", className=");
		builder.append(className);
		builder.append(", ranking=");
		builder.append(ranking);
		builder.append(", blacklist=");
		builder.append(blacklist);
		builder.append(", physical=");
		builder.append(physical);
		builder.append(", chemistry=");
		builder.append(chemistry);
		builder.append(", biological=");
		builder.append(biological);
		builder.append("]");
		return builder.toString();
	}

}
