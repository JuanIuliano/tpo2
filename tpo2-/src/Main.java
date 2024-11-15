import grafo.Dijkstra;
import grafo.Grafico;
import grafo.Grafo;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        int opc;
        while(true){
            System.out.println("Ingresa el vertice para ver su costo mínimo desde 51 // -1 para terminar");
            opc = sc.nextInt();
            if(opc == -1){
                break;
            }
            d.mostrarCaminoMinimo(opc);
        }
        System.out.println("Fin");
    }
}
