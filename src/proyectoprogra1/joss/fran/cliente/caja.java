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
    // creamos las variables
    private final int id;
    private final boolean paraPlataformas;
    private final List<cliente> datosDeClientes;
    private int tiempoOcupado;
/* No se está usando por el momento:
    public caja(int id, boolean paraPlataformas, List<cliente> datosDeClientes, int tiempoOcupado) {
        this.id = id;
        this.paraPlataformas = paraPlataformas;
        this.datosDeClientes =  new ArrayList<>();
        this.tiempoOcupado = tiempoOcupado;
    }
*/ 
    //Constructor que usamos en el main
    public caja (int id, boolean paraPlataformas){
    this.id=id;
    this.paraPlataformas = paraPlataformas;
    this.datosDeClientes = new ArrayList<>();
    this.tiempoOcupado=0;
    }
public void atenderCliente(cliente c) {
        datosDeClientes.add(c);
        tiempoOcupado += c.getTiempoTransaccion();
    }
 public int getClientesAtendidos() {
        return datosDeClientes.size();
    }

    public int getId() {
        return id;
    }

    public boolean isParaPlataformas() {
        return paraPlataformas;
    }

    public List<cliente> getDatosDeClientes() {
        return datosDeClientes;
    }
/**
     * Método que devuelve el promedio de tiempo de espera de los clientes atendidos,
     * aunque el nombre se mantiene como getTiempoOcupado por claridad en el proyecto.
     */
    public int getTiempoOcupado() {
       if (datosDeClientes.isEmpty()) return (int) 0.0;
        int totalEspera = 0;
        for (cliente c : datosDeClientes) {
            totalEspera += c.getTiempoEnFila();
        }
        return (int) ((double) totalEspera /datosDeClientes.size());
    }
   public String getResumen(){
       return "Caja " + id +
                (paraPlataformas ? " (Plataforma)" : "") +
                "\n  Clientes atendidos: " + getClientesAtendidos() +
                "\n  Promedio de espera: " + String.format("%.2f",(double) getTiempoOcupado()) + " min\n";
    }
       public String getHistorialTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caja ").append(id).append(paraPlataformas ? " (Plataforma)\n" : "\n");
        for (cliente c : datosDeClientes) {
            sb.append("  ").append(c.getTicket())
              .append(" - Esperó: ").append(c.getTiempoEnFila()).append(" min\n");
        }
        return sb.toString();
    }
}
