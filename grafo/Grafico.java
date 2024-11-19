package grafo;
import grafo.Grafo;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Grafico extends JPanel{

    private Grafo grafo;
    private Map<Integer, Point> posicionesNodos;

    public Grafico(Grafo grafo) {
        this.grafo = grafo;
        this.posicionesNodos = new HashMap<>();
    }

    public void setPos(int vert, int posx, int posy){
        this.posicionesNodos.put(vert, new Point(posx, posy));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;

        // Dibujar aristas
        //System.out.println(posicionesNodos.toString());
        for (Integer clave : grafo.vertices.keySet()) {
            Grafo.NodoGrafo nodo = grafo.vertices.get(clave);
            Point posNodo = posicionesNodos.get(clave);

            if (posNodo == null){
                continue;
            }

            Grafo.Arista arista = nodo.arista;
            while (arista != null) {
                Point posNodoDestino = posicionesNodos.get(arista.incide.vertice);

                if (arista.peso <= 0) {
                    g2.setColor(Color.GREEN);
                    g2.setStroke(new BasicStroke(4)); // Línea gruesa
                } else {
                    g2.setColor(Color.BLACK); // Volver a negro para pesos positivos
                    g2.setStroke(new BasicStroke(1)); // Línea fina
                }

                g2.drawLine(posNodo.x, posNodo.y, posNodoDestino.x, posNodoDestino.y);

                // Etiqueta con el peso de la arista en el punto medio
                int midX = (posNodo.x + posNodoDestino.x) / 2;
                int midY = (posNodo.y + posNodoDestino.y) / 2;
                g.drawString(String.valueOf(arista.peso), midX, midY);

                arista = arista.sigArista;
            }
        }

        // Dibujar nodos
        for (Integer clave : grafo.vertices.keySet()) {
            Point pos = posicionesNodos.get(clave);
            if (pos == null){
                continue;
            }

            // Dibujar el nodo como un círculo
            if(grafo.vertices.get(clave) instanceof Grafo.NodoCentroDistribucion){
                g.setColor(Color.RED);
            }
            else {
                g.setColor(Color.BLUE);
            }
            g.fillOval(pos.x - 15, pos.y - 15, 30, 30);  // Radio de 15 para el nodo

            // Dibujar el valor del vértice en el nodo
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(clave), pos.x - 5, pos.y + 5);
            if(grafo.vertices.get(clave).vertice == 57){
                g.setColor(Color.BLACK);
                g.drawString("PUERTO", pos.x + 20, pos.y + 5);
            }
        }

    }

}