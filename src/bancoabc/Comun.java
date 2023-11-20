
package bancoabc;

import javax.swing.JOptionPane;

/**
 * 
 * @author 
 */

public class Comun {

    /**
     * Solicita al usuario una cadena que coincida con la expresión regular
     * dada.
     *
     * @param regex La expresión regular que debe coincidir.
     * @param ask El mensaje que se mostrará al usuario.
     * @param err El mensaje de error que se mostrará si el usuario ingresa una
     * cadena que no coincide con la expresión regular, o nulo si no se debe
     * mostrar ningún mensaje de error.
     * @return La cadena ingresada por el usuario, o nula si el usuario cancela
     * la operación.
     */
    public static String regexConfirm(String regex, String ask, String err) {

        String confirm;
        while (true) {
            confirm = JOptionPane.showInputDialog(ask);
            if (confirm == null) {
                return confirm;
            }
            if (confirm.matches(regex)) {
                return confirm;
            } else if (err != null) {
                JOptionPane.showMessageDialog(null, err, "Banco ABC", 0);
            }
        }
    }

    /**
     * Muestra una ventana de diálogo con botones y devuelve el índice del botón
     * seleccionado.
     *
     * Este método está diseñado para mostrar una ventana de diálogo con botones
     * proporcionados en el array "opciones". El usuario puede seleccionar uno
     * de los botones y se devuelve el índice correspondiente. Si se selecciona
     * el botón "Volver" (si está presente en el array), se devuelve -1.
     *
     * @param opciones Un array de cadenas que representa las opciones de los
     * botones en la ventana de diálogo.
     * @param ask La pregunta o mensaje que se muestra en la ventana de diálogo.
     * @return El índice del botón seleccionado o -1 si se selecciona el botón
     * "Volver".
     * @throws IllegalArgumentException Si el array de opciones es nulo o vacío.
     */
    public static int mostrarBotones(String[] opciones, String ask) {

        //revisar
        if (opciones == null || opciones.length == 0) {
            throw new IllegalArgumentException("El array de opciones no puede ser nulo o vacío.");
        }

        int opt = JOptionPane.showOptionDialog(
                null,
                ask,
                "Banco ABC",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[opciones.length - 1]);

        if (opt == opciones.length - 1 && opciones[opciones.length - 1] == "Volver") {
            return -1;
        }

        return opt;
    }

}
