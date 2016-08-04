package com.mycompany.decodeapp;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "DhistoryHolder")
@SessionScoped
public class DHistoryHolder {

    private List<String> dhistory = new ArrayList<>();

    public List<String> getDhistory() {
        return dhistory;
    }

    public void decodeAll(List<String> codedmsgList, int dkey) {
        dhistory.clear();
        for (String codedMsgAndName : codedmsgList) {
            String[] splited = codedMsgAndName.split(": ");
            String name = splited[0];
            String codedMsg = splited[1];
            decode(name, codedMsg, dkey);

        }

    }

    private void decode(String name, String codedmsg, int dkey) {
        String decoded = "";
        int columncount = dkey;
        int rowscount = getRowscount(codedmsg.length(), dkey);
        char[][] matrix = new char[rowscount][columncount];

        for (int columnNum = 0; columnNum < columncount; columnNum++) {
            for (int rowNum = 0; rowNum < rowscount; rowNum++) {
                int charPosition = rowscount * columnNum + rowNum;
                if (charPosition < codedmsg.length()) {
                    matrix[rowNum][columnNum] = codedmsg.charAt(charPosition);
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
        decoded = decoded.replaceAll("_", " ");
        dhistory.add(name + ": " + decoded);

    }

    private static int getRowscount(int msglen, int rowlen) {
        return (int) Math.ceil(msglen * (1d) / rowlen);

    }

}
