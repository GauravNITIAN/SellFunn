package com.sellfunn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {
  //  ImageView image; 
    ViewFlipper filper;
    TextView text3,text,text1,text2;
    Dialog pDialog;
    Bitmap bitmap;
    ArrayList<String> User_List;
    JSONArray jArray;
    int no_of_ads;
    int counter=1;
    
   // ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;
    ImageView[] image=new ImageView[25];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
	//ends image view ids
		counter=1;
     image[1]=(ImageView) findViewById(R.id.imageView1);
     image[2]=(ImageView) findViewById(R.id.imageView2);
     image[3]=(ImageView) findViewById(R.id.imageView3);
     image[4]=(ImageView) findViewById(R.id.imageView4);
     image[5]=(ImageView) findViewById(R.id.imageView5);
     image[6]=(ImageView) findViewById(R.id.imageView6);
     image[7]=(ImageView) findViewById(R.id.imageView7);
     image[8]=(ImageView) findViewById(R.id.imageView8);
     image[9]=(ImageView) findViewById(R.id.imageView9);
     image[10]=(ImageView) findViewById(R.id.imageView10);
     image[11]=(ImageView) findViewById(R.id.imageView11);
     image[12]=(ImageView) findViewById(R.id.imageView12);
     image[13]=(ImageView) findViewById(R.id.imageView13);
     image[14]=(ImageView) findViewById(R.id.imageView14);
     image[15]=(ImageView) findViewById(R.id.imageView15);
     image[16]=(ImageView) findViewById(R.id.imageView16);
     image[17]=(ImageView) findViewById(R.id.imageView17);
     image[18]=(ImageView) findViewById(R.id.imageView18);
     image[19]=(ImageView) findViewById(R.id.imageView19);
     image[20]=(ImageView) findViewById(R.id.imageView20);
     image[21]=(ImageView) findViewById(R.id.imageView21);
     image[22]=(ImageView) findViewById(R.id.imageView22);
     image[23]=(ImageView) findViewById(R.id.imageView23);
     image[24]=(ImageView) findViewById(R.id.imageView24);
    
     
     
    
     
     
     
	filper=(ViewFlipper) findViewById(R.id.filper);
		filper.startFlipping();
		text3=(TextView)findViewById(R.id.textView1);
		text=(TextView)findViewById(R.id.textView2);
		text2=(TextView) findViewById(R.id.textView3);
		text1=(TextView) findViewById(R.id.textView4);
		text.setBackgroundColor(Color.parseColor("#BABABA"));
		 Typeface face3=Typeface.createFromAsset(getAssets(), "font/Roboto-CondensedItalic.ttf");
	       text3.setTypeface(face3);
	       text2.setTypeface(face3);
	       text1.setTypeface(face3);
	       text1.setBackgroundColor(Color.parseColor("#BABABA"));
	       text2.setBackgroundColor(Color.parseColor("#BABABA"));
	       text3.setBackgroundColor(Color.parseColor("#BABABA"));
	       Typeface face=Typeface.createFromAsset(getAssets(), "font/Roboto-CondensedItalic.ttf");
	       text.setTypeface(face);
	       
	       // get Ads Name here
	       
	       new Ads().execute("www.sellfunn.com");
	       pDialog = new Dialog(MainActivity.this);
	        pDialog.setContentView(R.layout.progress);
	        pDialog.setTitle("Loading Image ....");
	        pDialog.show();
  	       //new LoadImage().execute("http://www.sellfunn.com/ads/"+User_List.get(1).toString()+".jpg"); 

	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.log:
			Intent i=new Intent(MainActivity.this,Login.class);
			startActivity(i);
		break;
		case R.id.wishlist:
			Toast.makeText(this, "wishlist", Toast.LENGTH_LONG).show();
			break;
		case R.id.products:
			Intent i1=new Intent(MainActivity.this,Products.class);
			startActivity(i1);
			break;
		case R.id.contacts:
			Intent i2=new Intent(MainActivity.this,Contact.class);
			startActivity(i2);
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
public void image(View v)
{
	v.buildDrawingCache();
	Bitmap image = v.getDrawingCache();
	//Toast.makeText(this, image, Toast.LENGTH_SHORT).show();
	Intent in = new Intent(getApplicationContext(), Description.class);
	in.putExtra("url", image);
	startActivity(in);

	
	
}


public void query2()
{
Log.i("Android"," MySQL Connect Example.");
 Connection conn = null;
try {
String driver = "net.sourceforge.jtds.jdbc.Driver";
Class.forName(driver).newInstance();
//test = com.microsoft.sqlserver.jdbc.SQLServerDriver.class;
String connString = "jdbc:jtds:sqlserver://server_ip_address  :1433/DBNAME;encrypt=fasle;user=xxxxxxxxx;password=xxxxxxxx;instance=SQLEXPRESS;";
String username = "xxxxxx";
String password = "xxxxxxxxxx";
conn = DriverManager.getConnection(connString,username,password);
 Log.w("Connection","open");
Statement stmt = conn.createStatement();
ResultSet reset = stmt.executeQuery("select * from TableName");

//Print the data to the console
while(reset.next()){
Log.w("Data:",reset.getString(3));
 //              Log.w("Data",reset.getString(2));
}
conn.close();

  } catch (Exception e)
  {
  Log.w("Error connection","" + e.getMessage());
   }	
}	


private class LoadImage extends AsyncTask<String, String, Bitmap> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       

    }
     protected Bitmap doInBackground(String... args) {
         try {
        	    bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
        	    
        } catch (OutOfMemoryError e) {
            
              bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.coming);
              System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bitmap;
     }

     protected void onPostExecute(Bitmap images) {

         if(images != null){
        	  // Get the ImageView and its bitmap
        	    Drawable drawing = image[counter].getDrawable();
        	    Bitmap bitmap = ((BitmapDrawable)drawing).getBitmap();
        	 // Get current dimensions
        	    int width = bitmap.getWidth();
        	    int height = bitmap.getHeight();
        	    
        	    float scaleWidth = ((float) image[counter].getWidth()) / width;
        	    
        	    float scaleHeight = ((float) image[counter].getHeight()) / height;
        	    
        	 // CREATE A MATRIX FOR THE MANIPULATION
        	    
        	    Matrix matrix = new Matrix();
        	     
        	    // RESIZE THE BIT MAP
        	    
        	    matrix.postScale(scaleWidth, scaleHeight);
        	     
        	    Bitmap resizedBitmap=Bitmap.createScaledBitmap(images, (int)image[counter].getWidth(), (int)image[counter].getHeight(), true);
        	 // Create a new bitmap and convert it to a format understood by the ImageView
        	   // Bitmap resizedBitmap = Bitmap.createBitmap(image, 0, 0, width, height, matrix, true);
        	    BitmapDrawable result = new BitmapDrawable(resizedBitmap);
        	    
         image[counter].setImageDrawable(result);
         
         counter++;
         pDialog.dismiss();
         
         }else{

         pDialog.dismiss();
         Toast.makeText(MainActivity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

         }
     }
 }
// New Class


public class Ads extends AsyncTask<String,Void,String>{

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		
	
	
	try{
      
        
        String link="http://www.sellfunn.com/android/android_displayads.php";
       
        URL url = new URL(link);
        URLConnection conn = url.openConnection(); 
        
        conn.setDoOutput(true); 
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream()); 
        
   
        
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
@Override
protected void onPostExecute(String result){
//tv.setText(result);
	//String response=result;
	//int s1=response.indexOf('"');
//Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();	
	User_List= new ArrayList<String>();


try
{
	 
	
jArray = new JSONArray(result);
no_of_ads=jArray.length();
if(jArray!=null)
{
//Toast.makeText(getApplicationContext(), " 000000llll000000000000000"+jArray.length(), Toast.LENGTH_LONG).show();	
}

for (int i = 0; i < jArray.length(); i++)
{
             String a=jArray.getString(i);
   
          //  new LoadImage().execute("http://www.sellfunn.com/ads/"+ a +".jpg"); 
     Toast.makeText(getApplicationContext(), ""+a, Toast.LENGTH_SHORT).show();
 

User_List.add(a);
}


try{
	for (int i = 0; i < jArray.length(); i++)
	{
		String ss=User_List.get(i);	
new LoadImage().execute("http://www.sellfunn.com/ads/"+ ss +".jpg");
	}
}
catch(OutOfMemoryError e)
{
	Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_LONG).show();	
	
}
Toast.makeText(getApplicationContext(), " llll"+User_List.get(1).toString(), Toast.LENGTH_LONG).show();	

} 
catch (Exception e)
{
	 Toast.makeText(getApplicationContext(), " llll", Toast.LENGTH_LONG).show();	
	 pDialog.dismiss();
}
  

}
}

}
