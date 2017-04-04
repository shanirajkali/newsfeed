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

public class MerchantLogin extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		HttpSession session=request.getSession(false);
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9001/newsgroup","root","8778");
			Statement stmt=con.createStatement();
			if(session==null){
				out.print("{\"status\":\"0\"}");
				session=request.getSession();
				session.setAttribute("email","");
				session.setAttribute("gender","");
				session.setAttribute("name","");
				session.setAttribute("address","");
				session.setAttribute("merchantType","");
				session.setAttribute("phone","");
				session.setAttribute("merchantID","");

				return;
			}
			else if(session!=null){
				String email=(String)session.getAttribute("email");
				String name=(String)session.getAttribute("name");
				String phone=(String)session.getAttribute("phone");
				String merchantType=(String)session.getAttribute("merchantType");
				String address=(String)session.getAttribute("address");
				String gender=(String)session.getAttribute("gender");
				String merchantID=(String)session.getAttribute("merchantID");
				if (email.equals("")) {
					String requestBody=getRequestBody(request.getInputStream());
					MerchantLoginJson merchantLoginJson=mapper.readValue(requestBody,MerchantLoginJson.class);
					ResultSet rs=stmt.executeQuery("select name,gender,email,phone,merchant_type,address_line,merchant_id from merchantprofile where email='"
							+merchantLoginJson.email+"' AND password='"
							+merchantLoginJson.password+"';");
					while(rs.next()){
					name=rs.getString(1);
					gender=rs.getString(2);
					email=rs.getString(3);
					phone=rs.getString(4);
					merchantType=rs.getString(5);
					address=rs.getString(6);
					merchantID=rs.getString(7);

					break;
					}
					if(email.equals("")){
						out.print("{\"status\":\"0\"}");
						session.setAttribute("email","");
						session.setAttribute("name","");
						session.setAttribute("gender","");
						session.setAttribute("address","");
						session.setAttribute("merchantType","");
						session.setAttribute("phone","");
						session.setAttribute("merchantID","");
						return;
					}
					else{
						out.print("{\"name\":\""+name+"\",\"gender\":\""
							+gender+"\",\"email\":\""
							+merchantLoginJson.email+"\",\"phone\":\""
							+phone+"\",\"merchantType\":\""
							+merchantType+"\",\"address\":\""
							+address+"\",\"status\":\"1\",\"merchantId"}");
						session.setAttribute("email",email);
						session.setAttribute("gender",gender);
						session.setAttribute("name",name);
						session.setAttribute("phone",phone);
						session.setAttribute("merchantType",merchantType);
						session.setAttribute("address",address);
						session.setAttribute("merchantID",merchantID);
						return;
					}
					
				}
				else{
					out.print("{\"name\":\""+name+"\",\"gender\":\""
						+gender+"\",\"email\":\""
						+email+"\",\"phone\":\""
						+phone+"\",\"merchantType\":\""
						+merchantType+"\",\"address\":\""
						+address+"\",\"status\":\"1\"}");
					return;
				}
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
class MerchantLoginJson{
	String email,password;
	public MerchantLoginJson(){}
	public void setEmail(String email){
		this.email=email;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
	public String toString(){
		return "MerchantLoginJson [email:"+email+",password:"+password+"]";
	}

}