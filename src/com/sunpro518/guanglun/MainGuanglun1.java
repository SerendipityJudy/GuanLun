package com.sunpro518.guanglun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainGuanglun1 extends Activity {

	private Button buttonOriginal;
	private Button buttonExplain;
	private ListView mListView;
	private List<Map<String,Object>> mListItem;
	private String[] tempStr;
	public static int tempStrLength;
	private Boolean isExit = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_1);
		
		buttonOriginal = (Button)findViewById(R.id.button1);
		buttonExplain  = (Button)findViewById(R.id.button2);
		
		buttonOriginal.setOnClickListener(new myButtonOnClickListener());
		buttonExplain.setOnClickListener(new myButtonOnClickListener());
		
		tempStr = getResources().getStringArray(R.array.name_yuanwen);
		tempStrLength = tempStr.length;
		
		mListView = (ListView) findViewById(R.id.listView1);
        mListItem = getData();
        
        mListView.setAdapter(new SimpleAdapter(MainGuanglun1.this, mListItem, R.layout.activity_item_main_1,
        		new String[] {"nameOriginal"}, new int[] {R.id.textView1}));
        
        // ���ListView�е����¼�
        //Ϊ����Ӧ�û����б���ĵ��������÷���setOnItemClickListener()ΪListViewע�������
        //setOnItemClickListener()�����Ĳ�����һ���½���OnItemClickListener����
        //������Ա����ʵ��onItemClick()����
//arg0 The AdapterView where the click happened.�����¼���AdapterView,��ΪListView
//arg1 View���󣬴�Ϊ�������б���
//arg2 The position of the view in the adapter.��Ŀ��AdapterView�е�λ��0��1��2...
//arg3 The row id of the item that was clicked.ÿһ���б����ID
        
        mListView.setOnItemClickListener(new OnItemClickListener() {
             public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
              long arg3) {
            	 Toast.makeText(MainGuanglun1.this, "haoba " + arg2, Toast.LENGTH_SHORT).show();
            	 Intent intent = new Intent(MainGuanglun1.this,ActiItem1.class);
            	 intent.putExtra("item", arg2);
                 startActivity(intent);
             }
        });
	}
	
	private List<Map<String, Object>> getData() {
		  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		  
		  for (int i = 0; i < tempStrLength; i++) {
		   HashMap<String, Object> map = new HashMap<String, Object>();
		   map.put("nameOriginal", tempStr[i]);
		   list.add(map);
		  }
		  return list;
		 }
	
	private class myButtonOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.button1:
				//��ʽһ
//				Intent intent = new Intent(MainGuanglun1.this,MainGuanglun2.class);
//				startActivity(intent);
				//��ʽ��
				Intent intent = new Intent();
				intent.setClass(MainGuanglun1.this,MainGuanglun2.class);
				MainGuanglun1.this.startActivity(intent);
				break;
			case R.id.button2:
				
				break;
			default:
				break;
			}
		}
		
	}
	
	//[start]���η����˳�����;
			@SuppressLint("HandlerLeak")
			//import android.os.Handler;
			Handler mHandler = new Handler() {  
		        public void handleMessage(Message msg) {  
		            super.handleMessage(msg);  
		            //�������isExitʱ��Ҫ����ֵΪfalse������
		            isExit = false;  
		        }
		    }; 
		    @Override
		    public boolean onKeyDown(int keyCode, KeyEvent event) {
		        if (keyCode == KeyEvent.KEYCODE_BACK) {
		            exit();
		            return false;
		        } else {
		            return super.onKeyDown(keyCode, event);
		        }
		    }
		    public void exit(){  
		        if (!isExit) {  
		            isExit = true;  
		            Toast.makeText(getApplicationContext(), "�ٰ�һ�η��ؼ��ص�����", Toast.LENGTH_SHORT).show();  
		            mHandler.sendEmptyMessageDelayed(0, 2000);  
		        } else {  
		            Intent intent = new Intent(Intent.ACTION_MAIN);  
		            intent.addCategory(Intent.CATEGORY_HOME);  
		            startActivity(intent);  
//		            System.exit(0);  
		        }  
		    }
		    //[end]exit();

	
}
