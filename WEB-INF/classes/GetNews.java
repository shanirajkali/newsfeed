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
public class GetNews extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		try{
			String requestBody=getRequestBody(request.getInputStream());
			GetNewsJson getNewsJson=mapper.readValue(requestBody,GetNewsJson.class);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9001/newsgroup","root","8778");
			Statement stmt=con.createStatement();
			Statement st=con.createStatement();
			Statement stad=con.createStatement();
			ResultSet rs,mn,ad;
			String type=getNewsJson.type.get(0);
			if (type.equals("all")) {
				if((getNewsJson.from).equals("start")){
				rs=stmt.executeQuery("select heading from news order by create_time desc limit 5;");
				if(rs.next()==false){
					out.print("{\"heading\":[],\"newsType\":[],\"from\":\"\",\"createTime\":[]}");
					return;
				}
				rs.previous();

				String news="{\"heading\":[";
				while(rs.next()) {
					news=news+"\""+rs.getString(1)+"\",";
				}
				rs=stmt.executeQuery("select description from news order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"description\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				int tem=0;
				rs=stmt.executeQuery("select news_type from news order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"newsType\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
					tem++;
				}
				
				rs=stmt.executeQuery("select merchant_id from news order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"merchantName\":[";
				String[] add=new String[tem];
				int i=0;
				while(rs.next()){
					mn=st.executeQuery("select name,address_id from merchantprofile where merchant_id="+rs.getString(1)+";");
					mn.next();
					news=news+"\""+mn.getString(1)+"\",";
					
					add[i]=mn.getString(2);	
					i++;
						
					
				}
				news=news.substring(0,news.length()-1);
				news=news+"],\"address\":[";
				i=0;
				while(i<tem){
					ad=stad.executeQuery("select * from address where address_id="+add[i]+";");
					ad.next();
					String s=ad.getString(5);
					news=news+"\""+s+"\",";
					
				
					i++;
				}

				rs=stmt.executeQuery("select create_time from news order by create_time desc limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"createTime\":[";

				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				news=news.substring(0,news.length()-1);
				news=news+"]}";
				out.println(news);
				return;
			}
			else{
				rs=stmt.executeQuery("select heading from news where create_time<'"
					+getNewsJson.from+"' order by create_time desc limit 5;");
				
				String news="{\"heading\":[";
				if(rs.next()==false){
					out.print("{\"heading\":[],\"newsType\":[],\"from\":\"\",\"createTime\":[]}");
					return;
				}
				rs.previous();
				while(rs.next()) {
					news=news+"\""+rs.getString(1)+"\",";
					
				}
				rs=stmt.executeQuery("select description from news where create_time<'"
					+getNewsJson.from+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"description\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				int tem=0;
				rs=stmt.executeQuery("select news_type from news where create_time<'"
					+getNewsJson.from+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"newsType\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
					tem++;
				}
				rs=stmt.executeQuery("select merchant_id from news where create_time<'"
					+getNewsJson.from+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"merchantName\":[";
				String[] add=new String[tem];
				int i=0;
				while(rs.next()){
					mn=st.executeQuery("select name,address_id  from merchantprofile where merchant_id="+rs.getString(1)+";");
					mn.next();
					news=news+"\""+mn.getString(1)+"\",";
					add[i]=mn.getString(2);	
					i++;
				}

				news=news.substring(0,news.length()-1);
				news=news+"],\"address\":[";
				i=0;
				while(i<tem){
					ad=stad.executeQuery("select * from address where address_id="+add[i]+";");
					ad.next();
					String s=ad.getString(5);
					news=news+"\""+s+"\",";
					
				
					i++;
				}
				rs=stmt.executeQuery("select create_time from news where create_time<'"
					+getNewsJson.from+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"createTime\":[";

				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				news=news.substring(0,news.length()-1);
				news=news+"]}";
				out.println(news);
				return;
			}
			}
			else{
				type=getNewsJson.type.get(0);
				if((getNewsJson.from).equals("start")){
				rs=stmt.executeQuery("select heading from news where  news_type='"
					+type+"' order by create_time desc limit 5;");
				if(rs.next()==false){
					out.print("{\"heading\":[],\"newsType\":[],\"from\":\"\",\"createTime\":[]}");
					return;
				}
				rs.previous();

				String news="{\"heading\":[";
				while(rs.next()) {
					news=news+"\""+rs.getString(1)+"\",";
					
				}
				rs=stmt.executeQuery("select description from news where news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"description\":[";
				int tem=0;
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
					tem++;
				}
				rs=stmt.executeQuery("select news_type from news where news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"newsType\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				rs=stmt.executeQuery("select merchant_id from news where news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"merchantName\":[";
				String[] add=new String[tem];
				int i=0;
				while(rs.next()){
					mn=st.executeQuery("select name,address_id  from merchantprofile where merchant_id="
						+rs.getString(1)+";");
					mn.next();
					news=news+"\""+mn.getString(1)+"\",";
					add[i]=mn.getString(2);	
					i++;
				}

				news=news.substring(0,news.length()-1);
				news=news+"],\"address\":[";
				i=0;
				while(i<tem){
					ad=stad.executeQuery("select * from address where address_id="+add[i]+";");
					ad.next();
					String s=ad.getString(5);
					news=news+"\""+s+"\",";
					
				
					i++;
				}
				rs=stmt.executeQuery("select create_time from news where news_type='"
					+type+"' order by create_time desc limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"createTime\":[";

				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				news=news.substring(0,news.length()-1);
				news=news+"]}";
				out.println(news);
				return;
			}
			else{
				rs=stmt.executeQuery("select heading from news where news_type='"
					+type+"' and create_time<'"
					+getNewsJson.from+"' order by create_time desc limit 5;");
				
				String news="{\"heading\":[";
				if(rs.next()==false){
					out.print("{\"heading\":[],\"newsType\":[],\"from\":\"\",\"createTime\":[]}");
					return;
				}
				rs.previous();
				while(rs.next()) {
					news=news+"\""+rs.getString(1)+"\",";
					
				}
				rs=stmt.executeQuery("select description from news where create_time<'"
					+getNewsJson.from+"' and news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"description\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				int tem=0;
				rs=stmt.executeQuery("select news_type from news where create_time<'"
					+getNewsJson.from+"' and news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"newsType\":[";
				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
					tem++;
				}
				rs=stmt.executeQuery("select merchant_id from news where create_time<'"
					+getNewsJson.from+"' and news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"merchantName\":[";
				String[] add=new String[tem];
				int i=0;
				while(rs.next()){
					mn=st.executeQuery("select name,address_id from merchantprofile where merchant_id="
						+rs.getString(1)+";");
					mn.next();
					news=news+"\""+mn.getString(1)+"\",";
					add[i]=mn.getString(2);	
					i++;
				}
				news=news.substring(0,news.length()-1);
				news=news+"],\"address\":[";
				i=0;
				while(i<tem){
					ad=stad.executeQuery("select * from address where address_id="+add[i]+";");
					ad.next();
					String s=ad.getString(5);
					news=news+"\""+s+"\",";
					
				
					i++;
				}
				rs=stmt.executeQuery("select create_time from news where create_time<'"
					+getNewsJson.from+"' and news_type='"
					+type+"' order by create_time desc  limit 5;");
				news=news.substring(0,news.length()-1);
				news=news+"],\"createTime\":[";

				while(rs.next()){
					news=news+"\""+rs.getString(1)+"\",";
				}
				news=news.substring(0,news.length()-1);
				news=news+"]}";
				out.println(news);
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


class GetNewsJson{
	List<String> type;
	List<String> area;
	String from;
	String status;
	public List<String> getType(){
		return type;
	}
	public void setType(List<String> type){
		this.type=type;
	}
	public List<String> getArea(){
		return area;
	}
	public void setArea(List<String> area){
		this.area=area;
	}
	public String getFrom(){
		return from;
	}
	public void setFrom(String from){
		this.from=from;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status=status;
	}


}