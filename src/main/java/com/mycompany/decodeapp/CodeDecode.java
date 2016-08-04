package com.mycompany.decodeapp;

public class CodeDecode {

    public static void main(String[] args) {
        String message = "speedflow viop company";
        int key = 4;
        System.out.println(decode("W_eetdfved.c_eoelo_rcrrrlnSeo_e", key));
        System.out.println("Message: " + message);

        String encoded = encode(message, key);
        System.out.println("Encoded : " + encoded);

        System.out.println("Decoded : " + decode(encoded, key));
    }

    private static String encode(String msg, int key) {
        msg = msg.replace(" ", "_");
        int columncount = key;
        int rowscount = getRowscount(msg.length(), key);
        char[][] matrix = new char[rowscount][columncount];
        for (int rowNum = 0; rowNum < rowscount; rowNum++) {
            for (int columnNum = 0; columnNum < columncount; columnNum++) {
                int charPosition = columncount * rowNum + columnNum;
                if (charPosition < msg.length()) {
                    matrix[rowNum][columnNum] = msg.charAt(charPosition);
                } else {
                    matrix[rowNum][columnNum] = '_';
                }
            }

        }

        String encoded = "";
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                encoded += matrix[j][i];
            }
        }
        return encoded.trim();

    }

    private static String decode(String encodedMess, int key) {
        String decoded = "";
        int columncount = key;
        int rowscount = getRowscount(encodedMess.length(), key);
        char[][] matrix = new char[rowscount][columncount];

        for (int columnNum = 0; columnNum < columncount; columnNum++) {
            for (int rowNum = 0; rowNum < rowscount; rowNum++) {
                int charPosition = rowscount * columnNum + rowNum;
                if (charPosition < encodedMess.length()) {
                    matrix[rowNum][columnNum] = encodedMess.charAt(charPosition);
                } else {
                    matrix[rowNum][columnNum] = ' ';
                }
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                decoded += matrix[i][j];
            }

        }
        return decoded.replace("_", " ").trim();
    }

    private static int getRowscount(int msglen, int rowlen) {
        return (int) Math.ceil(msglen * (1d) / rowlen);

    }

}
