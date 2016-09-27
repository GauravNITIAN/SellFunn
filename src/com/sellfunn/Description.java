package com.sellfunn;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Description extends Activity {
ImageView image;
Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_description);
		image=(ImageView)findViewById(R.id.imageView1);
		Intent in = getIntent();
		
		 Bitmap bitmap =(Bitmap) in.getParcelableExtra("url");
		 if(bitmap!=null)
		 {
		//Toast.makeText(getApplicationContext(), "Not Null", Toast.LENGTH_SHORT).show();

		 image.setImageBitmap(bitmap);
		 }
		 else
		 {
			 
		 }
				//Toast.makeText(getApplicationContext(), " Null"+str, Toast.LENGTH_SHORT).show();

	//Toast.makeText(getApplicationContext(), (CharSequence) img, Toast.LENGTH_SHORT).show();

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.description, menu);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	
		return true;
	}
	public void home(View v)
	{
Intent i=new Intent(this,MainActivity.class);
startActivity(i);
	}
	public void products(View v)
	{
		Intent i=new Intent(this,Products.class);
		startActivity(i);
	}
	public void login(View v)
	{
		Intent i=new Intent(this,Login.class);
		startActivity(i);
	}
	public void contact(View v)
	{
		Intent i=new Intent(this,Contact.class);
		startActivity(i);
	}
	public void add(View v)
	{
		Toast.makeText(getApplicationContext(), "Activity under construction", Toast.LENGTH_SHORT).show();
	}
	
}
