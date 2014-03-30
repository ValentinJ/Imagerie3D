package com.example.imagerie3d;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.io.FileNotFoundException;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Objet3D{

    private int unite, nbSommet, nbSegment, nbTriangle;
    private Double[][] listeSommet;
    private int[][] listeSegment, listeTriangle;

    public Objet3D(String fichier, int maxI) throws FileNotFoundException {
        GTSParseur parseur = new GTSParseur(fichier);
        unite = 400/(maxI*2);
        listeSommet = parseur.getSommets();
        listeSegment = parseur.getSegments();
        listeTriangle = parseur.getTriangles();
        nbSommet = parseur.getNbSommet();
        nbSegment = parseur.getNbSegment();
        nbTriangle = parseur.getNbTriangle();
    }

    public void translation(int x, int y, int z)
    {

        for(int i=0; i<nbSommet; i++)
        {
            listeSommet[i][0] += (double)x;
            listeSommet[i][1] += (double)y;
            listeSommet[i][2] += (double)z;

        }
    }
    /*
    rot = np.array([[1,0,0],[0,np.cos(alpha),-np.sin(alpha)],
            [0,np.sin(alpha), np.cos(alpha)]])
            if axe == AXE_Y:
    rot = np.array([[np.cos(alpha),0,np.sin(alpha)],[0,1,0],[-np.sin(alpha),0, np.cos(alpha)]])
    elif axe == AXE_Z:
    rot = np.array([[np.cos(alpha),-np.sin(alpha),0],[np.sin(alpha), np.cos(alpha),0],[0,0,1]])
    */

	public static Double[] produitMatrices (Double M1[][], Double M2[][] )     {
       int j, k; 
       Double produit[ ][ ] ;
       produit = new Double[1][3] ;

            for ( j = 0 ; j < 2 ; j++ )
            {
               produit[0][j] = 0.0 ;
               for( k = 0 ; k < 2 ; k++ )
                   produit[0][j] += M1[0][k] * M2[k][j] ;
            }
       Double[] produitfinal = new Double[] { produit[0][0], produit[0][1], produit[0][2]};
       return produitfinal ;
    }

    public static Double[] multiply(Double[] m1, Double[][] m2) {
        int m1rows = m1.length;
        int m1cols = 3;
        int m2rows = m2.length;
        int m2cols = 3;
        if (m1cols != m2rows)
            throw new IllegalArgumentException("matrices don't match: " + m1cols + " != " + m2rows);
        Double[] result = new Double[3];

        // multiply
        for (int i=0; i<m1rows; i++)
            for (int j=0; j<m2cols; j++)
                for (int k=0; k<m1cols; k++)
                    result[k] += m1[k] * m2[i][k];
        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int rowsInA = a.length;
        int columnsInA = a[0].length; // same as rows in B
        int columnsInB = b.length;
        int[][] c = new int[rowsInA][columnsInB];
        for (int i = 0; i < rowsInA; i++) {
            for (int j = 0; j < columnsInB; j++) {
                for (int k = 0; k < columnsInA; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public void rotation(double alpha, String axe)
    {
        Double[][] rot = new Double[3][3];
        if(axe == "AXE_X")
        {
            rot[0][0] = 1.0;
            rot[0][1] = 0.0;
            rot[0][2] = 0.0;
            rot[1][0] = 0.0;
            rot[1][1] = cos(alpha);
            rot[1][2] = -sin(alpha);
            rot[2][0] = 0.0;
            rot[2][1] = sin(alpha);
            rot[2][2] = cos(alpha);
            //self.sommets = [np.dot(rot,[x,y,z]) for [x,y,z] in self.sommets]

        }
        if(axe == "AXE_Y")
        {
            //[[np.cos(alpha),0,np.sin(alpha)],[0,1,0],[-np.sin(alpha),0, np.cos(alpha)]])
            rot[0][0] = cos(alpha);
            rot[0][1] = 0.0;
            rot[0][2] = sin(alpha);
            rot[1][0] = 0.0;
            rot[1][1] = 1.0;
            rot[1][2] = 0.0;
            rot[2][0] = -sin(alpha);
            rot[2][1] = 0.0;
            rot[2][2] = cos(alpha);
        }
        if(axe == "AXE_Z")
        {
            //([[np.cos(alpha),-np.sin(alpha),0],[np.sin(alpha), np.cos(alpha),0],[0,0,1]])
            rot[0][0] = cos(alpha);
            rot[0][1] = -sin(alpha);
            rot[0][2] = 0.0;
            rot[1][0] = sin(alpha);
            rot[1][1] = cos(alpha);
            rot[1][2] = 0.0;
            rot[2][0] = 0.0;
            rot[2][1] = 0.0;
            rot[2][2] = 1.1;
        }

        for(int i=0; i<nbSommet;i++)
        {
            Double[][] ligne = new Double[][] {{listeSommet[i][0], listeSommet[i][1], listeSommet[i][2]}};
            listeSommet[i] = produitMatrices(ligne, rot);
        }

    }

    public int px(double x)
    {
        double x1 = 200 + unite*x;
        return (int)x1;
    }

    public int py(double y)
    {
        double y1 = 200 + unite*y;
        return (int)y1;
    }
    
   
    // pour  dessiner 
    public boolean draw(Canvas c){
    	// creer une "toile" noire
    	c.drawRGB(0, 0, 0);
    	
	    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	    paint.setStrokeWidth(2);
	    paint.setColor(android.graphics.Color.BLUE);     
	    paint.setStyle(Paint.Style.FILL_AND_STROKE);
	    paint.setAntiAlias(true);
	
	    Path path = new Path();
	    path.setFillType(Path.FillType.EVEN_ODD);

	    // dessine les segments
        for(int i=0; i<nbSegment; i++){
            int ref1 = (listeSegment[i][0]);
            int ref2 = (listeSegment[i][1]);
            int x1 = px(listeSommet[ref1-1][0]);
            int y1 = py(listeSommet[ref1-1][1]);
            int x2 = px(listeSommet[ref2-1][0]);
            int y2 = py(listeSommet[ref2-1][1]);
            
            // D�finir l'�paisseur du segment
        	paint.setStrokeWidth (1);
        	// Puis dessiner nos points dans le cavenas	
            c.drawLine(x1,y1,x2,y2,paint);
        }
	    
	    path.close();
	    c.drawPath(path, paint);
	
	    return true;
    }
}
