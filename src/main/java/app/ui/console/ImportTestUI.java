package app.ui.console;

import app.controller.ImportTestController;
import app.ui.console.utils.Utils;
import java.io.*;
import java.text.ParseException;
import java.util.*;

public class ImportTestUI implements Runnable {

    private final ImportTestController ctrl;

    public ImportTestUI() throws ParseException {
        this.ctrl = new ImportTestController();
    }

    @Override
    public void run() {

        System.out.println("\n Importing Tests\n");

        String csvFilePath = Utils.readLineFromConsole("Enter CSV file name: ");

        createTestsFromCSV(csvFilePath);

        try {

                if (Utils.confirm("Do you confirm? (Y/N)")) {
                    System.out.println("Record save with success.");
                }

        }catch(Exception ex)
        {
            System.out.println("Ocorreu um erro: operação cancelada. \n" + ex.getMessage());
        }

    }

    public void createTestsFromCSV(String csvFilePath) {

        String line;
        String splitBy = ";";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] test = line.split(splitBy);

                i++;

                if (i==1) continue;

                long testCode = Long.parseLong(test[0]);

                String nhsCode = test[1];

                long ccNumber = Long.parseLong(test[3]);

                String testType = test[11];

                ArrayList<String> parameterCategoryList = new ArrayList<>();
                parameterCategoryList.add(test[12]);
                parameterCategoryList.add(test[17]);

                ArrayList<String> parameterList = new ArrayList<>();
                parameterList.add(test[13]);
                parameterList.add(test[14]);
                parameterList.add(test[15]);
                parameterList.add(test[16]);

                ctrl.createTest(testCode, nhsCode, "designation", ccNumber, testType, parameterCategoryList, parameterList, "Invalid");
            }
        } catch (IOException | ParseException ignored) {
        }
    }
}