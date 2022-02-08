package apiConfigs;

public class APIPath {
	
	public static final class apiPath{
		
		public static final String GENERATE_TOKEN ="/utils/auth/token";
				
		public static final String CREATE_POST_JOB_SEARCH="/searchProxy/search/jobs?pageSize=1&index=0";
		
		public static final String CREATE_POST_TALENT_SEARCH="/searchProxy/search/contractor?isLoggedIn=false&pageSize=100&index=0";
		
		public static final String JOBSEEKER_LOGIN="/auth/login/logIn";
		
		public static final String JOBSEEKER_SIGNUP="/auth/login/signUp?mid=";
		
		public static final String CREATE_POST_ENCRYPT="/utils/encrypt";
		
		public static final String DELETE_USER ="/profile/deleteUser";
	}
	
}
