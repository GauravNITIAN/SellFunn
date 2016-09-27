package com.sellfunn;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Products extends Activity {
int loc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.products, menu);
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
			Intent i=new Intent(Products.this,Login.class);
			startActivity(i);
		break;
		case R.id.wishlist:
			Toast.makeText(this, "wishlist", Toast.LENGTH_LONG).show();
			break;
		case R.id.home:
			Intent i1=new Intent(Products.this,MainActivity.class);
			startActivity(i1);
			finish();
			break;
		case R.id.books:
			Intent i2=new Intent(Products.this,Books.class);
			startActivity(i2);
			break;
		case R.id.notes:
			Intent i3=new Intent(Products.this,Notes.class);
			startActivity(i3);
			break;	
		case R.id.others:
			Intent i4=new Intent(Products.this,Others.class);
			startActivity(i4);
			break;	
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
public void cart(View v)
{
	switch(v.getId())
	{
	
	case R.id.imageButton3:
		loc=R.drawable.e4;
		break;
	case R.id.imageButton5:
		loc=R.drawable.book2;
		break;
	case R.id.imageButton6:
		loc=R.drawable.e1;
		break;
	
	case R.id.imageButton7:
		loc=R.drawable.e4;
		break;
	case R.id.imageButton8:
		loc=R.drawable.book10;
		break;
	case R.id.imageButton9:
		loc=R.drawable.book6;
		break;
	case R.id.imageButton10:
		loc=R.drawable.e8;
		break;
	case R.id.imageButton11:
		loc=R.drawable.e7;
		break;
	case R.id.imageButton12:
		loc=R.drawable.book7;
		break;
	case R.id.imageButton13:
		loc=R.drawable.e5;
		break;
	case R.id.imageButton16:
		loc=R.drawable.book9;
		break;
	case R.id.imageButton18:
		loc=R.drawable.book4;
		break;
	case R.id.imageButton14:
		loc=R.drawable.e3;
		break;
		case R.id.imageButton15:
			loc=R.drawable.e6;
			break;
			
			
	}
	Intent i=new Intent(this,Cart.class);
	i.putExtra("loc", loc);
	startActivity(i);
}
public void news(View v)
{
	switch(v.getId())
	{
	case R.id.imageButton1:
	
	Intent i1=new Intent(this,Books.class);
	startActivity(i1);
	break;
	case R.id.imageButton2:
		
		Intent i2=new Intent(this,Notes.class);
		startActivity(i2);
		break;
	case R.id.imageButton3:
		
		Intent i3=new Intent(this,Robotics.class);
		startActivity(i3);
		break;
	case R.id.imageButton4:
		
		Intent i4=new Intent(this,Others.class);
		startActivity(i4);
		break;
		
		
	}
	
}
}
