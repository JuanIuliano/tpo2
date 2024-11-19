import grafo.Dijkstra;
import grafo.Grafico;
import grafo.Grafo;

import java.util.*;
import javax.swing.*;

public class Main {

    public static int[][] agregarFila(Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd, int fila, int[][]costos){
        int centrosDistribucion = 8;
        int clientes = 50;
        for (Map.Entry<Grafo.NodoGrafo, Dijkstra.Etiqueta> entry : cdd.entrySet()) {
            int cliente = entry.getKey().vertice; // Cliente representado por la clave
            Dijkstra.Etiqueta valores = entry.getValue(); // Valores asociados (costos)

            if (cliente < clientes) { // Validar que el índice esté dentro del rango
                costos[fila][cliente] = valores.pesoAcumulado; // Tomamos el segundo valor como costo
            }
        }
        return costos;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Map<Grafo.NodoGrafo, Dijkstra.Etiqueta>> cdd = new ArrayList<>();
        List<Grafo.NodoCentroDistribucion> cdd_nodo = new ArrayList<>();
        Grafo g = new Grafo();
        Grafico graf = new Grafico(g);
        Auxiliar aux = new Auxiliar();
        Dijkstra d = new Dijkstra(g);


        g.inicializarGrafo(graf);
        aux.agregarVertices(g);
        aux.agregarAristas(g);

        g.mostrarGrafo();

        //Grafico
        JFrame frame = new JFrame("grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1550, 1350);

        Grafico panelGrafo = graf;
        frame.add(panelGrafo);
        frame.setVisible(true);


        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd0 = d.iniciarDijkstra(50);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd1 = d.iniciarDijkstra(51);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd2 = d.iniciarDijkstra(52);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd3 = d.iniciarDijkstra(53);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd4 = d.iniciarDijkstra(54);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd5 = d.iniciarDijkstra(55);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd6 = d.iniciarDijkstra(56);
        Map<Grafo.NodoGrafo, Dijkstra.Etiqueta> cdd7 = d.iniciarDijkstra(57);
        cdd.add(cdd0);
        cdd.add(cdd1);
        cdd.add(cdd2);
        cdd.add(cdd3);
        cdd.add(cdd4);
        cdd.add(cdd5);
        cdd.add(cdd6);
        cdd.add(cdd7);

        System.out.println("fin");
        for(int i = 0; i<5; i++){
            System.out.println();
        }
        System.out.println("50: "+cdd0.toString());
        System.out.println("51: "+cdd1.toString());
        System.out.println("52: "+cdd2.toString());
        System.out.println("53: "+cdd3.toString());
        System.out.println("54: "+cdd4.toString());
        System.out.println("55: "+cdd5.toString());
        System.out.println("56: "+cdd6.toString());
        System.out.println("57: "+cdd7.toString());

        for(int i = 0; i<5; i++){
            System.out.println();
        }

        for(int i=50; i<58; i++){
            cdd_nodo.add(g.devolverVerticecdd(i));
        }

        // Número de centros de distribución (filas) y clientes (columnas)
        int centrosDistribucion = 8;
        int clientes = 50;

        // Inicializar la matriz de costos con -1 (representa sin conexión)
        int[][] costos = new int[centrosDistribucion][clientes];
        for (int i = 0; i < centrosDistribucion; i++) {
            for (int j = 0; j < clientes; j++) {
                costos[i][j] = -1; // Inicialmente, todos los costos son -1
            }
        }

        for(int i=0; i<centrosDistribucion; i++){
            costos = agregarFila(cdd.get(i), i, costos);
        }



        System.out.print("CENTRO\tCOSTO FIJO\t");
        for (int j = 0; j < costos[0].length; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        // Filas de la tabla
        for (int i = 0; i < costos.length; i++) {
            System.out.print((50 + i) + "\t\t" + (i < costos.length ? cdd_nodo.get(i).costoAnual : "-") + "\t\t");
            for (int j = 0; j < costos[i].length; j++) {
                System.out.print((costos[i][j] == -1 ? "-" : costos[i][j]) + "\t");
            }
            System.out.println();
        }
    }



}
