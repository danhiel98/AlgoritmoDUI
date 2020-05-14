/**
 * Algoritmos para generar y validar números de DUI
 */
package validardui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daniel García
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        do {
            Main.mostrarOpciones();
            opcion = sc.nextInt();
            switch (opcion){
                case 1: 
                    Main.validarDui();
                    break;
                case 2:
                    Main.generarDui();
                    break;
                case 3:
                    Main.generarValidarDui();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            System.out.println("\033[0m");
        } while (opcion != 4);
    }
    
    // Verifica que el número de DUI sea correcto
    public static void validarDui(){
        Matcher m;
        Pattern r;
        String regex = "^[0-9]{9}$";
        Scanner sc = new Scanner(System.in);
        String numeroDui;
        boolean valido;
        
        System.out.println("Introduzca su número de DUI (Sin guion):");
        numeroDui = sc.nextLine();
        
        r = Pattern.compile(regex);
        m = r.matcher(numeroDui);
        
        if (!m.find()){
            System.out.println("\033[0;31m" + "El formato no es correcto");
            return;
        }
        
        valido = Dui.validar(numeroDui);
        
        if (valido) 
            System.out.println("\033[0;32m" + "El número de DUI es válido");
        else 
            System.out.println("\033[0;31m" + "El número de DUI NO es válido");
    }
    
    public static void generarDui() {
        String dui = Dui.generar();
        
        System.out.println("\033[0;34m" + "El número de DUI generado es: " + dui);
    }
    
    // Siempre debería ser válido
    public static void generarValidarDui() {
        String numeroDUI = Dui.generar();
        boolean valido = Dui.validar(numeroDUI);
        
        System.out.println("Número de DUI: " + numeroDUI);
        if (valido) 
            System.out.println("\033[0;32m" + "El DUI es válido");
        else
            System.out.println("\033[0;31m" + "El DUI es inválido");
    }
    
    public static void mostrarOpciones() {
        System.out.println("--Seleccione una opción--");
        System.out.println("1. Validar número de DUI");
        System.out.println("2. Generar número de DUI");
        System.out.println("3. Generar y validar número de DUI");
        System.out.println("4. Salir");
    }
}
