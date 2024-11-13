package grafo;
import java.util.HashMap;


public class Grafo {

    private Grafico grafico;

    //La clase grafo está compuesta de nodos y aristas
    public class NodoGrafo {
        int vertice;
        Arista arista;
    }

    public class NodoCliente extends NodoGrafo {
        int produccion;
    }

    public class NodoCentroDistribucion extends NodoGrafo{
        int costoAlPuerto;
        int costoAnual;
    }

    public void agregarCentro(int v, int costoPuerto, int costoAnual, int posx, int posy) {
        NodoCentroDistribucion n = new NodoCentroDistribucion();
        n.vertice = v;
        n.costoAlPuerto = costoPuerto;
        n.costoAnual = costoAnual;
        n.arista = null;

        if(!(existeVertice(v))){
            vertices.put(v, n);
            grafico.setPos(v, posx, posy);
        }
    }

    public class Arista {
        int valor;
        int peso;
        NodoGrafo incide;
        Arista sigArista;
    }

    private NodoGrafo primero;
    public HashMap<Integer, NodoGrafo> vertices = new HashMap<Integer, NodoGrafo>();

    public void inicializarGrafo(Grafico graf) {
        if (this.grafoVacio()) {
            this.primero = null;
            this.grafico = graf;
        }
        else {
            System.out.println("El grafo ya está inicializado.");
        }
    }

    public boolean grafoVacio(){
        return (this.primero == null);
    }


    public boolean existeVertice(int v){
        return this.vertices.containsKey(v);
    }


    public void agregarCliente(int valor, int produccion, int posx, int posy) {
        if (this.existeVertice(valor)) {
            System.out.println("El vertice"+valor+ " ya existe");
            return;
        }

        NodoCliente nuevo = new NodoCliente();
        nuevo.vertice = valor;
        nuevo.arista = null;
        nuevo.produccion = produccion;

        if (this.grafoVacio()) {
            this.primero = nuevo;
        }

        vertices.put(valor, nuevo);
        grafico.setPos(valor, posx, posy);

    }


    private boolean existeArista(int v1, int v2){
        if(!(existeVertice(v1) && existeVertice(v2)) || this.grafoVacio()){
            System.out.println("Los vertices no existen o el grafo está vacío.");
        }

        //Tenemos que comprobar si existe una arista que conecte el v1 con el v2
        NodoGrafo vert1 = vertices.get(v1); //v1
        NodoGrafo vert2 = vertices.get(v2); //v2

        //Obtenemos la primer arista de la lista de aristas del v1
        Arista arista = vert1.arista;
        if (arista == null){
            return false;
        }

        //Bucle principal para recorrer todas las aristas que salen de v1, hasta encontrar la que incide en v2
        while (arista != null){
            if(arista.incide == vert2) {
                return true;
            }
            arista = arista.sigArista;
        }

        return false;
    }


    public void agregarArista(int v1, int v2, int peso){
        if(!(existeVertice(v1) && existeVertice(v2)) || this.grafoVacio()){
            System.out.println("Los vertices no existen o el grafo está vacío.");
        }

        //Comprobamos que no existan aristas que conecten v1 y v2
        if(existeArista(v1, v2)){
            System.out.println("La arista ya existe");
            return;
        }

        //Si la arista no existe, la agregamos
        //Obtenemos el v1 y v2
        NodoGrafo vert1 = vertices.get(v1);
        NodoGrafo vert2 = vertices.get(v2);
        //Del v1, obtenemos la primera arista de referencia
        Arista aux = vert1.arista;

        //Si v1 no tiene aristas, la agregamos como primera
        Arista nuevo = new Arista();
        nuevo.peso = peso;
        nuevo.incide = vert2;
        nuevo.sigArista = null;

        if (aux == null) {
            vert1.arista = nuevo;
            return;
        }

        //Si v1 ya tiene aristas, recorremos toda la lista enlazada y la agregamos al final
        while (aux.sigArista != null){
            aux = aux.sigArista;
        }
        aux.sigArista = nuevo;
    }


    public NodoGrafo devolverVertice(int v){

        if(!existeVertice(v)){
            return null;
        }

        return vertices.get(v);
    }


    public void mostrarGrafo(){
        for (Integer key : vertices.keySet()) {
            NodoGrafo vertice = vertices.get(key);
            System.out.println("El vertice: "+vertice.vertice+" Tiene las siguientes aristas:");
            Arista aux = vertice.arista;
            while (aux != null){
                System.out.println(" Peso: "+aux.peso+" Incide en: "+aux.incide.vertice);
                aux = aux.sigArista;
            }
        }
    }

}
















