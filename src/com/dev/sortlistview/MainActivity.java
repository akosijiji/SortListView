package com.dev.sortlistview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lv;
	String[] months = {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
	};
	
	ArrayAdapter<String> adapter;
	ArrayList<String> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView)findViewById (R.id.listView1);
		lv.setFastScrollEnabled(true);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, months);
		lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
        case R.id.sortasc:
        	list = new ArrayList<String>(Arrays.asList(months));
            Collections.sort(list);
            for(int i=0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            return true;
        case R.id.sortdesc:
        	list = new ArrayList<String>(Arrays.asList(months));
        	Collections.sort(list ,Collections.reverseOrder());
        	adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            return true;
        default:
            return super.onOptionsItemSelected(item);
		}
	}

}
