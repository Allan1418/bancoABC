
package bancoabc;

import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * Clase principal que simula una sucursal bancaria del Banco ABC.
 */
public class BancoABC {
    

    //Variables Globales
    
    /**
     * -m
     * variable global que almacena la cantidad de cajas de la sucursal
     * se inicializa en 0
     */
    public static ListaCajeros cajeros;
    
    /**
     * variable global que almacena los cheques del sistema
     * se establece el tipo de la pila en objetos de tipo Cheque
     */
    public static Pila<Cheque> cheques = new Pila<>();
    
    /**
     * variable global que almacena las fichas regulares del sistema
     * se establece el tipo de la cola en objetos de tipo Ficha
     */
    public static Cola<Ficha> fichasRegulares = new Cola<>();
    
    /**
     * variable global que almacena las fichas preferenciales del sistema
     * se establece el tipo de la cola en objetos de tipo Ficha
     */
    public static Cola<Ficha> fichasPreferenciales = new Cola<>();

    //Metodo principal
    
    /**
     * arranque del sistema
     * se llama a la funcion menu para iniciar la ejecucion del sistema
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        //Pruebas
        
        
        
        
        
        
        
        //arranque del sistema
        //defCajas();
        
        //arranque con Simulacion montada
        //montarSimulacion();
        //menu();
        
    }
    
    public static void montarSimulacion() {
        BitacoraFichas prueba = new BitacoraFichas();
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(2023, Calendar.NOVEMBER, 1, 0, 0, 0);
        Ficha a = new Ficha("a", "1", true);
        a.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 2, 0, 0, 0);
        Ficha b = new Ficha("b", "2", true);
        b.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 3, 0, 0, 0);
        Ficha c = new Ficha("c", "3", true);
        c.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 4, 0, 0, 0);
        Ficha d = new Ficha("d", "4", true);
        d.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 5, 0, 0, 0);
        Ficha e = new Ficha("e", "1", false);
        e.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 6, 0, 0, 0);
        Ficha f = new Ficha("f", "2", false);
        f.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 7, 0, 0, 0);
        Ficha g = new Ficha("g", "3", false);
        g.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        calendar.set(2023, Calendar.NOVEMBER, 8, 0, 0, 0);
        Ficha h = new Ficha("h", "4", false);
        h.setAtencion(new Timestamp(calendar.getTimeInMillis()));
        
        prueba.insertar(b);
        prueba.insertar(h);
        prueba.insertar(a);
        
        prueba.insertar(d);
        prueba.insertar(g);
        prueba.insertar(f);
        prueba.insertar(e);
        prueba.insertar(c);
        prueba.imprimir();
        
        System.out.println("------");
        prueba.imprimirAlreves();
    }
    
    //Metodos de Menu
    /**
     * -m
     */
    public static void defCajas(){
        String precajas = Comun.regexConfirm("[3-5]", "indique la cantidad de cajas \nPara abrir la sucursal bancaria \n(3-5)", "Solo entre 3 a 5 cajas");
        if (precajas == null) {
            return;
        }

        cajeros = new ListaCajeros(Integer.parseInt(precajas));
        
        menu();
    }
    
    /**
     * -m
     * implementa el menu principal y le pregunta la cantidad de cajas al usuario.
     * 
     * se pregunta al usuario la cantidad de cajas validando que esten entre 3 y 5
     * y se guarda la eleccion del usuario en la variable global cantcajas
     * 
     * Muestra el menú principal de la aplicación y permite al usuario
     * seleccionar diferentes opciones.
     */
    public static void menu() {
        
        String[] botones = {"Gestionar Cheques Gerencia", "Listar Cajas Activas", "Gestionar Usuarios de Cajas", "Ayuda", "SALIR"};
        int opcion;
        OUTER:
        while (true) {
            opcion = JOptionPane.showOptionDialog(null,
                    "MENU PRINCIPAL",
                    "Menu temporal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botones, botones[4]);

            switch (opcion) {
                case 0:
                    opChequesGerencia();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "La sucursal actual del banco ABC tiene " + cajeros + " cajas activas");
                    break;
                case 2:
                    opUsuariosCajas();
                    break;
                case 3:
                    opAyuda();
                    break;
                default:
                    break OUTER;
            }

        }
    }
    
    /**
     * Muestra un menú de opciones para la gestión de cheques por parte de la
     * gerencia del banco. Las opciones incluyen ingresar un nuevo cheque,
     * firmar un cheque y listar los cheques pendientes. Permite al usuario
     * seleccionar una de estas opciones o salir del menú.
     */
    public static void opChequesGerencia() {

        String[] botones = {"Ingresar un cheque", "Firmar un cheque", "Listar cheques pendientes", "SALIR"};
        int opcion;
        OUTER:
        while (true) {
            opcion = JOptionPane.showOptionDialog(null,
                    "MENU CHEQUES GERENCIA",
                    "Menu temporal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botones, botones[3]);

            switch (opcion) {
                case 0:
                    crearCheque();
                    break;
                case 1:
                    sacarCheque();
                    break;
                case 2:
                    imprCheques();
                    break;
                default:
                    break OUTER;
            }

        }

    }

    /**
     * Muestra el menú de gestión de usuarios de las cajas del banco. Las
     * opciones incluyen seleccionar una ficha, llamar a un usuario a las cajas
     * y mostrar las fichas pendientes.
     */
    public static void opUsuariosCajas() {

        String[] botones = {"Seleccionar ficha", "Llamar Usuario a cajas", "Mostrar Fichas Pendientes", "SALIR"};
        int opcion;
        OUTER:
        while (true) {
            opcion = JOptionPane.showOptionDialog(null,
                    "MENU CHEQUES GERENCIA",
                    "Menu temporal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botones, botones[3]);

            switch (opcion) {
                case 0:
                    crearFicha();
                    break;
                case 1:
                    prepararFicha();
                    break;
                case 2:
                    imprFichas();
                    break;
                default:
                    break OUTER;
            }

        }

    }

    /**
     * Muestra una ventana de ayuda con la información de los integrantes de la
     * solución del sistema del Banco ABC.
     */
    public static void opAyuda() {
        String m = "Banco ABC \n\nIntegrantes de la solucion: \n-Allan Nuñez Brenes  \n-Anyelo Vargas Merlo  \n-Maria Celeste Cerdas Hernandez";
        JOptionPane.showMessageDialog(null, m);
    }
    
    

    //Metodos de opcion
    
    /**
     * Crea un nuevo cheque y lo agrega a la pila de cheques.
     * pregunta al usuario el titular del cheque y el monto.
     */
    public static void crearCheque() {
        String preNombre, preMonto;

        preNombre = Comun.regexConfirm(".+", "Ingrese el Titular del cheque", "Ingrese un titular");
        if (preNombre == null) {
            return;
        }

        preMonto = Comun.regexConfirm("\\d+([.]\\d+)?", "Ingrese el Monto del Cheque", "Numero Invalido!");
        if (preMonto == null) {
            return;
        }

        Cheque preCheque = new Cheque(preNombre, Double.parseDouble(preMonto));
        cheques.push(preCheque);

    }

    /**
     * Saca un cheque de la pila de cheques y muestra la información del mismo
     * en una ventana.
     */
    public static void sacarCheque() {

        if (cheques.isVacia()) {
            JOptionPane.showMessageDialog(null, "La pila de cheques esta vacia!");
            return;
        }

        String[] boton = {"Firmar"};
        JOptionPane.showOptionDialog(null,
                cheques.pop().toString(),
                "Menu temporal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                boton, boton[0]);
    }

    /**
     * Imprime en consola la lista de cheques pendientes en la pila de cheques. Muestra una
     * cabecera con el título "Cheques Pendientes," seguido de la lista de
     * cheques y una línea divisoria.
     */
    public static void imprCheques() {
        System.out.println("\n---Cheques Pendientes---");
        cheques.impPila();
        System.out.println("------------------------");
    }

    /**
     * Crea una nueva ficha de cliente y la agrega a la cola correspondiente
     * (preferencial o regular).
     * Se le pregunta al usuario el tipo de ficha, nombre y cedula.
     */
    public static void crearFicha() {

        boolean tipoCliente;
        String preCedula, preNombre;

        String[] botones = {"Preferencial", "Regular", "SALIR"};
        int opcion = JOptionPane.showOptionDialog(null,
                "Seleccione el tipo de Ficha",
                "Menu temporal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                botones, botones[2]);

        switch (opcion) {
            case 0:
                tipoCliente = true;
                break;
            case 1:
                tipoCliente = false;
                break;
            default:
                return;
        }

        preNombre = Comun.regexConfirm(".+", "Ingrese su Nombre", null);
        if (preNombre == null) {
            return;
        }

        preCedula = Comun.regexConfirm("\\d{9}", "Ingrese su Cedula", "Formato de cedula invalido!");
        if (preCedula == null) {
            return;
        }

        Ficha preFicha = new Ficha(preNombre, preCedula, tipoCliente);
        if (preFicha.isPreferencial()) {
            fichasPreferenciales.ingresarACola(preFicha);
        } else {
            fichasRegulares.ingresarACola(preFicha);
        }

    }

    /**
     * -m
     * Prepara y llama a un usuario de las cajas, dependiendo de la
     * disponibilidad y el tipo de ficha.
     * se pregunta al usuario el numero de caja que atiende validando que exista la caja.
     * dependiendo del tipo de caja y la cantidad de fichas pendientes se atiende
     * una ficha regular o preferncial
     */
    public static void prepararFicha() {

        if (fichasRegulares.isVacia() && fichasPreferenciales.isVacia()) {
            JOptionPane.showMessageDialog(null, "No hay fichas Pendientes!");
            return;
        }

        String regex = "[1-" + String.valueOf(cajeros.getSize()) + "]";
        String preCaja = Comun.regexConfirm(regex, "Ingrese el numero de caja que atiende", "No existe caja!");
        if (preCaja == null) {
            return;
        }

        int cajaActual = Integer.parseInt(preCaja);

        //caja preferencial
        if (cajaActual == 1) {
            if (fichasPreferenciales.isVacia()) {
                atenderFicha(cajaActual, false);
                return;
            }
            atenderFicha(cajaActual, true);
            return;
        }

        //caja usuarios regulares
        if (cajaActual == 2) {
            if (fichasPreferenciales.getSize() > fichasRegulares.getSize()) {
                atenderFicha(cajaActual, true);
                return;
            }
            atenderFicha(cajaActual, false);
            return;
        }

        //cajas restantes
        if (fichasRegulares.isVacia()) {
            atenderFicha(cajaActual, true);
            return;
        }

        atenderFicha(cajaActual, false);

    }

    /**
     * -m
     * Atiende a un cliente saquandolo de la cola respectiva 
     * de acuerdo con la caja asignada y el tipo de ficha.
     *
     * @param numCaja Número de caja asignada al cliente
     * @param preferencial Indicador de si la ficha es preferencial (true) o no (false)
     */
    public static void atenderFicha(int numCaja, boolean preferencial) {

        String m;
        Ficha actual;

        if (preferencial) {
            actual = fichasPreferenciales.sacarDeCola();
        } else {
            actual = fichasRegulares.sacarDeCola();
        }

        //Ficha # <<número de ficha>> con cédula <<cédula de identidad>> pasar a caja <caja asignada>.
        m = "Ficha #" + actual.getNumero() + " con cédula " + actual.getCedula() + " pasar a caja " + numCaja;

        JOptionPane.showMessageDialog(null, m);
        
        cajeros.buscar(numCaja).setAtendiendo(actual);
    }

    /**
     * -m
     * Imprime en consola las fichas pendientes en las colas, tanto regulares como
     * preferenciales.
     */
    public static void imprFichas() {
        System.out.println("\n---Fichas Pendientes---");
        System.out.println("Fichas Regulares:");
        fichasRegulares.imprCola();
        System.out.println("\nFichas Preferenciales:");
        fichasPreferenciales.imprCola();
        System.out.println("\nFichas en Atencion:");
        cajeros.imprimirAtendiendo();
        System.out.println("\n-----------------------");
    }

    
    //OtrosMetodos
    
    
    
}
