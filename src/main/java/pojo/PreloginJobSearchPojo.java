package pojo;

public class PreloginJobSearchPojo {
	private String[] skills;
	private String jobTitle;
	private int minDailyRate;
	private int maxDailyRate;
	private String rateType;
	private String[] industries;
	private String[] languages;
	private boolean contract;
	private boolean permanent;
	private SearchLocationPojo locations;
	
	public SearchLocationPojo getLocations() {
		return locations;
	}
	public void setLocations(SearchLocationPojo locations) {
		this.locations = locations;
	}	
	public boolean isContract() {
		return contract;
	}
	public void setContract(boolean contract) {
		this.contract = contract;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
//	public SearchLocationPojo getSearchLocationPojo() {
//		return locations;
//	}
//	public void setSearchLocationPojo(SearchLocationPojo searchLocationPojo) {
//		this.locations = searchLocationPojo;
//	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinDailyRate() {
		return minDailyRate;
	}
	public void setMinDailyRate(int minDailyRate) {
		this.minDailyRate = minDailyRate;
	}
	public int getMaxDailyRate() {
		return maxDailyRate;
	}
	public void setMaxDailyRate(int maxDailyRate) {
		this.maxDailyRate = maxDailyRate;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String[] getIndustries() {
		return industries;
	}
	public void setIndustries(String[] industries) {
		this.industries = industries;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
}
