package e2;


public class Code {

    public static boolean isKeypadValid(char[][] keypad) {
        char ch = '1';
        boolean valid = true;
        if (keypad != null) {
            for (int i = 0; i < keypad.length; i++) {
                if (keypad[i] != null) {
                    for (int j = 0; j < keypad[i].length; j++) {
                        if(keypad[i][j] == ch) ch++;
                        else{
                            ch = '0';
                            if(keypad[i][j] == ch) ch = 'A';
                            else valid = false;
                        }
                    }
                } else return false;
            }

            if(!valid){
                ch = '1';
                for(int j = 0; j < keypad[0].length; j++){
                    for(int i = 0; i < keypad.length; i++){
                        if(keypad[i][j] == ch) ch++;
                        else{
                            ch = '0';
                            if(keypad[i][j] == ch) ch = 'A';
                            else return false;
                        }
                    }
                }
            }
        } else return false;

        return true;
    }

    public static boolean areMovementsValid(String[] movements) {
        boolean valid = true;
        if (movements != null) {
            for (int i = 0; i < movements.length; i++) {
                if (movements[i] != null) {
                    for (int j = 0; j < movements[i].length(); j++) {
                        if (movements[i].charAt(j) != 'U' && movements[i].charAt(j) != 'D' && movements[i].charAt(j) != 'R'
                                && movements[i].charAt(j) != 'L') {
                            valid = false;
                        }
                    }
                } else valid = false;
            }
        } else valid = false;

        return valid;
    }

    public static String obtainCode(char[][] keypad, String[] movements) {

        StringBuilder code = new StringBuilder();
        int f = 0;
        int c = 0;

        if (isKeypadValid(keypad) && areMovementsValid(movements)) {
            for (int i = 0; i < movements.length; i++) {
                for (int j = 0; j < movements[i].length(); j++) {
                    if (movements[i].charAt(j) == 'U' && (f > 0)) {
                        f--;
                    }
                    if (movements[i].charAt(j) == 'D' && (f < keypad.length - 1)) {
                        f++;
                    }
                    if (movements[i].charAt(j) == 'L' && (c > 0)) {
                        c--;
                    }
                    if (movements[i].charAt(j) == 'R' && (c < keypad[0].length - 1)) {
                        c++;
                    }
                }
                code.append(keypad[f][c]);
            }
        }

        return code.toString();
    }

}
