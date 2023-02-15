package app.ui.console;

import app.controller.ClientTestsController;
import app.domain.model.*;
import app.ui.console.utils.Utils;
import java.util.*;

public class ClientTestsUI implements Runnable{

    /**
     * Controller of test
     */
    private final ClientTestsController ctrl;

    /**
     * list of tests
     */
    public ArrayList<Test> testList;
    /**
     * temporary list of tests
     */
    public ArrayList<Test> tempTestList;

    public ClientTestsUI(){
        this.ctrl = new ClientTestsController();
        this.testList = new ArrayList<>();
        this.tempTestList = new ArrayList<>();
    }

    @Override
    public void run() {

        System.out.println("\n Selecting a test to view: \n");

        this.testList = this.ctrl.getTestList();

        if (testList.size() == 0)
        {
            System.out.println("\nError: There are no tests created.");
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

        String userID = ctrl.getUserId();

        long ccNumber = ctrl.getInstanceOfCCNumberByEmail(userID);

        int option1 = 0;
        do
        {
            tempTestList = ctrl.getInstanceOfTest(ccNumber);
            Collections.sort(tempTestList);

            ArrayList<String> testDesignationList1 = ctrl.getInstanceOfTestDesignation(ccNumber);

            ArrayList<Date> testDateList = new ArrayList<>();
            Date testDate;

            for (String s : testDesignationList1)
            {
                testDate = ctrl.getInstanceOfTestDate(s);
                testDateList.add(testDate);
            }

            Collections.sort(testDateList);

            ArrayList<String> testDesignationList = new ArrayList<>();
            String testDesignation;

            for (Date d : testDateList)
            {
                testDesignation = ctrl.getInstanceOfTestDesignationByDate(d);
                testDesignationList.add(testDesignation);
            }

            for (int i = 0; i < testDesignationList.size(); i++)
            {
                System.out.println(testDesignationList.get(i) + ", " + testDateList.get(i));
            }

            String testSelected = Utils.readLineFromConsole("Select the Test you want to view the results of (testDesignation):");

            int cont = 0;
            for (String s : testDesignationList)
            {
                if (testSelected != null && testSelected.equals(s))
                {
                    cont++;
                }
            }

            while(cont == 0)
            {
                testSelected = Utils.readLineFromConsole("Select a valid Test that you want to view the results of (testDesignation):");
                for (String s : testDesignationList)
                {
                    if (testSelected != null && testSelected.equals(s))
                    {
                        cont++;
                    }
                }
            }

            System.out.println(ctrl.getInstanceOfTest2(testSelected));

            if (!Utils.confirm("Do you want to view more Tests? (Y/N)"))
                option1 = -1;
        }
        while (option1 != -1);
    }
}
