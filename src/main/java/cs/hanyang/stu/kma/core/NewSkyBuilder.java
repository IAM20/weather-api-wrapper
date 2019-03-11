package cs.hanyang.stu.kma.core;

public class NewSkyBuilder {
	private NewSky newSky;

	public NewSkyBuilder() {
		newSky = new NewSky();
	}

	public NewSkyBuilder setOperation(String operation) {
		newSky.setOperation(operation);
		return this;
	}

	public NewSkyBuilder setServiceKey(String serviceKey) {
		newSky.setServiceKey(serviceKey);
		return this;
	}

	public NewSkyBuilder setBaseDate(int baseDate) {
		newSky.setBaseDate(baseDate);
		return this;
	}

	public NewSkyBuilder setBaseDate(String baseDate) {
		newSky.setBaseDate(baseDate);
		return this;
	}

	public NewSkyBuilder setBaseTime(int baseTime) {
		newSky.setBaseTime(baseTime);
		return this;
	}

	public NewSkyBuilder setBaseTime(String baseTime) {
		newSky.setBaseTime(baseTime);
		return this;
	}

	public NewSkyBuilder setNx(int nx) {
		newSky.setNx(nx);
		return this;
	}

	public NewSkyBuilder setNx(String nx) {
		newSky.setNx(nx);
		return this;
	}

	public NewSkyBuilder setNy(int ny) {
		newSky.setNy(ny);
		return this;
	}

	public NewSkyBuilder setNy(String ny) {
		newSky.setNy(ny);
		return this;
	}

	public NewSkyBuilder setNumOfRows(int numOfRows) {
		newSky.setNumOfRows(numOfRows);
		return this;
	}

	public NewSkyBuilder setNumOfRows(String numOfRows) {
		newSky.setNumOfRows(numOfRows);
		return this;
	}

	public NewSkyBuilder setPageNo(int pageNo) {
		newSky.setPageNo(pageNo);
		return this;
	}

	public NewSkyBuilder setPageNo(String pageNo) {
		newSky.setPageNo(pageNo);
		return this;
	}

	public NewSkyBuilder setType(String type) {
		newSky.setType(type);
		return this;
	}

	public NewSky build() {
		return newSky;
	}
}
