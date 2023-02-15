package app.ui.console;

import app.controller.ConsultHistoricalTestsController;
import app.domain.model.*;
import app.ui.console.utils.Utils;

import java.util.*;

public class ConsultHistoricalTestsUI implements Runnable{

    /**
     * Controller of test
     */
    private final ConsultHistoricalTestsController ctrl;
    /**
     * list of tests
     */
    public ArrayList<Test> testList;
    /**
     * temporary list of tests
     */
    public ArrayList<Test> tempTestList;
    /**
     * list of clients
     */
    public ArrayList<Client> clientList;

    public ConsultHistoricalTestsUI(){
        this.ctrl = new ConsultHistoricalTestsController();
        this.testList = new ArrayList<>();
        this.tempTestList = new ArrayList<>();
        this.clientList = new ArrayList<>();
    }

    @Override
    public void run() {

        System.out.println("\n Selecting a Client: \n");

        this.clientList = this.ctrl.getClientList();
        this.testList = this.ctrl.getTestList();

        if (testList.size() == 0 || clientList.size() == 0)
        {
            System.out.println("\nError: There are no tests/clients created.");
        }

        try
        {
            viewData();
        }
        catch(Exception ex)
        {
            System.out.println("Ocorreu um erro: operação cancelada. \n" + ex.getMessage());
        }
    }

    private void viewData() {
        int option2 = 0;
        String optionSelected = "4";
        do
        {
            if (optionSelected != null && optionSelected.equals("4")) {
                clientList = ctrl.getClientList();
                System.out.println("" + clientList);
            }

            optionSelected = Utils.readLineFromConsole("1 - Order by Name \n 2 - Order by TIN \n 3 - Select a client \n Select an option: ");

            if (optionSelected != null)
            {
                switch (optionSelected)
                {
                    case "1":
                        clientList = ctrl.bubleSortName(clientList);
                        System.out.println(clientList);
                        break;
                    case "2":
                        clientList = ctrl.insertionSortName(clientList);
                        System.out.println(clientList);
                        break;
                    case "3":
                        clientList = ctrl.getClientList();
                        System.out.println(clientList);

                        String clientSelected = Utils.readLineFromConsole("Select the Client you want to view the tests results of (Name):");

                        String clientName;
                        clientName = ctrl.getInstanceOfClientName(clientSelected);

                        int cont = 0;
                        if (clientSelected != null && clientSelected.equals(clientName)) {
                            cont = 1;
                        }

                        while (cont == 0) {
                            clientSelected = Utils.readLineFromConsole("Select a valid Client that you want to view the tests results of (Name):");
                            clientName = ctrl.getInstanceOfClientName(clientSelected);
                            if (clientSelected != null && clientSelected.equals(clientName)) {
                                cont = 1;
                            }
                        }

                        long ccNumber = ctrl.getInstanceOfTestccNumber(clientSelected);
                        int option1 = 0;
                        do {
                            tempTestList = ctrl.getInstanceOfTest(ccNumber);

                            Collections.sort(tempTestList);

                            ArrayList<String> testDesignationList1 = ctrl.getInstanceOfTestDesignation(ccNumber);

                            ArrayList<Date> testDateList = new ArrayList<>();
                            Date testDate;

                            for (String s : testDesignationList1) {
                                testDate = ctrl.getInstanceOfTestDate(s);
                                testDateList.add(testDate);
                            }

                            Collections.sort(testDateList);

                            ArrayList<String> testDesignationList = new ArrayList<>();
                            String testDesignation;

                            for (Date d : testDateList) {
                                testDesignation = ctrl.getInstanceOfTestDesignationByDate(d);
                                testDesignationList.add(testDesignation);
                            }

                            for (int i = 0; i < testDesignationList.size(); i++) {
                                System.out.println(testDesignationList.get(i) + ", " + testDateList.get(i));
                            }

                            String testSelected = Utils.readLineFromConsole("Select the Test you want to view the results of (testDesignation):");

                            cont = 0;
                            for (String s : testDesignationList) {
                                if (testSelected != null && testSelected.equals(s)) {
                                    cont++;
                                }
                            }

                            while (cont == 0) {
                                testSelected = Utils.readLineFromConsole("Select a valid Test that you want to view the results of (testDesignation):");
                                for (String s : testDesignationList) {
                                    if (testSelected != null && testSelected.equals(s)) {
                                        cont++;
                                    }
                                }
                            }

                            System.out.println(ctrl.getInstanceOfTest2(testSelected));

                            if (!Utils.confirm("Do you want to view more Tests? (Y/N)"))
                                option1 = -1;
                        }
                        while (option1 != -1);

                        if (!Utils.confirm("Do you want to select more clients? (Y/N)"))
                        {
                            option2 = -1;
                        }
                        else
                        {
                            optionSelected = "4";
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + optionSelected);
                }
            }
        }
        while (option2 != -1);
    }
}
