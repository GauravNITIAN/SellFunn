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
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Cart extends Activity {
 
	ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		image=(ImageView) findViewById(R.id.imageView1);
		Intent i=getIntent();
	int loc=i.getIntExtra("loc", R.drawable.branch1);
	image.setImageResource(loc);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cart, menu);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	
		return true;
	}
public void cart(View v)
{
	Toast.makeText(getApplicationContext(), "Activity under Contruction", Toast.LENGTH_SHORT).show();
}
}
