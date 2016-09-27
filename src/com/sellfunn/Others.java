package com.sellfunn;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Others extends Activity {
	ListView list;
	 String[] web= {
		        "Pendrive"+"\n"+"Price: 400"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            "Laptop"+"\n"+"Price: 559"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            "Tablets"+"\n"+"Price: 599"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            "Camera"+"\n"+"Price: 499"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            "PenDrive"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            "PenDrive"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            "PenDrive"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		 
		            		  "Mobile"+"\n"+"Price: 550"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		  "Nokia"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		"Dell Laptop"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		 "Laptop"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		  "Dell Laptop"+"\n"+"Price: 800"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		    "Printer"+"\n"+"Price: 579"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		       "Dell Printer"+"\n"+"Price: 600"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		      "Hp Printer"+"\n"+"Price: 790"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		      "T-shirt"+"\n"+"Price: 700"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		  	  "T-shirt"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		     "T-shirt"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		    "T-shirt"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
		            		    	  "Tablets"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart"
		            		     	  
		    } ;
		    Integer[] imageId = {
		            R.drawable.m1,
		            R.drawable.e6,
		            R.drawable.e7,
		            R.drawable.e8,
		            R.drawable.m2,
		            R.drawable.m3,
		            R.drawable.m4,
		            R.drawable.m5,
		            R.drawable.m6,
		            R.drawable.m7,
		            R.drawable.m8,
		            R.drawable.m9,
		            R.drawable.m10,
		            R.drawable.m11,
		            R.drawable.m12,
		            R.drawable.m13,
		            R.drawable.m14,
		            R.drawable.m15,
		            R.drawable.m16,
		            R.drawable.m7
		 
		    };
		 
		    @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.activity_books);
		 
		        CustomList adapter = new
		                CustomList(this, web, imageId);
		        list=(ListView)findViewById(R.id.list);
		                list.setAdapter(adapter);
		                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		 
		                    @Override
		                    public void onItemClick(AdapterView<?> parent, View view,
		                                            int position, long id) {
		                        Toast.makeText(getApplicationContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
		 
		                    }

						
		    });
		    }
		    @Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.others, menu);
				ActionBar bar = getActionBar();
				bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
			
				return true;
			}
}
