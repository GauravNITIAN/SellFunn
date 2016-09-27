package com.sellfunn;


import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Sellfunn extends Activity {
Thread th;
TextView text;
ImageView image;
RelativeLayout relative;
ProgressBar progress;
Intent i;
View v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front);
		
		text=(TextView) findViewById(R.id.textView1);
		v=(RelativeLayout) findViewById(R.id.relative);
		v.setBackgroundDrawable(getResources().getDrawable(R.drawable.front));
		progress=(ProgressBar) findViewById(R.id.progressBar1);
		//progress.
		setTitle("SellFunN");
		final Dialog dia=new Dialog(this);
		dia.setContentView(R.layout.progress);
		dia.setTitle("Please Wait Loading ...");
		dia.show();
		new FrontPage(dia,text).execute("user","password");
		
		
		text.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				i=new Intent(Sellfunn.this,MainActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				//result(res);
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				//result(res);
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		
		
		return super.onCreateDialog(id);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.front, menu);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	
		return true;
	}



}
