package com.example.imagerie3d;


public class Execution {
	public TouchLocalisation TouchStart;
	public TouchLocalisation TouchFinish;
	/*
	
	 void Execution(MotionEvent ev) {
	     final int historySize = ev.getHistorySize();
	     final int pointerCount = ev.getPointerCount();
	     for (int h = 0; h < historySize; h++) {
	    	// init var
	 		TouchStart.setX((int) ev.getHistoricalX(0, 0));             //recuper coord du debut
			TouchStart.setY((int) ev.getHistoricalY(0, 0));             //recuper coord du debut
			
	         for (int p = 0; p < pointerCount; p++) {
	 	 		TouchFinish.setX((int) ev.getHistoricalX(p, h));        //recuper coord du debut
	 	 		TouchFinish.setY((int) ev.getHistoricalY(p, h));        //recuper coord du debut
	         }
	     }
	     int parcourX = TouchStart.getX()-TouchFinish.getX();
	     int parcourY = TouchStart.getY()-TouchFinish.getY();
	     int pas = 5;
	     int indice;
	     //dessiner image
		 for(indice= 0;indice<pas;indice++){                                            //creer les images et les dessine
		 	 image.destroy();
			 image.rotation(Axe_x,parcourX/pas);
			 image.rotation(Axe_y,parcourY/pas);
			 image.fil_de_fer();
			 image.peintre();
			 image.show();
		 }
	 }
	 */
}
