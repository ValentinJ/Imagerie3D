package com.example.imagerie3d;


import java.io.FileNotFoundException;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		RenduVue rendu =new RenduVue(this,"/sdcard/figures/cone.gts");
		setContentView(rendu);
		/*
        super.onCreate(savedInstanceState);
        setContentView(new RenderView(this));*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    
    
   

}
