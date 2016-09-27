package com.sellfunn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Dialog;
import android.os.AsyncTask;
import android.widget.TextView;

public class Signup  extends AsyncTask<String,Void,String>{
   private TextView statusField;
 
   private int byGetOrPost = 0; 
   Dialog dia;
 
   //flag 0 means get and 1 means post.(By default it is get.)
   public Signup(TextView statusField,int flag,Dialog dia) {
     // this.context = context;
      this.statusField = statusField;
     this.dia=dia;
      byGetOrPost = flag;
   }
   
   protected void onPreExecute(){

   }
   
   @Override
   protected String doInBackground(String... arg0) {
	 
      if(byGetOrPost == 0){ //means by Get Method
      
      try{
         String user = (String)arg0[0];
         String pass = (String)arg0[1];
         String rpass = (String)arg0[2];
         String fname = (String)arg0[3];
         String lname = (String)arg0[4];
         String email = (String)arg0[5];
         String ques = (String)arg0[6];
         String ans = (String)arg0[7];
         String colg_name=(String)arg0[8];
         String mob_no=(String)arg0[9];
         
         String link = "http://www.sellfunn.com/android/android_signup.php?user="+user+"& " +
        "pass="+pass+"& rpass="+rpass+"& fname="+fname+"& lname="+lname+"& email="+email+"& ques="+ques+"& ans="+ans+
        "& colg_name="+colg_name+"& mob_no="+mob_no;
         
         URL url = new URL(link);
         HttpClient client = new DefaultHttpClient();
         HttpGet request = new HttpGet();
         request.setURI(new URI(link));
         HttpResponse response = client.execute(request);
         BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

           StringBuffer sb = new StringBuffer("");
           String line="";
           
           while ((line = in.readLine()) != null) {
              sb.append(line);
              break;
            }
            in.close();
            return sb.toString();
         }
         
         catch(Exception e){
            return new String("Exception: " + e.getMessage());
         }
      }
      else{
         try{
        	 String user = (String)arg0[0];
             String pass = (String)arg0[1];
             String rpass = (String)arg0[2];
             String fname = (String)arg0[3];
             String lname = (String)arg0[4];
             String email = (String)arg0[5];
             String ques = (String)arg0[6];
             String ans = (String)arg0[7];
             String colg_name=(String)arg0[8];
             String mob_no=(String)arg0[9];
             
            
            String link="http://www.sellfunn.com/android/android_signup.php";
           String data  = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
            data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")+
            		"&" + URLEncoder.encode("rpass", "UTF-8") + "=" + URLEncoder.encode(rpass, "UTF-8")+
            		"&" + URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(fname, "UTF-8")+
            		"&" + URLEncoder.encode("lname", "UTF-8") + "=" + URLEncoder.encode(lname, "UTF-8")+
            		"&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")+
            		"&" + URLEncoder.encode("ques", "UTF-8") + "=" + URLEncoder.encode(ques, "UTF-8")+
            		"&" + URLEncoder.encode("ans", "UTF-8") + "=" + URLEncoder.encode(ans, "UTF-8")+
            		"&" + URLEncoder.encode("colg_name", "UTF-8") + "=" + URLEncoder.encode(colg_name, "UTF-8")+
            		"&" + URLEncoder.encode("mob_no", "UTF-8") + "=" + URLEncoder.encode(mob_no, "UTF-8")	;
            
            URL url = new URL(link);
            URLConnection conn = url.openConnection(); 
            
            conn.setDoOutput(true); 
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream()); 
            
            wr.write( data ); 
            wr.flush(); 
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            StringBuilder sb = new StringBuilder();
            String line = null;
            
            // Read Server Response
            while((line = reader.readLine()) != null)
            {
               sb.append(line);
               
               break;
            }
            return sb.toString();
         }
         catch(Exception e){
        	
            return new String("Exception: " + e.getMessage());
           
            
         }
      }
   }
   
   @Override
   protected void onPostExecute(String result){
    
	   dia.dismiss();
      this.statusField.setText(result);
   }
}