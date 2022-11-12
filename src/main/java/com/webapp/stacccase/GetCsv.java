package com.webapp.stacccase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetCsv {

    public void getCsv() {
        File file = new File("pep.csv");
        Scanner input = null;
        try {
            input = new Scanner(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
