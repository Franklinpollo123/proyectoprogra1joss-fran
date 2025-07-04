/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra1.joss.fran.cliente;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author frank y joss
 */
public class cliente {
      private static int contador = 1;

    private final int id;
    private final String ticket;
    private final char prioridad;
    private final int tiempoTransaccion; 
    private final int tiempoTolerancia;  
    private int tiempoEnFila = 0; 
    
     public cliente(boolean adultoMayor, boolean embarazada, boolean discapacidad,
                   boolean multiplesAsuntos, boolean plataforma, char genero) {
        this.id = contador++;
        this.prioridad = asignarPrioridad(adultoMayor, embarazada, discapacidad, multiplesAsuntos, plataforma, genero);
        this.ticket = id + "-" + prioridad;
        this.tiempoTransaccion = ThreadLocalRandom.current().nextInt(10, 121);
        this.tiempoTolerancia = ThreadLocalRandom.current().nextInt(5, 151);
    }

    private char asignarPrioridad(boolean adultoMayor, boolean embarazada, boolean discapacidad,
                                  boolean multiplesAsuntos, boolean plataforma, char genero) {
        if (adultoMayor) return 'A';
        if (embarazada) return 'B';
        if (discapacidad) return 'C';
        if (multiplesAsuntos) return 'D';
        if (plataforma) return 'E';
        return (genero == 'F' || genero == 'f') ? 'F' : 'G';
    }

    public static int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public String getTicket() {
        return ticket;
    }

    public char getPrioridad() {
        return prioridad;
    }

    public int getTiempoTransaccion() {
        return tiempoTransaccion;
    }

    public int getTiempoTolerancia() {
        return tiempoTolerancia;
    }

    public int getTiempoEnFila() {
        return tiempoEnFila;
    }

    @Override
    public String toString() {
        return "cliente{" + "id=" + id + ", ticket=" + ticket + ", prioridad=" + prioridad + ", tiempoTransaccion=" + tiempoTransaccion + "minutos"+ ", tiempoTolerancia=" + tiempoTolerancia + "minutos"+ ", tiempoEnFila=" + tiempoEnFila + '}';
    }

    void incrementarTiempoEnFila() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean superoTolerancia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
}
