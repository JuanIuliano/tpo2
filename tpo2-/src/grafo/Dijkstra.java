package grafo;
import colaPrio.ColaPrioridad;

import java.util.*;

public class Dijkstra {

    Grafo g;  //Grafo sobre el cual vamos a aplicar Dijkstra
    Set <Grafo.NodoGrafo> visitados = new HashSet<>(); //Set para guardar los vertices ya visitados
    Map<Grafo.NodoGrafo, HashMap<Grafo.NodoGrafo, Integer>> caminos = new HashMap<>(); //Diccionario que contiene el vertice como clave y otro diccionario como valor, el cual a su vez contiene el vertice anterior del camino y el costo total para llegar a el
    int cantVertices;

    //Constructor, recibe el grafo sobre el cual vamos a aplicar Dijkstra como parámetro
    public Dijkstra(Grafo g){
        this.g = g;
        cantVertices = g.cantidadVertices();
    }


    private class Etiqueta{
        Grafo.NodoGrafo anterior;
        int pesoAcumulado;

        public String toString(){
            if(this.anterior == null){
                return "null" + String.valueOf(pesoAcumulado);
            }
            return "("+anterior.toString()+", " + String.valueOf(pesoAcumulado)+")";
        }
    }
    Map<Grafo.NodoGrafo, Etiqueta> caminos_ = new HashMap<>();


    public void iniciarDijkstra(int v_){

        //Obtenemos la cantidad de vertices totales del grafo
        this.cantVertices = g.cantidadVertices();

        //Obtenemos la referencia al vertice v_ (también comprobamos que exista)
        Grafo.NodoGrafo v = null;
        if(g.existeVertice(v_)){
            v = g.devolverVertice(v_);
        }else{ //El vertice v no existe en el grafo
            System.out.println("No existe el vertice");
            return;
        }
        //En esta cola de prioridad vamos a almacenar los candidatos (Los vertices que tengan un costo mas bajo)
        ColaPrioridad cola = new ColaPrioridad();
        cola.AcolarPrioridad(v, null, 0);
        //Empezamos a buscar los caminos
        dijkstraRecursivo(cola);

        //Mostrar resultados
        System.out.println(caminos_.toString());
    }

    //HashMap que sirve para tener a mano cuales son los pesos de los elementos que estan en la cola (es màs ràpido que buscarlos directamente en la cola)
    Map<Grafo.NodoGrafo, Integer> pesosEnCola = new HashMap<>();

    //Algoritmo recursivo para encontrar caminos mìnimos
    public void dijkstraRecursivo(ColaPrioridad cola) {
        //System.out.println("Vuelta en dijkstra recursivo");
        //A CHEQUEAR QUE ESTA CONDICIÒN ESTE BIEN, PQ SI EL GRAFO NO ES CONEXO NO SE VA A CUMPLIR NUNCA
        if (visitados.size() >= cantVertices) {
            return;
        }

        // Debuggear
        System.out.println();
        System.out.println("Actual: " + cola.Primero().vertice);
        System.out.println("VISITADOS");
        System.out.println(visitados.toString());
        System.out.println("CAMINOS");
        System.out.println(caminos_.toString());

        Etiqueta etiquetaV = null;
        int pesoAcumulado = 0;
        Grafo.NodoGrafo v = null;

        //Si no tenemos ninùn candidato volvemos
        if (cola.ColaVacia()) {
            return;
        }

        //Seleccionamos candidato y lo sacamos de la cola
        v = cola.Primero();
        cola.Desacolar();

        // Si el candidato ya fue visitado antes, pasamos al siguiente
        if (visitados.contains(v)) {
            dijkstraRecursivo(cola);
            return;
        }

        // Marcamos como visitado
        visitados.add(v);

        // Creamos etiqueta del vértice si no tiene una asignada
        if (!caminos_.containsKey(v)) {
            Etiqueta e = new Etiqueta();
            e.anterior = null;
            e.pesoAcumulado = 0;
            caminos_.put(v, e);
        } else { //Si ya tiene una etiqueta la buscamos
            etiquetaV = caminos_.get(v);
            pesoAcumulado = etiquetaV.pesoAcumulado;
        }

        // Obtenemos la primera arista del vértice actual
        Grafo.Arista arista = v.arista;
        if (arista == null) {
            System.out.println("El vértice no tiene aristas");
            return;
        }

        // Recorremos las aristas del vértice
        while (arista != null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Grafo.NodoGrafo incide = arista.incide;
            int nuevoPeso = pesoAcumulado + arista.peso;

            // Debuggear
            System.out.println("Comprobando incidencia en: " + incide);

            // Si el vértice ya fue visitado, pasamos a la siguiente arista
            if (visitados.contains(incide)) {
                System.out.println("El vértice: " + incide + " ya fue visitado");
                arista = arista.sigArista;
                continue;
            }

            // Creamos la nueva etiqueta del vértice incide
            Etiqueta nuevaEtiqueta = new Etiqueta();
            nuevaEtiqueta.anterior = v;
            nuevaEtiqueta.pesoAcumulado = nuevoPeso;

            // Si encontramos un camino menor o es la primera vez que llegamos
            if (!caminos_.containsKey(incide) || caminos_.get(incide).pesoAcumulado > nuevoPeso) {
                caminos_.put(incide, nuevaEtiqueta);

                // Verificamos si ya está en la cola
                if (!pesosEnCola.containsKey(incide) || pesosEnCola.get(incide) > nuevoPeso) {
                    pesosEnCola.put(incide, nuevoPeso); // Actualizamos el peso en la estructura auxiliar
                    cola.AcolarPrioridad(incide, v, nuevoPeso); // Añadimos o actualizamos en la cola
                }
            }

            arista = arista.sigArista;
        }

        dijkstraRecursivo(cola);
    }


}






