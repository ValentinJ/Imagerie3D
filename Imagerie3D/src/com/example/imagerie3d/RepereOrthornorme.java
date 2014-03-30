package com.example.imagerie3d;

import java.util.ArrayList;

import android.graphics.Canvas;

public class RepereOrthornorme{
	private double centre_x;
	private double centre_y;
	private Canvas draw; //TODO draw
	private double unite;
	
	public RepereOrthornorme(Canvas image, double maxI){
		centre_x = image.getWidth()/2;
		centre_y = image.getHeight()/2;
		draw = image; //TODO
		unite = image.getWidth()/(2*maxI);
	}
	
	//a voir
	public ArrayList<Integer> pixel_correspondant(double _x, double _y){
		int y = (int) (centre_y + unite*_x);
		int x = (int) (centre_x - unite*_y);
		
		ArrayList<Integer> r = new ArrayList<Integer>();
			r.add(x);
			r.add(y); 
		
		return r;
	}
	
	public Canvas getDraw(){
		return draw;
	}
}
