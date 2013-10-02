package com.andy.devauraofawesomness;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class Process extends Activity {
	
	ImageView iv;
	final int cameraData=0;
	Bitmap bmp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		init();
	}
	
	public void init()
	{
		iv= (ImageView) findViewById(R.id.imageView1);
		iv.setVisibility(0);
		Intent i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(i, cameraData);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode ==RESULT_OK)
		{
			iv.setVisibility(1);
			Bundle extra= data.getExtras();
			bmp=(Bitmap) extra.get("data");
			iv.setImageBitmap(bmp);
			Thread timer= new Thread(){
				public void run(){
					try{
						sleep(5000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					finally{
						Intent n = new Intent("com.andy.devauraofawesomness.RESULT");
						startActivity(n);
						finish();
					}
				}
			};
			timer.start();
		}
	}


	
}
