package com.example.imagerie3d;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GTSParseur {
    private Double[][] sommets;
    private int[][] segments, triangles;
    private int nbSommet, nbSegment, nbTriangle;

    public GTSParseur(String fichier) throws FileNotFoundException {
        Scanner scanner= new Scanner(new File(fichier));
        String ligne1[] = scanner.nextLine().split(" ");

        nbSommet = Integer.parseInt(ligne1[0]);
        nbSegment = Integer.parseInt(ligne1[1]);
        nbTriangle = Integer.parseInt(ligne1[2]);
        sommets = new Double[nbSegment][3];
        for(int i = 0; i<nbSommet; i++){
            String[] liste = (scanner.nextLine().split(" "));
            sommets[i][0] = Double.parseDouble(liste[0]);
            sommets[i][1] = Double.parseDouble(liste[1]);
            sommets[i][2] = Double.parseDouble(liste[2]);
        }
        segments = new int[nbSegment][2];
        for(int i = 0; i<nbSegment; i++){
            String[] liste = (scanner.nextLine().split(" "));
            segments[i][0] = Integer.parseInt(liste[0]);
            segments[i][1] = Integer.parseInt(liste[1]);
        }
        triangles = new int[nbTriangle][3];
        for(int i = 0; i<nbTriangle; i++){
            String[] liste = (scanner.nextLine().split(" "));
            triangles[i][0] = Integer.parseInt(liste[0]);
            triangles[i][1] = Integer.parseInt(liste[1]);
            triangles[i][2] = Integer.parseInt(liste[2]);
        }
        scanner.close();
    }

    public Double[][] getSommets()
    {
        return sommets;
    }

    public int[][] getSegments()
    {
        return segments;
    }

    public int[][] getTriangles()
    {
        return triangles;
    }

    public int getNbSommet()
    {
        return nbSommet;
    }

    public int getNbSegment() {
        return nbSegment;
    }

    public int getNbTriangle() {
        return nbTriangle;
    }



}
