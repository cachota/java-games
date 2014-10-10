package es.hol.fpriego.tetris;

import java.util.Random;
import java.lang.Math;

//  The Shape class provides information about a tetris piece. 

public class Shape {

	//  The Tetrominoes enum holds all seven tetris shapes. Plus the empty shape called here NoShape. 
	
    enum Tetrominoes { NoShape, ZShape, SShape, LineShape, 
               TShape, SquareShape, LShape, MirroredLShape };

    private Tetrominoes pieceShape;
    private int coords[][];
    private int[][][] coordsTable;

    // This is the constructor of the Shape class. The coords array holds the actual coordinates of a Tetris piece

    public Shape() {

        coords = new int[4][2];
        setShape(Tetrominoes.NoShape);

    }

    public void setShape(Tetrominoes shape) {
    	
    	// The coordsTable array holds all possible coordinate values of our tetris pieces. 
    	// This is a template from which all pieces take their coordiate values
    	
         coordsTable = new int[][][] {
            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };
         
        // Here we put one row of the coordiate values from the coordsTable to a coords array of a tetris piece. 
        // Note the use of the ordinal() method. In C++, an enum type is esencially an integer. 
        // Unlike in C++, Java enums are full classes. And the ordinal() method returns the current position of 
        // the enum type in the enum object
        
        // For example, numbers { 0, -1 }, { 0, 0 }, { -1, 0 }, { -1, 1 } , represent a rotated S-shape
         
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }
        pieceShape = shape;

    }

    private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public Tetrominoes getShape()  { return pieceShape; }

    public void setRandomShape()
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values(); 
        setShape(values[x]);
    }

    public int minX()
    {
      int m = coords[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coords[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][1]);
      }
      return m;
    }
    
    // This code rotates the piece to the left. The square does not have to be rotated. 
    // That's why we simply return the reference to the current objectThis code rotates the piece to the left. 
    // The square does not have to be rotated. That's why we simply return the reference to the current object
    
    public Shape rotateLeft() 
    {
        if (pieceShape == Tetrominoes.SquareShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Shape rotateRight()
    {
        if (pieceShape == Tetrominoes.SquareShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}
