import java.util.Scanner;

public class juego {
    public static void main(String[] args) {
        //menu(crearMapa());
        mostrarMapa(crearMapa());
    }

    //Scanner
    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    //Matriz
    public static String[][] crearMapa(){
        String[][] mapa = new String[10][10];
        mapa[0] = new String[]{"#","#","#","#","#","#","#","#","#","#",};
        mapa[1] = new String[]{"#","P",".","#","E",".","#",".",".","#",};
        mapa[2] = new String[]{"#",".",".","#",".",".","#","C",".","#",};
        mapa[3] = new String[]{"#",".",".",".",".",".",".","#",".","#",};
        mapa[4] = new String[]{"#",".","#","#",".",".",".",".",".","#",};
        mapa[5] = new String[]{"#",".",".",".",".","#",".",".",".","#",};
        mapa[6] = new String[]{"#","E","#",".",".","#",".",".",".","#",};
        mapa[7] = new String[]{"#",".","C","#",".","#",".","#","#","#",};
        mapa[8] = new String[]{"#",".",".","#",".",".",".",".","X","#",};
        mapa[9] = new String[]{"#","#","#","#","#","#","#","#","#","#",};
        return mapa;
    }

    //Mostrar mapa
    public static void mostrarMapa(String[][] mapa){
        for (int i = 0; i < 10; i++) {
            System.out.println(mapa[i][0]+"  "+mapa[i][1]+"  "+mapa[i][2]+"  "+mapa[i][3]+"  "+mapa[i][4]+"  "+mapa[i][5]+"  "+mapa[i][6]+"  "+mapa[i][7]+"  "+mapa[i][8]+"  "+mapa[i][9]);
        }
    }

    //Array de jugador
    public static int[] jugador(){
        int[] jugador = new int[4];
        jugador[0] = 1;
        jugador[1] = 1;
        jugador[2] = 100;
        jugador[3] = 15;
        return jugador;
    }
    //Array de enemigo
    //Menú combate
    //Cofres
    //Ver posición actual
    //Comprobar evento
    //Fin del juego
    //Gana o pierde.

    //Función imprimir opciones del menú.
    public static void mostrarOpciones(){
        System.out.println("\nMenú del inventario:");
        System.out.println("1) Moverse.");
        System.out.println("2) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }

    //Función de leer la opción del menú.
    public static int leerOpcion(){
        int opcion;
        while (true) {
            try {
                opcion = scanner().nextInt();
                if ((opcion >= 1) && (opcion <= 2)) {
                    break;
                } else {
                    System.out.print("Opción inválida. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return opcion;
    }

    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcion(Object[][] mapa, int opcion){
        if(opcion == 1){ //Moverse
        } else if(opcion == 2){ //Salir
            System.out.print("A continuación, confirme su salida. "); //se ejecutará el continuar en el menú.
        }
    }

    //Función booleana de continuar para el menú.
    public static boolean continuarMenu(int opcion){
        boolean continuar = true;
        if(opcion == 2){
            continuar = false;
            System.out.println("Cerrando menú... ¡Hasta luego! ^^");
        } else if(opcion != 1){
            System.out.println("Opción no válida.");
        }
        return continuar;
    }

    //Función menú.
    public static void menu(String[][] mapa){
        boolean continuar = true;
        while(continuar){
            mostrarOpciones();
            int opcion = leerOpcion();
            ejecutarOpcion(mapa, leerOpcion());
            System.out.print("(1 = Salir ; 2 = Continuar): ");
            int respuesta = scanner().nextInt();
            continuar = continuarMenu(respuesta);
        }
        scanner().close();
    }

}
