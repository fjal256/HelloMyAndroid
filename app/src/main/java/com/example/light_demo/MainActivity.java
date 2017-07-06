package com.example.light_demo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends Activity {
	Button Blue , Red , Green , Read_Red , Read_Blue , Read_Green;
	FileWriter fw;
	boolean flg_Blue ,flg_Green ,flg_Red;
	private EditText Red_Value , Green_Value , Blue_Value,tempText;
	private final static  String green_port ="117";
	private final static  String red_port ="114";
	private final static  String blue_port ="119";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Red_Value = (EditText)findViewById(R.id.editText1);
		Green_Value = (EditText)findViewById(R.id.editText2);
		Blue_Value = (EditText)findViewById(R.id.editText3);
		Red = (Button)findViewById(R.id.button1);
		Red.setOnClickListener(new MyClickListener());
		Blue = (Button)findViewById(R.id.button5);
		Blue.setOnClickListener(new MyClickListener());
		Green = (Button)findViewById(R.id.button3);
		Green.setOnClickListener(new MyClickListener());
		Read_Red = (Button)findViewById(R.id.button2);
		Read_Red.setOnClickListener(new MyClickListener());
		Read_Blue = (Button)findViewById(R.id.button6);
		Read_Blue.setOnClickListener(new MyClickListener());
		Read_Green = (Button)findViewById(R.id.button4);
		tempText = (EditText) findViewById(R.id.editText6);
		Read_Green.setOnClickListener(new MyClickListener());
		Red_Value.setText("newmobi");
		Blue_Value.setText("newmobi");
		Green_Value.setText("newmobi");
	}
	class MyClickListener implements OnClickListener {
	    public void onClick(View v) {
		   	 switch (v.getId()) {
		   	 case R.id.button1:
			   		try {
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio");
						fw.write(red_port);
						fw.close();
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio_inout");
						if(flg_Red)
						{
							Red.setText("ON");
							fw.write("01");
							flg_Red = false ;		
						}else
						{
							Red.setText("OFF");
							fw.write("00");
							flg_Red = true ;			
						}
				   		fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		 break;
		   	 case R.id.button5:
			   		try {
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio");
						String string =tempText.getText().toString();

						if(TextUtils.isEmpty(string)){
							fw.write(blue_port);
						}else {
							fw.write(string);
						}
						fw.close();
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio_inout");
						if(flg_Blue)
						{
							Blue.setText("ON");
							fw.write("01");
							flg_Blue = false ;
						}else
						{
							Blue.setText("OFF");
							fw.write("00");
							flg_Blue = true ;			
						}
				   		fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		 break;
		   	 case R.id.button3:
			   		try {
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio");
						fw.write(green_port);
						fw.close();
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio_inout");
						if(flg_Green)
						{
							Green.setText("ON");
							fw.write("01");
							flg_Green = false ;		
						}else
						{
							Green.setText("OFF");
							fw.write("00");
							flg_Green = true ;			
						}
				   		fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		 break;
		   	 case R.id.button2:
			   		try {
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio");
						fw.write(red_port);
						fw.close();
						FileReader Red_fr = new FileReader("/sys/class/newmobi_gpio/newmobi_gpio/Gpio_inout");
			   			BufferedReader Red_br = new BufferedReader(Red_fr);
			   			Red_Value.setText(Red_br.readLine().toString());
			   			Red_fr.close();
			   			Red_br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		 break;
		   	 case R.id.button6:
			   		try {
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio");
						String string =tempText.getText().toString();

						if(TextUtils.isEmpty(string)){
							fw.write(blue_port);
						}else {
							fw.write(string);
						}

						fw.close();
						FileReader Blue_fr = new FileReader("/sys/class/newmobi_gpio/newmobi_gpio/Gpio_inout");
			   			BufferedReader Blue_br = new BufferedReader(Blue_fr);
			   			Blue_Value.setText(Blue_br.readLine().toString());
			   			Blue_fr.close();
			   			Blue_br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		 break;
		   	 case R.id.button4:
			   		try {
						fw = new FileWriter("/sys/class/newmobi_gpio/newmobi_gpio/Gpio");
						fw.write(green_port);
						fw.close();
						FileReader Green_fr = new FileReader("/sys/class/newmobi_gpio/newmobi_gpio/Gpio_inout");
			   			BufferedReader Green_br = new BufferedReader(Green_fr);
			   			Green_Value.setText(Green_br.readLine().toString());
			   			Green_fr.close();
			   			Green_br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		 break;
		   	 	default:
					break;
		   	 }
	    }

		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
