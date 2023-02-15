package app.ui.console;

import app.controller.CreateRepDiagController;
import app.domain.model.*;
import app.ui.console.utils.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateRepDiagUI implements Runnable {

    private CreateRepDiagController ctrl;

    public CreateRepDiagUI() {
    }

    @Override
    public String toString() {
        return "CreateRepDiagUI{" +
                "ctrl=" + ctrl +
                '}';
    }

    @Override
    public void run() {
        ctrl = new CreateRepDiagController();
        System.out.println("\n Diagnosing and writing a report: \n");
        System.out.println("Lista: ");
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> invalidTests = new ArrayList<>();
        // System.out.println(allTests.toString());
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Invalid")) {
                invalidTests.add(allTests.get(i));
            }
        }
        System.out.println(invalidTests);

        long testCode = Utils.readIntegerFromConsole("Select one of the tests by testCode");
        try {
            System.out.println(ctrl.getInstanceOfTestCode(testCode));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String report = Utils.readLineFromConsole("Write here the report (max. 400 words):");

        this.ctrl.createRepDiag(report, testCode);

        try {
            FileWriter ReportinFile = new FileWriter("Report"+testCode+".txt");
            if (report != null) {
                ReportinFile.write(report);
            }
            ReportinFile.close();

            System.out.println("Successfully saved the Report.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}