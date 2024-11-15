import grafo.Dijkstra;
import grafo.Grafico;
import grafo.Grafo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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

        d.iniciarDijkstra(51);
        System.out.println("fin");
    }
}