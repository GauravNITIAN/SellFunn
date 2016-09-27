package com.sellfunn;


import android.net.Uri;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Login extends Activity {
EditText user,pass;
SQLiteDatabase db;
TextView text,text3;
RadioGroup radio;
String us;
static int res=10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		user=(EditText) findViewById(R.id.editText1);
		pass=(EditText) findViewById(R.id.editText2);
		text=(TextView) findViewById(R.id.textView1);
		text3=(TextView) findViewById(R.id.textView3);
		text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//	Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
				
				db=openOrCreateDatabase("loginmaster",MODE_PRIVATE,null);	
				final Dialog d=new Dialog(Login.this);	
				d.setContentView(R.layout.dialog);
				final EditText text1;
				final EditText text2, text3;
				text1=(EditText) d.findViewById(R.id.editText1);
				text2=(EditText) d.findViewById(R.id.editText2);
				text3=(EditText) d.findViewById(R.id.editText3);
				radio=(RadioGroup) d.findViewById(R.id.radioGroup1);
				ImageView ok=(ImageView) d.findViewById(R.id.ok);
				ImageView cancel=(ImageView) d.findViewById(R.id.cancel);
				d.setTitle("ForGot PassWord");
				d.show();
				//ImageView ok=(ImageView) findViewById(R.id.ok);
				ok.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
					//Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
						int id=radio.getCheckedRadioButtonId();
						RadioButton check=(RadioButton) d.findViewById(id);
						String text=(String) check.getText();
						String Email=text1.getText().toString();
						String phone=text2.getText().toString();
						String username=text3.getText().toString();
						
						Toast.makeText(getApplicationContext(), text+Email+phone+username, Toast.LENGTH_SHORT).show();
						try{
							Cursor c=db.rawQuery("select * from register where username='"+username+"' ", null);
						//	Toast.makeText(getApplicationContext(), "hello"+c, Toast.LENGTH_LONG).show();
							if(c.moveToFirst())
							{
							//	Toast.makeText(getApplicationContext(), "recrd is", Toast.LENGTH_SHORT).show();
								String pass=c.getString(2);
							//	Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();
								//Toast.makeText(getApplicationContext(), "WELCOME"+" ", Toast.LENGTH_SHORT).show();
								if(text.equals("Email"))
								{
									
									 Log.i("Send email", "");
										Intent emailIntent=new Intent();	
										emailIntent.setData(Uri.parse(Email));
										emailIntent.setType("text/plain");
										  emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery");
									      emailIntent.putExtra(Intent.EXTRA_TEXT, "your Pasword is "+pass);
									      
									      try {
									         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
									         finish();
									         Log.i("Finished sending email...", "");
									      }
									      catch (android.content.ActivityNotFoundException ex) {
									         Toast.makeText(Login.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
									      }
									
						//Toast.makeText(getApplicationContext(), "email", Toast.LENGTH_SHORT).show();			
								}
							
							else if(text.equals("Phone"))
							{
								Intent sms=new Intent(Intent.ACTION_VIEW);
								sms.setData(Uri.parse("smsto"));
								sms.setType("vnd.android-dir/mms-sms");
								sms.putExtra("address", new String(phone));
								sms.putExtra("smsbody", "Your Passoword is "+pass);
								startActivity(sms);
								Toast.makeText(getApplicationContext(), "Phone", Toast.LENGTH_SHORT).show();						
							}
							}
						
						else
						{
							Toast.makeText(getApplicationContext(), "Record Not Found", Toast.LENGTH_SHORT).show();
						}
						}
							catch(Exception e)
							{
								Toast.makeText(getApplicationContext(), "You have Not Registed yet", Toast.LENGTH_SHORT).show();
							}		
				d.dismiss();
					SQLiteDatabase.releaseMemory();
					db.close();
						
					}
				});
			cancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				d.dismiss();	
				}
			});	
				
				
				
				
			}
		});
		
	text3.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			result(res);
			
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
			Intent i=new Intent(Login.this,MainActivity.class);
			startActivity(i);
			finish();
		break;
		case R.id.wishlist:
			Toast.makeText(this, "wishlist", Toast.LENGTH_LONG).show();
			break;
		case R.id.products:
			Intent i1=new Intent(Login.this,Products.class);
			startActivity(i1);
			break;
		case R.id.contacts:
			Intent i2=new Intent(Login.this,Contact.class);
			startActivity(i2);
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
public void login(View v)	
{
	//db=openOrCreateDatabase("loginmaster",MODE_PRIVATE,null);
String u=user.getText().toString();
us=u;
String p=pass.getText().toString();
final Dialog dia=new Dialog(this);
dia.setContentView(R.layout.progress);
dia.setTitle("Please Wait Loading ...");
dia.show();
new SigninActivity(text3,1,dia,res).execute(u,p);
//text3.setText("this");
text3.setText("Us");

//Toast.makeText(getApplicationContext(), "here he;o"+text3.getText(), Toast.LENGTH_LONG).show();
//dia.setContentView(R.layout.progress);
//dia.show();
/*try{
Cursor c=db.rawQuery("select * from register where username='"+u+"' and password='"+p+"'", null);
if(c.moveToNext())
{
	Toast.makeText(getApplicationContext(), "WELCOME"+" "+u, Toast.LENGTH_SHORT).show();
	user.setText("");
	pass.setText("");
	SQLiteDatabase.releaseMemory();
	db.close();
	Intent i=new Intent(this,Profile.class);
	i.putExtra("key", u);
	startActivity(i);
}
else
{
	Toast.makeText(getApplicationContext(), "Please Sign Up First", Toast.LENGTH_SHORT).show();
	user.setText("");
	pass.setText("");
}
}
catch(Exception e)
{
	Toast.makeText(getApplicationContext(), "Register first", Toast.LENGTH_SHORT).show();
}*/
}
public void signup(View v)
{
	Intent i=new Intent(this,Register.class);
	startActivity(i);
}
public void forgot(View v)
{
	Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
	final Dialog d=new Dialog(this);	
	d.setContentView(R.layout.dialog);
	d.show();
}
public void facebook(View v)
{
Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();	
}
public void google(View v)
{
	Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();	
	
}

@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	
	//Toast.makeText(getApplicationContext(), "here he;o"+text3.getText(), Toast.LENGTH_LONG).show();

	if(res==1){
		Intent i=new Intent(this,Profile.class);
		i.putExtra("key", us);
		startActivity(i);
	}
	else if(res==0)
	{
		//text3.setText("Us");
		Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
	}
	
}

public  void result(int res)
{
	
	if(res==1)
	{
		Intent i=new Intent(this,Profile.class);
		i.putExtra("key", us);
		startActivity(i);
	}
	else if(res==0)
	{
		//text3.setText("Us");
		Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
	}
}
}
