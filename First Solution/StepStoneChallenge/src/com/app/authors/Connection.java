package com.app.authors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Connection {

	public Connection() {
		super();
	}
	
	public void showData(String firstName, String lastName) throws IOException {
		
		ArrayList<String> result = getAuthor(firstName, lastName);
		
		System.out.println("\n");
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
		System.out.println("\n");
		
	}
	
	public ArrayList<String> getAuthor(String firstName, String lastName) throws IOException {
		
		JSONObject json = getJSON(startConnection(firstName, lastName));
		
		int id,titles = 0;
		String name;
		ArrayList<String> ans = new ArrayList();
		
		try {
			
			JSONArray author = json.getJSONObject("authors").getJSONArray("author");
			
			
			for(int i = 0; i < author.length(); i++) {
				
				id = author.getJSONObject(i).getInt("authorid");
				name = author.getJSONObject(i).getString("authorlastfirst");
				//System.out.println(author.getJSONObject(8).getJSONObject("titles").length());
				
				try {
					
					if(author.getJSONObject(i).getJSONObject("titles").getJSONArray("isbn").length() > 0)
						titles = author.getJSONObject(i).getJSONObject("titles").getJSONArray("isbn").length();
						
				}catch(Exception e) {
					
					if(author.getJSONObject(i).get("titles") != "")
						titles = 1;
					else
						titles = 0;

				}
				
				String result = id + "; " + name + "; " + titles;
				ans.add(result);
			}
			  
		}
		catch(Exception e) {
			ans.add("Error: Author not Found");
			  
		}
		return ans;
	}
	
	
	private JSONObject getJSON(HttpURLConnection con) throws IOException {
		
		JSONObject json = null;	
		
		if(con.getResponseCode() == 200) {
			
			InputStream is = con.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String str = "";
			StringBuilder xml = new StringBuilder();
			
			while((str = reader.readLine()) != null) {
				xml = xml.append(str);
			}
				
			reader.close();	
			
			json = XML.toJSONObject(xml.toString());
			
			
						
		}else
			System.out.println("GET Request Error, verify the inputs");
		
		return json;
	}
	
	private HttpURLConnection  startConnection(String firstName, String lastName) throws IOException {
		
		// Verify if it is a compose name
		
		firstName = verifyName(firstName);
		lastName = verifyName(lastName);
		
		URL url = new URL("https://reststop.randomhouse.com/resources/authors?lastName=" + lastName +  "&firstName=" + firstName);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();	
		
		return con;
		
	}
	
	private String verifyName(String name) {
		
		String[] n = name.split(" ");
				
		if(n.length > 1) {
			
			for(int i = 0; i < n.length -1; i++) {
				
				n[i] = n[i].concat("%20");

			}
			
			name = n[0];
			
			for(int i = 1; i < n.length; i++)
				name = name.concat(n[i]);

			
			return name;
			
		}else
			return name;
		
		
	}
	

}
