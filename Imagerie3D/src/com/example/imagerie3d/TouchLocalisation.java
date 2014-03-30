package com.example.imagerie3d;


public class TouchLocalisation {
	public int coordX;
	public int coordY;
	
	public TouchLocalisation(int X, int Y){
		coordX=X;
		coordY=Y;
	}
	
	public int getX(){
		return coordX;
	}
	public int getY(){
		return coordY;
	}

	public void setX(int x) {
		// TODO Auto-generated method stub
		coordX=x;
	}
	
	public void setY(int y) {
		// TODO Auto-generated method stub
		coordY=y;
	}

}
