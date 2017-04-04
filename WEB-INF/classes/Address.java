import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class Address extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();		
		try{
			//{"get":"district","where":"state","value":"'+state+'"}
			String requestBody = getRequestBody(request.getInputStream());
			Locations location = mapper.readValue(requestBody,Locations.class);
			String val=mapper.writeValueAsString(location.get);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9001/newsgroup","root","8778");
			Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery("select distinct "+location.get+" from address where "+location.where+"='"+location.value+"';");
			String statesArry="{\"locations\":[";
			while(rs.next()){  
			statesArry=statesArry+"\""+rs.getString(1)+"\",";
			}  
			statesArry=statesArry.substring(0,statesArry.length()-1)+"]}";
			con.close();  

		
			out.println(statesArry);
		}
		 catch (JsonParseException e) { e.printStackTrace();}
      catch (JsonMappingException e) { e.printStackTrace(); }
      catch (IOException e) { e.printStackTrace(); }
      catch(Exception e){e.printStackTrace();}
	
	}
	private String getRequestBody(InputStream inputStream) throws Exception{
		StringBuilder requestBody = new StringBuilder();

		// request inputstream that is in byte format now we have to convert bytes to string json
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		while((line=bufferedReader.readLine())!=null){
			requestBody.append(line);
		}
		inputStream.close();
		return requestBody.toString();
	}

}
class Locations{
	String get,value,where;
	public Locations(){}

	public String getGet(){
		return get;
	}

	public void setGet(String get){
		this.get=get;

	}
	public void setValue(String value){
		this.value=value;
	}

	public String getValue(){
		return value;
	}
	public void setWhere(String where){
		this.where=where;
	}
	public String getWhere(){
		return where;
	}
	public String toString(){
		return "Locations [get : "+get+",where:"+where+",value:"+value+"]";
	}

}