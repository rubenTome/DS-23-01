package e2;


public class Code {

    public static boolean isKeypadValid(char[][] keypad) {
        char ch = '1';
        boolean valid = true;
        if (keypad != null) {
            for (char[] chars : keypad) {
                if (chars != null) {
                    for (char aChar : chars) {
                        if (aChar == ch) ch++;
                        else {
                            ch = '0';
                            if (aChar == ch) ch = 'A';
                            else valid = false;
                        }
                    }
                } else return false;
            }

            if(!valid){
                ch = '1';
                for(int j = 0; j < keypad[0].length; j++){
                    for (char[] chars : keypad) {
                        if (chars[j] == ch) ch++;
                        else {
                            ch = '0';
                            if (chars[j] == ch) ch = 'A';
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
            for (String movement : movements) {
                if (movement != null) {
                    for (int j = 0; j < movement.length(); j++) {
                        if (movement.charAt(j) != 'U' && movement.charAt(j) != 'D' && movement.charAt(j) != 'R'
                                && movement.charAt(j) != 'L') {
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
            for (String movement : movements) {
                for (int j = 0; j < movement.length(); j++) {
                    if (movement.charAt(j) == 'U' && (f > 0)) {
                        f--;
                    }
                    if (movement.charAt(j) == 'D' && (f < keypad.length - 1)) {
                        f++;
                    }
                    if (movement.charAt(j) == 'L' && (c > 0)) {
                        c--;
                    }
                    if (movement.charAt(j) == 'R' && (c < keypad[0].length - 1)) {
                        c++;
                    }
                }
                code.append(keypad[f][c]);
            }
        }

        return code.toString();
    }

}
