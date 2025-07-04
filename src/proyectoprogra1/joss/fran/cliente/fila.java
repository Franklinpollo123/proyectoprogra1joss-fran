/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package proyectoprogra1.joss.fran.cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author frank y joss
 */

public class fila {
    private final int LIMITE_MAX = 25;
    private final Queue<cliente> colaA = new LinkedList<>();
    private final Queue<cliente> colaB = new LinkedList<>();
    private final Queue<cliente> colaC = new LinkedList<>();
    private final Queue<cliente> colaD = new LinkedList<>();
    private final Queue<cliente> colaE = new LinkedList<>();
    private final Queue<cliente> colaF = new LinkedList<>();
    private final Queue<cliente> colaG = new LinkedList<>();

    private final List<cliente> noAtendidos = new ArrayList<>();

    public boolean agregarCliente(cliente c) {
        if (totalEnFila() >= LIMITE_MAX) return false;

        switch (c.getPrioridad()) {
            case 'A' -> colaA.add(c);
            case 'B' -> colaB.add(c);
            case 'C' -> colaC.add(c);
            case 'D' -> colaD.add(c);
            case 'E' -> colaE.add(c);
            case 'F' -> colaF.add(c);
            case 'G' -> colaG.add(c);
        }

        return true;
    }

    public cliente siguienteGeneral() {
        if (!colaA.isEmpty()) return colaA.poll();
        if (!colaB.isEmpty()) return colaB.poll();
        if (!colaC.isEmpty()) return colaC.poll();
        if (!colaD.isEmpty()) return colaD.poll();
        if (!colaF.isEmpty()) return colaF.poll();
        if (!colaG.isEmpty()) return colaG.poll();
        return null;
    }

    public cliente siguientePlataforma() {
        return colaE.poll();
    }

    public void avanzarTiempo() {
        avanzar(colaA);
        avanzar(colaB);
        avanzar(colaC);
        avanzar(colaD);
        avanzar(colaE);
        avanzar(colaF);
        avanzar(colaG);
    }

    private void avanzar(Queue<cliente> cola) {
        Iterator<cliente> it = cola.iterator();
        while (it.hasNext()) {
            cliente c = it.next();
            c.incrementarTiempoEnFila();
            if (c.superoTolerancia()) {
                noAtendidos.add(c);
                it.remove();
            }
        }
    }

    public int totalEnFila() {
        return colaA.size() + colaB.size() + colaC.size() + colaD.size() + colaE.size() + colaF.size() + colaG.size();
    }

    public List<cliente> getNoAtendidos() {
        return noAtendidos;
    }

    public String mostrarFila() {
        StringBuilder sb = new StringBuilder("Clientes que estan en filas:\n");
        mostrarPorLetra(sb, "A", colaA);
        mostrarPorLetra(sb, "B", colaB);
        mostrarPorLetra(sb, "C", colaC);
        mostrarPorLetra(sb, "D", colaD);
        mostrarPorLetra(sb, "E", colaE);
        mostrarPorLetra(sb, "F", colaF);
        mostrarPorLetra(sb, "G", colaG);
        return sb.toString();
    }

    private void mostrarPorLetra(StringBuilder sb, String letra, Queue<cliente> cola) {
        if (!cola.isEmpty()) {
            sb.append(" Este cliente tiene Prioridad ").append(letra).append(":\n");
            for (cliente c : cola) {
                sb.append("  ").append(c.toString()).append("\n");
            }
        }
    }
            
}
