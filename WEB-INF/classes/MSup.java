import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.time.LocalDate;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.time.LocalDateTime;
public class MSup extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		try{
			String requestBody=getRequestBody(request.getInputStream());
			MSupJson mSupJson=mapper.readValue(requestBody,MSupJson.class);
			String name=mSupJson.name;
			String gender=mSupJson.gender;
			String email=mSupJson.email;
			String phone = mSupJson.phone;
			String address=mSupJson.address;
			String password=mSupJson.password;
			String dob=mSupJson.dob;

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9001/newsgroup","root","8778");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select email from mprofile where email='"+email+"' ;");
			while(rs.next()){
				String s=rs.getString(1);
				if(s.equals(email)){
					out.print("{\"status\":\"user "+email+" already registerd\",\"flag\":\"0\"}");
					return;
				}
							}
			rs=stmt.executeQuery("select phone from mprofile where phone='"+mSupJson.phone+"';");
			while(rs.next()){
				if(rs.getString(1).equals(mSupJson.phone)){
						out.print("{\"status\":\"Phone no. "+mSupJson.phone+" already registerd\",\"flag\":\"0\"}");
						return;
				}
				return;
			}
			if(name=="" || email=="" || phone=="" || dob==""){
				out.print("{\"status\":\"pleasse complete your details\",\"flag\":\"0\"}");
				return;
			}
			
			int affted=0;
		//	LocalDate dob = LocalDate.parse(merchantSignupJson.dob);
			affted=stmt.executeUpdate("insert into mProfile(name,gender,email,phone,address_line,dob,password) values"
														+"('"+name+"','"+gender+"','"+email+"','"+phone+"','"+address+"','"+dob+"','"+password+"');");

			if(affted>0){
				out.print("{\"status\":\"success\",\"flag\":\"1\",\"password\":\""
					+mSupJson.password+"\",\"name\":\""
					+name+"\",\"email\":\""+email+"\",\"phone\":\""+phone+"\"}");
			}
			if(affted<=0){
				out.print("{\"status\":\"success\",\"flag\":\"0\",\"password\":\""+mSupJson.password+"\"}");
			}
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


class MSupJson{
	String name,dob,gender,email,address,password;
	String phone;
	public MSupJson(){}
public	void setName(String name){
		this.name=name;
	}
	
public	void setGender(String gender){
		this.gender=gender;
	}

public	void setEmail(String email){
		this.email=email;
	}
	
public	void setPhone(String phone){
		this.phone=phone;
	}	
public	void setAddress(String address){
		this.address=address;
	}

public	void setDob(String dob){
		this.dob=dob;
	}
public	void setPassword(String password){
		this.password=password;
	}
public	String getPassword(){
		return password;
	}
public		String getAddress(){
		return address;
	}

public	String getName(){
		return name;
	}
public		String getGender(){
		return gender;
	}
public	String getEmail(){
		return email;
	}

public	String getPhone(){
		return phone;
	}
 public String toString(){
 	return "MSupJson [name:"+name+",gender:"
 			+gender+",email:"+email+",phone:"+phone+",address:"+address+",dob:"+dob+",password:"+password+"]";
 }
}