/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package proyectoprogra1.joss.fran.cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank y joss
 */
public class caja {
    // creamos as varibale 
    private final int id;
    private final boolean paraPlataformas;
    private final List<cliente> datosDelClientes;
    private int tiempoOcupado;

    public caja(int id, boolean paraPlataformas, List<cliente> datosDelClientes, int tiempoOcupado) {
        this.id = id;
        this.paraPlataformas = paraPlataformas;
        this.datosDelClientes =  new ArrayList<>();
        this.tiempoOcupado = tiempoOcupado;
    }

    public int getId() {
        return id;
    }

    public boolean isParaPlataformas() {
        return paraPlataformas;
    }

    public List<cliente> getDatosDelClientes() {
        return datosDelClientes;
    }

    public int getTiempoOcupado() {
        return tiempoOcupado;
        if(historialClientes.isEmpty())
            return 0.0;
        int totalEspera = 0;
        for (Cliente c : historialClientes){
            totalEspera +=c.gettiempofila();
        }
        return (double) totalEspera /historialClientes.size();
    }
   public String getResumen(){
      return "caja " + id +(paraPlataformas "Plataformas" : "")+ "\n  Clientes atendidos: " + getClientesAtendidos() +
                "\n  Promedio de espera: " + String.format("%.2f", getPromedioEspera()) + " min\n";
   }
       public String getHistorialTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caja ").append(id).append(esPlataforma ? " (Plataforma)\n" : "\n");
        for (cliente c : historialClientes) {
            sb.append("  ").append(c.getTicket())
              .append(" - Esperó: ").append(c.getTiempoEnFila()).append(" min\n");
        }
        return sb.toString();
    }
}
