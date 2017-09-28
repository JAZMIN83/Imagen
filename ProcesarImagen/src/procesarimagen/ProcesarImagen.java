/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarimagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Veronica Cortes y Jazmin Patiño
 */
public class ProcesarImagen {

    final private PuntosAleatorios puntosAleatorios;
    private BufferedImage img;
    private File f = null;
    final private int[][] contadores = new int[3][2];
    private int ancho;
    private int alto;

    public ProcesarImagen() {
        contadores[0][1] = 0;
        contadores[1][1] = 0;
        contadores[2][1] = 0;
        this.puntosAleatorios = new PuntosAleatorios();
    }

    public int[][] calcular(String ruta, int porcentaje, int limite) throws IOException {

        f = new File(ruta);
        
        img = ImageIO.read(f);

        ancho = img.getWidth();
        alto = img.getHeight();

        getPuntosAleatorios().generar(getAncho(), getAlto(), porcentaje, limite);

        ArrayList<Punto> pa = getPuntosAleatorios().getPuntos();

        for (int i = 0; i < pa.size(); i++) {
            Punto get = pa.get(i);
            int argb = img.getRGB(get.getX(), get.getY());

            contadores[identificarColor(argb)][1] += 1;
        }
        
        return contadores;
    }

    private int identificarColor(int argb) {

        // int alfa = (argb >> 24) & 0xff;
        int rojo = (argb >> 16) & 0xff;
        int verde = (argb >> 8) & 0xff;
        int azul = argb & 0xff;

        if (rojo > 127 && verde > 127 && azul > 127) {
            return 1; // es blanco
        }
        if (rojo <= 127 && verde <= 127 && azul <= 127) {
            return 0; // es negro
        }
        return 2; // otro color
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @return the puntosAleatorios
     */
    public PuntosAleatorios getPuntosAleatorios() {
        return puntosAleatorios;
    }
}

/**
 *
 *
 * Ancho: 278 Alto: 143 Puntos totales 39754 Negro:18006 45.29% Blanco:21748
 * 54.70% Otro:0
 *
 * Area blanca 13.33333333333333 55.55% Area negra 10.66666666666666 44.44% Area
 * total 24
 *
 * 24 %100
 *
 * 39754 % 100
 *
 *
 * [253 254 255] [254 255 255] [255 255 255] [250 250 250] [171 171 171] [ 0 0
 * [254 255 255] [254 255 255] [252 252 252] [242 242 242] [ 52 52 52] [ 2 2
 * [254 254 254] [255 255 255] [255 255 255] [142 142 142] [ 0 0 0] [ 1 1 1]
 * [255 255 255] [255 255 255] [220 220 220] [ 45 45 45] [ 0 0 0] [ 0 0 0] [250
 * 250 250] [255 255 255] [144 144 144] [ 0 0 0] [ 2 2 2] [ 0 0 0] [255 255 253]
 * [239 239 239] [ 54 54 54] [ 0 0 0] [ 0 0 0] [ 0 0 0] [255 255 253] [169 168
 * 166] [ 3 2 0] [ 1 0 0] [ 1 0 0] [ 0 0 0] [253 252 248] [ 76 75 73] [ 1 0 0] [
 * 4 3 1] [ 0 0 0] [ 0 0 0] [126 122 119] [ 8 4 1] [ 1 0 0] [ 1 0 0] [ 0 0 0] [
 * 0 0 0] [ 23 22 20] [ 3 2 0] [ 1 0 0] [ 1 0 0] [ 0 0 0] [ 0 0 0] [ 62 62 62] [
 * 0 0 0] [ 0 0 0] [ 0 0 0] [ 0 0 0] [ 0 0 0] [ 23 24 26] [ 0 0 2] [ 6 7 9] [ 0
 * 0 0] [ 0 0 0] [ 0 0 0] [ 6 7 9] [ 0 0 2] [ 0 0 2] [ 0 0 0] [ 0 0 0] [ 0 0 0]
 * [ 1 2 4] [ 0 0 2] [ 0 0 1] [ 0 0 0] [ 0 0 0] [ 0 0 0] [ 0 1 3] [ 0 0 2] [ 0 0
 *
 *
 *
 *
 *
 *
 * 01234567890123456789012345678901 AAAAAAAA
 *
 *
 *
 *
 * 10000000 11111111 ________ 10000000
 *
 * 1 & 1 = 1
 * 1 & 0 = 0
 * 0 & 1 = 0
 * 0 & 0 = 0
 *
 * 1 | 1 = 1
 * 1 | 0 = 1
 * 0 | 1 = 1
 * 0 | 0 = 0
 *
 *
 *
 * https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
 * https://es.wikipedia.org/wiki/RGB
 * https://en.wikipedia.org/wiki/Linear_interpolation
 *
 */
