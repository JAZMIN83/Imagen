/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarimagen;

import java.util.ArrayList;

/**
 *
 * @author Veronica Cortes y Jazmin Patiño
 */
public class GeneradorLecuyer {

    private long semillaX;
    private long semillaY;
    private int NumeroIteraciones;
    
    private ArrayList<Double> numerosAleatorio;
    private static int contador = 0;

    public void inicial(long semillaX, long semillaY, int NumeroIteraciones) {

        this.semillaX = semillaX;
        this.semillaY = semillaY;
        this.NumeroIteraciones = NumeroIteraciones;
        numerosAleatorio = new ArrayList<>();
    }

    public void generar() {

        long x = semillaX;
        long y = semillaY;
        long z;
        double resultado;

        for (int i = 0; i < NumeroIteraciones; i++) {

            x = generarX(x);
            y = generarY(y);
            z = generarZ(x, y);

            if (z > 0) {
                resultado = z / 2147483563.0;
            } else {
                resultado = 2147483562.0 / 2147483563.0;
            }

            getNumerosAleatorio().add(resultado);
        }
    }

    public long generarX(long x) {

        return (40014 * x) % 2147483563;
    }

    public long generarY(long y) {

        return (40692 * y) % 2147483399;
    }

    public long generarZ(long x, long y) {
        return Math.abs(x - y) % 2147483562;
    }

    // public void resultado() throws Exception {
    //   double resultado;
    //   resultado = (numeroAleatorioX + numeroAleatorioY + numeroAleatorioZ);
    //}
    public String imprimirResultados() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getNumerosAleatorio().size(); i++) {
            sb.append(String.format("%f\n", /*i + 1,*/ getNumerosAleatorio().get(i)));
        }

        return sb.toString();
    }

    public static void main(String args[]) throws Exception {

        GeneradorLecuyer m = new GeneradorLecuyer();
        m.inicial(2246, 4457, 100000);
        m.generar();
        System.out.print(m.imprimirResultados());
        
    }

    /**
     * @return the numerosAleatorio
     */
    public ArrayList<Double> getNumerosAleatorio() {
        return numerosAleatorio;
    }
    
    public int nextInt(int limite){
        
        if (contador >= NumeroIteraciones)
            contador = 0;
        
        return (int) (numerosAleatorio.get(contador++) * limite);
    }
}
