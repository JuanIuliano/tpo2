import grafo.Dijkstra;
import grafo.Grafo;

import java.util.HashMap;

public class Auxiliar {
    int[][] matriz = new int[8][8];


    public int[][] generarMatriz(int centroDist1, HashMap<Grafo.NodoGrafo, Dijkstra.Etiqueta> costos1,
                                 int centroDist2, HashMap<Grafo.NodoGrafo, Dijkstra.Etiqueta> costos2) {
        return null;
    }

    public void agregarVertices(Grafo g){
        //CENTROS DE DISTRIBUCIÓN
        g.agregarCentro(50, 3, 2300, 175, 450);
        g.agregarCentro(51, 3, 1900, 300, 620);
        g.agregarCentro(52, 3, 1500, 330, 280);
        g.agregarCentro(53, 2, 2000, 450, 450);
        g.agregarCentro(54, 2, 2700, 650, 280);
        g.agregarCentro(55, 2, 2500, 750, 610);
        g.agregarCentro(56, 1, 3000, 765, 450);
        g.agregarCentro(57, 1, 500, 1100, 450);
        //CLIENTES
        g.agregarCliente(0, 10, 960, 375);
        g.agregarCliente(1, 10, 60, 450);
        g.agregarCliente(2, 10, 70, 550);
        g.agregarCliente(3, 10, 160, 515);
        g.agregarCliente(4, 10, 250, 520);
        g.agregarCliente(5, 10, 210, 610);
        g.agregarCliente(6, 10, 195, 685);
        g.agregarCliente(7, 10, 250, 720);
        g.agregarCliente(8, 10, 300, 686);
        g.agregarCliente(9, 10, 386, 700);
        g.agregarCliente(10, 10, 365, 635);
        g.agregarCliente(11, 10, 420, 600);
        g.agregarCliente(12, 10, 445, 540);
        g.agregarCliente(13, 10, 520, 500);
        g.agregarCliente(14, 10, 485, 590);
        g.agregarCliente(15, 10, 530, 630);
        g.agregarCliente(16, 10, 500, 700);
        g.agregarCliente(17, 10, 640, 730);
        g.agregarCliente(18, 10, 700, 660);
        g.agregarCliente(19, 10, 780, 720);
        g.agregarCliente(20, 10, 635, 570);
        g.agregarCliente(21, 10, 705, 510);
        g.agregarCliente(22, 10, 820, 510);
        g.agregarCliente(23, 10, 820, 610);
        g.agregarCliente(24, 10, 900, 590);
        g.agregarCliente(25, 10, 920, 690);
        g.agregarCliente(26, 10, 1000, 570);
        g.agregarCliente(27, 10, 940, 510);
        g.agregarCliente(28, 10, 110, 365);
        g.agregarCliente(29, 10, 185, 355);
        g.agregarCliente(30, 10, 300, 405);
        g.agregarCliente(31, 10, 220, 300);
        g.agregarCliente(32, 10, 170, 220);
        g.agregarCliente(33, 10, 270, 210);
        g.agregarCliente(34, 10, 410, 230);
        g.agregarCliente(35, 10, 390, 150);
        g.agregarCliente(36, 10, 345, 65);
        g.agregarCliente(37, 10, 450, 45);
        g.agregarCliente(38, 10, 520, 150);
        g.agregarCliente(39, 10, 540, 220);
        g.agregarCliente(40, 10, 535, 305);
        g.agregarCliente(41, 10, 525, 375);
        g.agregarCliente(42, 10, 660, 45);
        g.agregarCliente(43, 10, 640, 155);
        g.agregarCliente(44, 10, 776, 155);
        g.agregarCliente(45, 10, 755, 225);
        g.agregarCliente(46, 10, 890, 240);
        g.agregarCliente(47, 10, 750, 320);
        g.agregarCliente(48, 10, 830, 350);
        g.agregarCliente(49, 10, 740, 375);
    }

    public void agregarAristas(Grafo g){
        int[][] rutas = {
                {1, 2, 10}, {2, 1, 10}, {2, 3, 10}, {3, 2, 10}, {1, 28, 8}, {28, 1, 8}, {28, 50, 11},
                {50, 28, 11}, {1, 3, 12}, {3, 1, 12}, {3, 50, 10}, {50, 3, 10}, {3, 4, 8}, {4, 3, 8},
                {51, 4, 9}, {4, 51, 9}, {3, 5, 4}, {5, 3, 4}, {5, 51, 3}, {51, 5, 3}, {6, 5, 9}, {5, 6, 9},
                {6, 7, 8}, {7, 6, 8}, {7, 8, 4}, {8, 7, 4}, {8, 51, 10}, {51, 8, 10}, {8, 10, 12}, {10, 8, 12},
                {9, 10, 9}, {10, 9, 9}, {10, 11, 6}, {11, 10, 6}, {11, 12, 5}, {12, 11, 5}, {12, 13, 6},
                {13, 12, 6}, {11, 14, 8}, {14, 11, 8}, {14, 15, 8}, {15, 14, 8}, {15, 16, 9}, {16, 15, 9},
                {15, 20, 6}, {20, 15, 6}, {13, 20, 4}, {20, 13, 4}, {20, 18, 2}, {18, 20, 2}, {17, 18, 6},
                {18, 17, 6}, {18, 19, 7}, {19, 18, 7}, {19, 23, 6}, {23, 19, 6}, {18, 55, 9}, {55, 18, 9},
                {20, 55, 7}, {55, 20, 7}, {20, 21, 6}, {21, 20, 6}, {21, 56, 9}, {56, 21, 9}, {22, 56, 7},
                {56, 22, 7}, {22, 23, 5}, {23, 22, 5}, {23, 55, 4}, {55, 23, 4}, {23, 24, 4}, {24, 23, 4},
                {24, 25, 5}, {25, 24, 5}, {24, 26, 6}, {26, 24, 6}, {24, 27, 7}, {27, 24, 7}, {27, 57, 7},
                {57, 27, 7}, {26, 57, 6}, {57, 26, 6}, {29, 31, 5}, {31, 29, 5}, {31, 32, 7}, {32, 31, 7},
                {31, 53, 4}, {53, 31, 4}, {50, 30, 5}, {30, 50, 5}, {30, 53, 7}, {53, 30, 7}, {32, 33, 8},
                {33, 32, 8}, {33, 52, 4}, {52, 33, 4}, {31, 52, 8}, {52, 31, 8}, {52, 34, 8}, {34, 52, 8},
                {34, 35, 6}, {35, 34, 6}, {35, 36, 7}, {36, 35, 7}, {34, 39, 4}, {39, 34, 4}, {39, 38, 3},
                {38, 39, 3}, {38, 37, 9}, {37, 38, 9}, {39, 40, 8}, {40, 39, 8}, {40, 41, 7}, {41, 40, 7},
                {52, 41, 6}, {41, 52, 6}, {41, 53, 9}, {53, 41, 9}, {41, 13, 7}, {13, 41, 7}, {39, 43, 5},
                {43, 39, 5}, {39, 54, 4}, {54, 39, 4}, {40, 54, 5}, {54, 40, 5}, {41, 49, 6}, {49, 41, 6},
                {43, 42, 5}, {42, 43, 5}, {43, 54, 4}, {54, 43, 4}, {43, 44, 9}, {44, 43, 9}, {44, 45, 7},
                {45, 44, 7}, {45, 54, 6}, {54, 45, 6}, {45, 46, 9}, {46, 45, 9}, {45, 47, 7}, {47, 45, 7},
                {47, 48, 8}, {48, 47, 8}, {48, 49, 9}, {49, 48, 9}, {49, 56, 3}, {56, 49, 3}, {48, 0, 6},
                {0, 48, 6}, {0, 56, 6}, {56, 0, 6}, {0, 57, 4}, {57, 0, 4}, {29, 50, 3}, {50, 29, 3}, /*{50, 53, 0},
                {51, 53, 0}, {53, 52, 0}, {56, 54, 0}, {56, 55, 0}, {57, 56, 0}, {53, 56, 0}*/
        };

        for (int[] ruta : rutas) {
            int v1 = ruta[0];
            int v2 = ruta[1];
            int peso = ruta[2];
            try {
                g.agregarArista(v1, v2, peso);
            }
            catch (Exception e) {
                System.out.println(v1);
                System.out.println(v2);
                System.out.println(e.getMessage());
            }
        }
    }
}
// 1