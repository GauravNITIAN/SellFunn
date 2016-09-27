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
public class Robotics extends Activity {
    ListView list;
    String[] web= {
        "Robotics"+"\n"+"Price: 400"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Robotics"+"\n"+"Price: 559"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Robotics"+"\n"+"Price: 599"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Robotics"+"\n"+"Price: 499"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Robotics"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Robotics"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Robotics"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		 
            		  "Robotics"+"\n"+"Price: 550"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		  "Robotics"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		"Robotics"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		 "Robotics"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		  "Robotics"+"\n"+"Price: 800"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		    "Robotics"+"\n"+"Price: 579"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		       "Robotics"+"\n"+"Price: 600"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		      "Robotics"+"\n"+"Price: 790"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		      "Robotics"+"\n"+"Price: 700"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		  	  "Robotics"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		     "Robotics"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		    "Robotics"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		    	  "Robotics"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart"
            		     	  
    } ;
    Integer[] imageId = {
            R.drawable.e1,
            R.drawable.e2,
            R.drawable.e3,
            R.drawable.e4,
            R.drawable.e5,
            R.drawable.e6,
            R.drawable.e7,
            R.drawable.e8,
            R.drawable.e9,
            R.drawable.e10,
            R.drawable.e11,
            R.drawable.e12,
            R.drawable.e13,
            R.drawable.e1,
            R.drawable.e2,
            R.drawable.e3,
            R.drawable.e4,
            R.drawable.e5,
            R.drawable.e6,
            R.drawable.e7
 
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
		getMenuInflater().inflate(R.menu.robotics, menu);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	
		return true;
	}
}
