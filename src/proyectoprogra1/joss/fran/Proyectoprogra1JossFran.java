/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogra1.joss.fran;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectoprogra1.joss.fran.cliente.caja;
import proyectoprogra1.joss.fran.cliente.cliente;
import proyectoprogra1.joss.fran.cliente.fila;
/**
 *
 * @author frank y jos
 */
public class Proyectoprogra1JossFran {

    /**
     * @param args the command line arguments
     */
    private static boolean confirmar(String pregunta) {
        int r = JOptionPane.showConfirmDialog(null, pregunta, "Confirmar", JOptionPane.YES_NO_OPTION);
        return r == JOptionPane.YES_OPTION;
    }
    public static void main(String[] args) {
        fila fila = new fila();

        // Crear 6 cajas: 5 generales, 1 plataforma
        List<caja> cajas = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            cajas.add(new caja(i, false));
        }
        cajas.add(new caja(6, true)); // Caja de plataforma
        //método confirmar para las opciones del menú
        
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    """
                    --- MENÚ PRINCIPAL ---
                    1. Registrar un nuevo cliente
                    2. Ver clientes en la fila actual
                    3. Avanzar tiempo (atención)
                    4. Ver clientes no atendidos
                    5. Ver reportes por caja
                    6. Salir
                    Ingrese una opción:
                    """);
            
            if (opcion == null) break;

            switch (opcion) {
                case "1" -> {
                    boolean adultoMayor = confirmar("¿Es adulto mayor?");
                    boolean embarazada = confirmar("¿Es embarazada o con niño en brazos?");
                    boolean discapacidad = confirmar("¿Tiene alguna discapacidad?");
                    boolean multiples = confirmar("¿Tiene múltiples asuntos?");
                    boolean plataforma = confirmar("¿Es un trámite exclusivo de Plataforma?");
                    String generoStr = JOptionPane.showInputDialog("¿Género? (F/M):");
                    if (generoStr == null || generoStr.isEmpty()) break;
                    char genero = generoStr.toUpperCase().charAt(0);

                    cliente c = new cliente(adultoMayor, embarazada, discapacidad, multiples, plataforma, genero);
                    if (fila.agregarCliente(c)) {
                        JOptionPane.showMessageDialog(null, "Cliente agregado:\n" + c);
                    } else {
                        JOptionPane.showMessageDialog(null, "La fila está llena. No se puede agregar más clientes.");
                    }
                }
                case "2" -> JOptionPane.showMessageDialog(null, fila.mostrarFila());
                case "3" -> {
                    fila.avanzarTiempo();

                    for (int i = 0; i < 5; i++) {
                        cliente siguiente = fila.siguienteGeneral();
                        if (siguiente != null) {
                            cajas.get(i).atenderCliente(siguiente);
                        }
                    }

                    cliente plataforma = fila.siguientePlataforma();
                    if (plataforma != null) {
                        cajas.get(5).atenderCliente(plataforma);
                    }

                    JOptionPane.showMessageDialog(null, "Simulación ejecutada. Tiempo avanzado y clientes atendidos.");
                }
                case "4" -> {
                    List<cliente> noAtendidos = fila.getNoAtendidos();
                    if (noAtendidos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay clientes que se hayan retirado.");
                    } else {
                        StringBuilder sb = new StringBuilder("Clientes que se retiraron sin ser atendidos:\n");
                        for (cliente c : noAtendidos) {
                            sb.append(c).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }
                case "5" -> {
                    StringBuilder reporte = new StringBuilder("--- Reportes por Caja ---\n\n");
                    for (caja caja : cajas) {
                        reporte.append(caja.getResumen()).append("\n");
                        reporte.append(caja.getHistorialTexto()).append("\n");
                    }
                    reporte.append("Total no atendidos: ").append(fila.getNoAtendidos().size());
                    JOptionPane.showMessageDialog(null, reporte.toString());
                }

                case "6" -> salir = true;

                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }

        JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema!");
    }
}

