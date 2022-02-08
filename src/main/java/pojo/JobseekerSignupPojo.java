package pojo;

public class JobseekerSignupPojo {

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String typeUser;
	private boolean enabled;
	private String[] jobTitles;
	private String[] skills;
	private JobseekerSignupCurrentLocationPojo currentLocation;
	private JobseekerSignupPhoneNumber phoneNumber;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String[] getJobTitles() {
		return jobTitles;
	}
	public void setJobTitles(String[] jobTitles) {
		this.jobTitles = jobTitles;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public JobseekerSignupCurrentLocationPojo getJobseekerSignupCurrentLocationPojo() {
		return currentLocation;
	}
	public void setJobseekerSignupCurrentLocationPojo(
			JobseekerSignupCurrentLocationPojo jobseekerSignupCurrentLocationPojo) {
		this.currentLocation = jobseekerSignupCurrentLocationPojo;
	}
	public JobseekerSignupPhoneNumber getJobseekerSignupPhoneNumber() {
		return phoneNumber;
	}
	public void setJobseekerSignupPhoneNumber(JobseekerSignupPhoneNumber jobseekerSignupPhoneNumber) {
		this.phoneNumber = jobseekerSignupPhoneNumber;
	}
}
