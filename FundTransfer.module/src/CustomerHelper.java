

import java.net.*;
import java.io.*;

	

	

	public class CustomerHelper{
	
	public static String sendSMS(String inURL, String from, String mobileNo, String type, String msg, String apikey, String secret)
	   {
	       	  
	 	  String sURL = inURL+"?api_key="+apikey+"&api_secret="+secret+"&from="+from+"&to="+mobileNo + "&type="+type +"&text="+msg;
	 	  
	 	  System.out.println(sURL);
	//	  String sURL = inURL+"?api_key="+apikey+"&api_secret="+secret+"&from="+from+"&to="+mobileNo + "&type="+type +"&body="+msg;
	  
	       HttpURLConnection conn = null;
	 	  String sResult = "";
	       try  {
	           URL url = new URL(sURL);
	           conn = (HttpURLConnection)url.openConnection();          
	           conn.setDoOutput(false);                  
	           conn.setRequestMethod("GET");          
	           conn.connect();
	 		  
	           int iResponseCode = conn.getResponseCode();
	 		  System.out.println("ResponseCode: " + iResponseCode);
	           if ( iResponseCode == 200 ) {
	             BufferedReader oIn = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
	             String sInputLine = "";
	             while ((sInputLine = oIn.readLine()) != null) {
	               sResult = sResult + sInputLine;
	             }
	             if (sResult.length() > 0) 
	             {
	               System.out.println("success - MT ID : " + sResult);       
	             }
	             else 
	             {
	               System.out.println("fail - Error code : " + sResult);       
	             }
	           }
	           else {
	             System.out.println("fail ");        
	           }
	       }
	       catch (Exception e){ 
	         e.printStackTrace();
	       }
	       finally {
	         if (conn != null) {
	           conn.disconnect();
	         }
	       }
	 	  return sResult;
	     }
}