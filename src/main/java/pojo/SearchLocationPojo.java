package pojo;

public class SearchLocationPojo {

	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public Object getRegion() {
		return region;
	}
	public void setRegion(Object region) {
		this.region = region;
	}
	public Object getStateId() {
		return stateId;
	}
	public void setStateId(Object stateId) {
		this.stateId = stateId;
	}
	private String countryId;
	private Object region;
	private Object stateId;
}
