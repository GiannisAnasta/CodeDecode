package com.mycompany.decodeapp;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "historyHolder")
@ApplicationScoped
public class HistoryHolder {

    private final List<String> history = new ArrayList<>();

    public List<String> getHistory() {
        return history;
    }

    public void encode(String name, String msg, int key) {

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
        history.add(name + ": " + encoded);

    }

    private static int getRowscount(int msglen, int rowlen) {
        return (int) Math.ceil(msglen * (1d) / rowlen);

    }

}
