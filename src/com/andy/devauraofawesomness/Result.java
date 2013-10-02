package com.andy.devauraofawesomness;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Result extends Activity implements OnClickListener {
	
	static int res=99;
	ImageView iv;
	Bitmap bmp;
	Button b1,b2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		getResult();
		
	}
	
	public void getResult()
	{
		iv= (ImageView) findViewById(R.id.imageView1);
		Random r=new Random();
		res=r.nextInt(5);
		System.out.println(res);
		switch(res)
		{
		case 0:
			iv.setImageResource(R.drawable.god);
			break;
		case 1:
			iv.setImageResource(R.drawable.saint);
			break;
		case 2:
			iv.setImageResource(R.drawable.fa);
			break;
		case 3:
			iv.setImageResource(R.drawable.wicked);
			break;
		case 4:
			iv.setImageResource(R.drawable.queer);
			break;
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.button1:
			Intent i=new Intent("com.andy.devauraofawesomness.PROCESS");
			startActivity(i);
		case R.id.button2:
			finish();
			System.exit(0);
		}
	}

}
