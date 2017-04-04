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
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		try{
			String requestBody=getRequestBody(request.getInputStream());
			MerchantSignupJson merchantSignupJson=mapper.readValue(requestBody,MerchantSignupJson.class);
			String name=merchantSignupJson.name;
			String gender=merchantSignupJson.gender;
			String email=merchantSignupJson.email;
		//	int phone = Integer.parseInt(merchantSignupJson.phone);
			String type=merchantSignupJson.type;
			String country=merchantSignupJson.country;
			String state=merchantSignupJson.state;
			String district=merchantSignupJson.district;
			String city=merchantSignupJson.city;
			String address=merchantSignupJson.address;
			
			String password=merchantSignupJson.dob;

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9001/newsgroup","root","8778");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select email from merchantprofile where email='"+email+"' ;");
			while(rs.next()){
				String s=rs.getString(1);
				if(s.equals(email)){
					out.print("{\"status\":\"user "+email+" already registerd\",\"flag\":\"0\"}");
					return;
				}
							}
			rs=stmt.executeQuery("select phone from merchantprofile where phone='"+merchantSignupJson.phone+"';");
			while(rs.next()){
				if(rs.getString(1).equals(merchantSignupJson.phone)){
						out.print("{\"status\":\"Phone no. "+merchantSignupJson.phone+" already registerd\",\"flag\":\"0\"}");
						return;
				}
				return;
			}
			if(name=="" || email=="" || merchantSignupJson.phone=="" ||merchantSignupJson.dob==""){
				out.print("{\"status\":\"pleasse complete your details\",\"flag\":\"0\"}");
				return;
			}
			int address_id=0;
			if ((merchantSignupJson.state.equals(""))||(merchantSignupJson.district.equals(""))||(merchantSignupJson.city.equals(""))) {
				address_id=0;
			}
			else if(!merchantSignupJson.district.equals("")){
				rs=stmt.executeQuery("select address_id from address where district='"+merchantSignupJson.district
					+"' and city='"+merchantSignupJson.city+"';");
				while(rs.next()){
					address_id=Integer.parseInt(rs.getString(1));
					break;
				}

			}

			int affted=0;
		//	LocalDate dob = LocalDate.parse(merchantSignupJson.dob);
			affted=stmt.executeUpdate("insert into merchantProfile(name,gender,email,phone,merchant_type,address_id,address_line,dob,password,create_time_stamp,update_time_stamp,active_status) values"
														+"('"+name+"','"+gender+"','"+email+"',"+merchantSignupJson.phone+",'"+type+"',"+address_id+",'"+address+"','"+merchantSignupJson.dob+"','"+password+"',now(),now(),1);");

			if(affted>0){
				out.print("{\"status\":\"success\",\"flag\":\"1\"}");
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


