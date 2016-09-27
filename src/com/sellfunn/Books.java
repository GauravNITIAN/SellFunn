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
public class Books extends Activity {
	    ListView list;
	    String[] web= {
	        "Computer Architecture"+"\n"+"Price: 400"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            "Software Engineering"+"\n"+"Price: 559"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            "Software Engineering"+"\n"+"Price: 599"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            "java Programing"+"\n"+"Price: 499"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            "Security Engineering"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            "Computer And Programing"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            "Civil Engneering"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		 
	            		  "Electrical Engneering"+"\n"+"Price: 550"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		  "Civil Engneering"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		"Engineering Mechanics"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		 "Marine Engineering"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		  "Marketing Engneering"+"\n"+"Price: 800"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		    "VlSI Design"+"\n"+"Price: 579"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		       "Electronic Circuit"+"\n"+"Price: 600"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		      "Mechanical Engneering"+"\n"+"Price: 790"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		      "Power Electronics"+"\n"+"Price: 700"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		  	  "Fluid mechanics"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		     "Unix Programing"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		    "HighWay Engneering"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
	            		    	  "Civil Engneering"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart"
	            		     	  
	    } ;
	    Integer[] imageId = {
	            R.drawable.book1,
	            R.drawable.book2,
	            R.drawable.book3,
	            R.drawable.book4,
	            R.drawable.book5,
	            R.drawable.book6,
	            R.drawable.book7,
	            R.drawable.book8,
	            R.drawable.book9,
	            R.drawable.book10,
	            R.drawable.book11,
	            R.drawable.book12,
	            R.drawable.book13,
	            R.drawable.book14,
	            R.drawable.book15,
	            R.drawable.book16,
	            R.drawable.book17,
	            R.drawable.book18,
	            R.drawable.book19,
	            R.drawable.book20
	 
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
			getMenuInflater().inflate(R.menu.books, menu);
			ActionBar bar = getActionBar();
			bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
		
			return true;
		}
}