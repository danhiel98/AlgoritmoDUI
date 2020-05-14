/**
 * Clase que contiene los métodos para generar y validar números de DUI
 */
package validardui;

public class Dui {
    public static String generar() {
        String resultado = "";
        int suma = 0;
        int validador;
        
        for (int i = 0, x = 9; i < 8; i++, x--){
            int num = (int)Math.floor(Math.random()*(9-0+1)+0);
            resultado += String.valueOf(num);
            suma += num * x;
        }
        
        validador = suma % 10;
        
        resultado += validador == 0 ? 0 : 10 - validador;
        
        return resultado;
    }
    
    public static boolean validar(String numero){
        int suma = 0;
        int division = 0;
        int resultado;
        
        for (int i = 0, x = 9; x >= 2; i++, x--){
            suma += Character.getNumericValue(numero.charAt(i)) * x;
        }
        
        division = suma % 10;
        
        resultado = division == 0 ? 0 : 10 - division;
        
        if (resultado == 0 || resultado == Character.getNumericValue(numero.charAt(8))) return true;
        
        return false;
    }
}
