package e1;

import java.util.Random;
public class StringUtilities {
    public static boolean isValidMix(String a, String b, String c) {//charat
        if (a.length() + b.length() != c.length()) return false;
        else {
            int j = 0;
            int k = 0;
            for (int i = 0; i < c.length(); ++i) {
                if (j != a.length() && a.charAt(j) == c.charAt(i)) ++j;
                if (k != b.length() && b.charAt(k) == c.charAt(i)) ++k;
            }
            return (j == a.length() && k == b.length());
        }
    }

    //coverage no es útil porque el nivel de cobertura varía según que número creemos
    public static String generateRandomValidMix(String a, String b) {

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        StringBuilder salida = new StringBuilder();
        Random aleat = new Random();
        int contA = 0;
        int contB = 0;

        for (int i = 0; i < a.length() + b.length(); i++) {
            if (aleat.nextInt(2) == 0 && contA < a.length() || contB == b.length()) {
                salida.append(arrayA[contA]);
                ++contA;
            }
            else  if (contB < b.length()){
                salida.append(arrayB[contB]);
                ++contB;
            }

        }
        return salida.toString();
    }
}

