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
    private static int contador = 1; //permite llevar un consecutivo global de clientes
    private final int id;
    private final String ticket;
    private final char prioridad; // Letra que representa la prioridad del cliente
    private final int tiempoTransaccion; // Tiempo que el cliente necesita para realizar la transacción
    private final int tiempoTolerancia;   // Tiempo que el cliente está dispuesto a esperar en la fila
    private int tiempoEnFila = 0; //Tiempo que el cliente ha pasado en la fila
    // Constructor que recibe las condiciones del cliente y asigna la prioridad y el ticket:
     public cliente(boolean adultoMayor, boolean embarazada, boolean discapacidad,
                   boolean multiplesAsuntos, boolean plataforma, char genero) {
        this.id = contador++;
        this.prioridad = asignarPrioridad(adultoMayor, embarazada, discapacidad, multiplesAsuntos, plataforma, genero);
        this.ticket = id + "-" + prioridad;
        this.tiempoTransaccion = ThreadLocalRandom.current().nextInt(10, 121);
        this.tiempoTolerancia = ThreadLocalRandom.current().nextInt(5, 151);
    }
    // Método privado que determina la letra de prioridad según las características del cliente
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
        return contador; //no se está usando por el momento
    }

    public int getId() {
        return id; //no se está usando por el momento
    }
    // Método que devuelve el ticket completo del cliente
    public String getTicket() {
        return ticket;
    }
    // Método que devuelve la prioridad asignada al cliente
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
    public void incrementarTiempoEnFila() {
        this.tiempoEnFila++; //aumenta en uno el tiempo que el cliente lleva esperando
    }

    public boolean superoTolerancia() {
        return this.tiempoEnFila >= this.tiempoTolerancia; // indica si el cliente ha superado el tiempo de tolerancia
    }
     // Devuelve en texto la info del cliente
    @Override
    public String toString() {
        return "cliente{" + "id=" + id + ", ticket=" + ticket + ", prioridad=" + prioridad +
                ", tiempoTransaccion=" + tiempoTransaccion + "minutos"+ ", tiempoTolerancia=" + tiempoTolerancia +
                "minutos"+ ", tiempoEnFila=" + tiempoEnFila + '}';
    } 
}
