package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.Serializtionbody;
import Pojo.location;

public class Gmapspayload {
	
	public Serializtionbody addplacepayload(String lat,String lng,String accuracy,String name,String phonenumber,String address,String types1,String types2,String website,String language) {
		Serializtionbody sb = new Serializtionbody();
		location l = new location();
		l.setLat(lat);
		l.setLng(lng);
		sb.setLocation(l);
		sb.setAccuracy(accuracy);
		sb.setName(name);
		sb.setPhone_number(phonenumber);
		sb.setAddress(address);
		List<String> mylist = new ArrayList<String>();
		mylist.add(types1);
		mylist.add(types2);
		sb.setTypes(mylist);
		sb.setWebsite(website);
		sb.setLanguage(language);
		return sb;
	}
	
	public String deleteplacepayload(String placeid) {
		String deleteplace = "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
		return deleteplace;
	}

}
