package com.sunpro518.guanglun;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActiItem2 extends Activity{

	private TextView textv;
	private int itemArgs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_main_2);
		textv = (TextView)findViewById(R.id.textView1);
		Intent intent = getIntent();
		itemArgs = intent.getIntExtra("item", 0);
		textv.setText(itemArgs + "");
		
	}

	
	//[start]ActionBar
	public boolean onCreateOptionsMenu(Menu menu) {
		ActionBar actionbar = getActionBar();
		actionbar.setHomeButtonEnabled(true);
		actionbar.setDisplayHomeAsUpEnabled(true);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onOptionsMenuClosed(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home :
			Intent intent = new Intent(ActiItem2.this,MainGuanglun2.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	//[end]ActionBar

}
