package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	
	public String firstName , lastName , addressFname , addressLname , companyName , companyAddress , companyBuilding , city , alisaAddress, password , postalCode , phoneNumber;
	public void JsonReader() throws IOException,ParseException {
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/testdata.json";
		
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jarr = (JSONArray)parser.parse(new FileReader(srcFile));
		
		for(Object jsonObj: jarr) {
			JSONObject user = (JSONObject) jsonObj;
			firstName = (String) user.get("firstName");
			lastName = (String) user.get("lastName");
			password = (String) user.get("password");
			addressFname = (String) user.get("addressFname");
			addressLname = (String) user.get("addressLname");
			companyName = (String) user.get("companyName");
			companyAddress = (String) user.get("companyAddress");
			companyBuilding = (String) user.get("companyBuilding");
			city = (String) user.get("city");
			postalCode = (String) user.get("postalCode");
			phoneNumber = (String) user.get("phoneNumber");
			alisaAddress = (String) user.get("alisaAddress");

		}
	}

}
