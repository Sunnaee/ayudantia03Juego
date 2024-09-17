import java.util.Scanner;

public class juego {
    public static void main(String[] args) {
        iniciar();
    }

    //Scanner
    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    //Matriz
    public static String[][] crearMapa(){
        String[][] mapa = new String[10][10];
        mapa[0] = new String[]{"#","#","#","#","#","#","#","#","#","#",};
        mapa[1] = new String[]{"#","P",".","#",".",".","#",".",".","#",};
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

    //Mostrar mapa.
    public static void mostrarMapa(String[][] mapa){
        for (int i = 0; i < 10; i++) {
            System.out.println(mapa[i][0]+"  "+mapa[i][1]+"  "+mapa[i][2]+"  "+mapa[i][3]+"  "+mapa[i][4]+"  "+mapa[i][5]+"  "+mapa[i][6]+"  "+mapa[i][7]+"  "+mapa[i][8]+"  "+mapa[i][9]);
        }
    }

    //Array de jugador.
    public static int[][] jugador(){
        int[][] jugador = new int[2][2];
        jugador[0] = new int[]{1,1};
        jugador[1] = new int[]{100,15};
        return jugador;
    }

    //Array de los enemigos.
    public static int[][] enemigo(){
        int[][] enemigo = new int[2][2];
        enemigo[0] = new int[]{6,1};
        enemigo[1] = new int[]{45,10};
        return enemigo;
    }

    //Función para obtener la posición actual del jugador.
    public static int posicionJugadorX(String[][] mapa){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mapa[i][j].equals("P")){
                    return j;
                }
            }
        }
        return 0;
    }

    public static int posicionJugadorY(String[][] mapa){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mapa[i][j].equals("P")){
                    return i;
                }
            }
        }
        return 0;
    }

    //Movimiento personaje.
    public static String pedirMovimiento(){
        String movimiento;
        while (true) {
            try {
                System.out.print("Siguiente movimiento (W = arriba; A = izquierda; S = abajo; D = derecha): ");
                movimiento = scanner().nextLine().replace(" ","").toLowerCase();
                if((movimiento.equals("w")) || (movimiento.equals("a")) || (movimiento.equals("s")) || (movimiento.equals("d"))){
                    break;
                } else {
                    System.out.print("Opción inválida. Inténtelo nuevamente (W = arriba; A = izquierda; S = abajo; D = derecha): ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida, debe ser una letra. Inténtelo nuevamente (W = arriba; A = izquierda; S = abajo; D = derecha): ");
            }
        }
        return movimiento;
    }

    public static void movimientoW(String[][] mapa, int[][] jugador){
        jugador[0][0] = posicionJugadorX(mapa);
        jugador[0][1] = posicionJugadorY(mapa)-1;
        mapa[posicionJugadorY(mapa)][posicionJugadorX(mapa)] = ".";
        mapa[jugador[0][1]][jugador[0][0]] = "P";
    }

    public static void movimientoA(String[][] mapa, int[][] jugador){
        jugador[0][0] = posicionJugadorX(mapa)-1;
        jugador[0][1] = posicionJugadorY(mapa);
        mapa[posicionJugadorY(mapa)][posicionJugadorX(mapa)] = ".";
        mapa[jugador[0][1]][jugador[0][0]] = "P";
    }

    public static void movimientoS(String[][] mapa, int[][] jugador){
        jugador[0][0] = posicionJugadorX(mapa);
        jugador[0][1] = posicionJugadorY(mapa)+1;
        mapa[posicionJugadorY(mapa)][posicionJugadorX(mapa)] = ".";
        mapa[jugador[0][1]][jugador[0][0]] = "P";
    }

    public static void movimientoD(String[][] mapa, int[][] jugador){
        jugador[0][0] = posicionJugadorX(mapa)+1;
        jugador[0][1] = posicionJugadorY(mapa);
        mapa[posicionJugadorY(mapa)][posicionJugadorX(mapa)] = ".";
        mapa[jugador[0][1]][jugador[0][0]] = "P";
    }

    public static void movimientoPersonaje(String[][] mapa, String input, int[][] jugador){
        if (input.equals("w")) {
            movimientoW(mapa,jugador);
        } else if (input.equals("a")) {
            movimientoA(mapa,jugador);
        } else if (input.equals("s")) {
            movimientoS(mapa,jugador);
        } else if (input.equals("d")) {
            movimientoD(mapa,jugador);
        }
    }

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
    public static void ejecutarOpcion(String[][] mapa, int opcion, int[][] jugador){
        if(opcion == 1){ //Moverse
            movimientoPersonaje(mapa,pedirMovimiento(),jugador);
        } else if(opcion == 2){ //Salir
            System.out.println("Cerrando menú... ¡Hasta luego! ^^");
        }
    }

    //Función menú.
    public static void menu(String[][] mapa, int[][] jugador){
        while(true){
            mostrarMapa(mapa);
            mostrarOpciones();
            int opcion = leerOpcion();
            ejecutarOpcion(mapa,opcion,jugador);
            if (opcion == 2){
                break;
            }
        }
        scanner().close();
    }

    public static void iniciar(){
        menu(crearMapa(),jugador());
    }

}
