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
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

public class SigninActivity  extends AsyncTask<String,Void,String>{
   private TextView statusField;
   private int byGetOrPost = 0; 
  Dialog dia;
  int res;
  //private ProgressDialog Dialog = new ProgressDialog();
   //flag 0 means get and 1 means post.(By default it is get.)
   public SigninActivity(TextView statusField,int flag,Dialog dia,int res) {
     // this.context = context;
      this.statusField = statusField;
     this.dia=dia;
      byGetOrPost = flag;
      this.res=res;
   }
   
   protected void onPreExecute(){

   }
   
   @Override
   protected String doInBackground(String... arg0) {
	 
      if(byGetOrPost == 0){ //means by Get Method
      
      try{
         String username = (String)arg0[0];
         String password = (String)arg0[1];
         String link = "http://www.sellfunn.com/android/android_login.php?username="+username+"& password="+password;
         
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
            String username = (String)arg0[0];
            String password = (String)arg0[1];
            
            String link="http://www.sellfunn.com/android/android_login.php";
            String data  = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            
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
    //String r=(String) result;
   // System.out.print("----------------------------------------------------------------");
   // System.out.print(result);
   if(result.contains("success"))
   {
	 Login.res=1; 
	 this.statusField.setText(result);
	//System.out.print(result);
	  //  this.statusField.setText("hello");
	

   }
   else
   {
	   Login.res=0;
	  
	    // this.statusField.setText(result);

   }
    // this.statusField.setText(result);
      
   }
}