package com.sellfunn;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Contact extends Activity {
   TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		text=(TextView) findViewById(R.id.textView1);
		 Typeface face=Typeface.createFromAsset(getAssets(), "font/Roboto-CondensedItalic.ttf");
	        text.setTypeface(face);
		text.setText("Welcome To SeLLFunn.com"+"\n"+"Here You can Buy and Sell");
		text.append("\n"+"We Believe that Old is gold");
		text.append("\n"+"Contact Us 9798764192");
		text.append("\n"+"Email:gaurav4ever98@gmail.com");
		text.append("\n"+"location"+"Patna-20");
		text.append("\n"+"Bihar,India");
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
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
			Intent i=new Intent(this,Login.class);
			startActivity(i);
		break;
		case R.id.wishlist:
			Toast.makeText(this, "wishlist", Toast.LENGTH_LONG).show();
			break;
		case R.id.products:
			Intent i1=new Intent(this,Products.class);
			startActivity(i1);
			break;
		case R.id.home:
			Intent i2=new Intent(this,MainActivity.class);
			startActivity(i2);
			break;
		}
		return super.onMenuItemSelected(featureId, item);
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
}

