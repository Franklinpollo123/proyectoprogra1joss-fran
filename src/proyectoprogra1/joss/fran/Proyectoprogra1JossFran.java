/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogra1.joss.fran;
import java.util.ArrayList;
import java.util.List;
import proyectoprogra1.joss.fran.cliente.caja;
import proyectoprogra1.joss.fran.cliente.fila;
/**
 *
 * @author frank y jos
 */
public class Proyectoprogra1JossFran {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fila fila = new fila();

        // Crear 6 cajas: 5 generales, 1 plataforma
        List<caja> cajas = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            cajas.add(new caja(i, false));
        }
        cajas.add(new caja(6, true)); // Caja de plataforma

        boolean salir = false;
    }
    
}

