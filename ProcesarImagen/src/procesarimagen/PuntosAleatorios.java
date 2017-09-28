/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarimagen;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Veronica Cortes y Jazmin Patiño
 */
public class PuntosAleatorios {

    private final ArrayList<Punto> puntos;
    //final private Random rand = new Random();
    final private GeneradorLecuyer rand = new GeneradorLecuyer();
    private long numeroAleatorios;

    public PuntosAleatorios() {

        this.puntos = new ArrayList<>();
        
        rand.inicial(2246, 4457, 1000000);
        rand.generar();        
    }

    public void generar(int ancho, int alto, int porcentaje, int limite) {

        long tamano = ancho * alto;
        numeroAleatorios = (porcentaje * tamano / 100);
        
        Punto punto;
        if (porcentaje <= limite) {

            for (int i = 0; i < getNumeroAleatorios(); i++) {
                do {
                    punto = new Punto(rand.nextInt(ancho - 1), rand.nextInt(alto - 1));
                } while (getPuntos().contains(punto));
                getPuntos().add(punto);
            }
        } else {
            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    punto = new Punto(i, j);
                    getPuntos().add(punto);
                }                
            }
        }
    }

    /**
     * @return the puntos
     */
    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    /**
     * @return the numeroAleatorios
     */
    public long getNumeroAleatorios() {
        return numeroAleatorios;
    }
}
