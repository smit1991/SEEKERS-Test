package MavenFramework;

public class resources {

	public static String placeData() {
		String res = "/api/v1/employees";
		return res;
	}
	
	public static String placeDataOne() {
		String res = "/api/v1/employee/1";
		return res;
	}
	
	public static String postDataOne() {
		String res = "/api/v1/create";
		return res;
	}
	
	public static String putDataOne() {
		String res = "api/v1/update/"+ReusableMethods.putRequestGetId();
		return res;
	}
	
	public static String deleteDataOne() {
		String res = "/api/v1/delete/"+ReusableMethods.putRequestGetId();
		return res;
	}
	
}

