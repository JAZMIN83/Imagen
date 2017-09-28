/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarimagen;

/**
 *
 * @author Veronica Cortes y Jazmin Patiño
 */
public class Punto {

    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object anotherObject) {

        if (this == anotherObject) {
            return true;
        }

        Punto that = (Punto) anotherObject;
        
        return this.x == that.getX() && this.y == that.getY();
    }
}
