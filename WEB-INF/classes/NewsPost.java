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
public class NewsPost extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		HttpSession session=request.getSession(false);
		if (session==null) {
			out.print("{\"status\":\"0\"}");
			return ;
		}
		else if(session!=null){
			String merchantID=(String)session.getAttribute("merchantID");
			String merchantType=(String)session.getAttribute("merchantType");
			try{
				String requestBody=getRequestBody(request.getInputStream());
				NewsPostJson newsPost=mapper.readValue(requestBody,NewsPostJson.class);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9001/newsgroup","root","8778");
				Statement stmt=con.createStatement();
				int affected=0;
				if(newsPost.equals("")){
					out.print("{\"status\":\"2\"}");
					return;
				}
				else{
					affected=stmt.executeUpdate("insert into news(heading,description,news_type,create_time,update_time,merchant_id,active_status) values"
									+"('"+newsPost.heading+"','"+newsPost.description+"','"
									+merchantType+"',now(),now(),"+merchantID+",1);");
					out.print("{\"status\":\"3\"}");
					return;
				}			
			}
			catch (JsonParseException e) { e.printStackTrace();}
      		catch (JsonMappingException e) { e.printStackTrace(); }
     	 	catch (IOException e) { e.printStackTrace(); }
      		catch(Exception e){e.printStackTrace();}
		}
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

class NewsPostJson{
	String heading,description;
	public void setHeading(String heading){
		this.heading=heading;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getHeading(){
		return heading;
	}
	public String getDescription(){
		return description;
	}
	public String toString(){
		return "NewsJson [heading:"+heading+",description:"+description+"]";
	}

}