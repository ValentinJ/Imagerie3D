package com.example.imagerie3d;

import java.io.FileNotFoundException;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class RenduVue extends View{
	Context con;
	String nom_fich;
	
	public RenduVue(Context context, String _nom_fich){
		super(context);
		con = context;
		nom_fich=_nom_fich;
	}
	
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.WHITE);
		canvas.drawPaint(paint);
		paint.setColor(Color.BLACK);
		/*canvas.drawCircle(10, 10, 100, paint);*/
		
		RepereOrthornorme repere = new RepereOrthornorme(canvas, 5);
		
		//afficher l objet
		Objet3D objet = null;
        try {
            objet = new Objet3D(nom_fich, 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        objet.draw(canvas);
        //peut etre manque t il un show ....
	}
}