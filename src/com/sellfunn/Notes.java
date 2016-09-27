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
public class Notes extends Activity {

	ListView list;
    String[] web= {
        "Data Stucture"+"\n"+"Price: 400"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Complier Design"+"\n"+"Price: 559"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Computer Architecture"+"\n"+"Price: 599"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Fluid Mechanics"+"\n"+"Price: 499"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Mechanics"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Mathemtics"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
            "Soil Engineering"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		 
            		  "Engineering drawing"+"\n"+"Price: 550"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		  "Water Engineering"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		"Signal System"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		 "Digital Electonics"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		  "Analog Electronics"+"\n"+"Price: 800"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		    "Electical Engg"+"\n"+"Price: 579"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		       "Power System"+"\n"+"Price: 600"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		      "Transformation"+"\n"+"Price: 790"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		      "c language"+"\n"+"Price: 700"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		  	  "Web Design"+"\n"+"Price: 699"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		     "Information tech"+"\n"+"Price: 299"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		    "Environment science"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart",
            		    	  "Chemical Engg"+"\n"+"Price: 500"+"\t\t\t\t\t\t\t"+"Add To Cart"
            		     	  
    } ;
    Integer[] imageId = {
            R.drawable.branch1,
            R.drawable.branch1,
            R.drawable.branch1,
            R.drawable.branch2,
            R.drawable.branch2,
            R.drawable.branch2,
            R.drawable.branch3,
            R.drawable.branch3,
            R.drawable.branch3,
            R.drawable.branch4,
            R.drawable.branch4,
            R.drawable.branch4,
            R.drawable.branch5,
            R.drawable.branch5,
            R.drawable.branch5,
            R.drawable.branch6,
            R.drawable.branch6,
            R.drawable.branch6,
            R.drawable.branch7,
            R.drawable.branch7
 
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
		getMenuInflater().inflate(R.menu.notes, menu);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	
		return true;
	}
}
