package com.sellfunn;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Register extends Activity {
SQLiteDatabase db;
EditText user,pass,repass,email,college,ans,fname,lname,mobile;
String q;
ImageView register;
Spinner select;
TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		fname=(EditText) findViewById(R.id.editText1);
		lname=(EditText) findViewById(R.id.editText2);
		email=(EditText) findViewById(R.id.editText3);
		user=(EditText) findViewById(R.id.editText4);
		college=(EditText) findViewById(R.id.editText5);
		mobile=(EditText) findViewById(R.id.editText6);
		pass=(EditText) findViewById(R.id.editText7);
		repass=(EditText) findViewById(R.id.editText8);
		ans=(EditText) findViewById(R.id.editText9);
		
		register=(ImageView) findViewById(R.id.imageView1);
		select=(Spinner) findViewById(R.id.spinner1);
		text=(TextView) findViewById(R.id.texview1);
		// Spinner  code is here
		
		String str[]={"Select","Your favourite car","your home's name","Your favourite color"};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,str);
		select.setAdapter(adapter);
		select.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
			q=select.getSelectedItem().toString();	
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	
	register.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		String f=fname.getText().toString();
		String l=lname.getText().toString();
		String e=email.getText().toString();
		String u=user.getText().toString();
		String c=college.getText().toString();
		String m=mobile.getText().toString();
		String p=pass.getText().toString();
		String re=repass.getText().toString();
		String a=ans.getText().toString();
		if(p.equals(re)){
			try{
				final Dialog dia=new Dialog(Register.this);
				dia.setContentView(R.layout.progress);
				dia.setTitle("Please Wait Loading ...");
				dia.show();
				new Signup(text,1,dia).execute(u,p,re,f,l,e,q,a,c,m);
		
		/*db.execSQL("insert into register values('"+e+"','"+u+"','"+p+"','"+ph+"')");

			email.setText("");
			user.setText("");
			pass.setText("");
			repass.setText("");
			phone.setText("");*/
	//Toast.makeText(getApplicationContext(), "Succesfully Registered",Toast.LENGTH_SHORT).show();	
	//Intent i=new Intent(getApplicationContext(),Login.class);
	//startActivity(i);
			}
			catch(Exception ex)
			{
				
				Toast.makeText(getApplicationContext(), "Exception Occred"+ex,Toast.LENGTH_SHORT).show();			
			}
			//SQLiteDatabase.releaseMemory();
			//db.close();
		}
		else
		{
		text.setText("Password not Matched");
			/*email.setText("");
			user.setText("");
			pass.setText("");
			repass.setText("");
			phone.setText("");*/
		}
		}
	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
			Intent i=new Intent(Register.this,MainActivity.class);
			startActivity(i);
			finish();
		break;
		case R.id.wishlist:
			Toast.makeText(this, "wishlist", Toast.LENGTH_LONG).show();
			break;
		case R.id.products:
			Intent i1=new Intent(Register.this,Products.class);
			startActivity(i1);
			break;
		case R.id.l:
			Intent i2=new Intent(Register.this,Login.class);
			startActivity(i2);
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
