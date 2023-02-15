package app.ui.console;

import app.domain.model.*;
import app.controller.CreateTestController;
import app.ui.console.utils.Utils;

import java.util.*;

public class CreateTestUI implements Runnable{

    /**
     * Controller of test
     */
    private final CreateTestController ctrl;
    /**
     * Test type of the test
     */
    public String testType;
    /**
     * State of the test
     */
    public String state;

    int i;

    public ArrayList<TestType> testTypeList;
    public ArrayList<ParameterCategory> parameterCategoryList;
    public ArrayList<Parameter> parameterList;
    public ArrayList<String> tempParameterCategoryList;
    public ArrayList<String> tempParameterList;

    public CreateTestUI(){
        this.ctrl = new CreateTestController();
        this.testTypeList = new ArrayList<>();
        this.parameterCategoryList = new ArrayList<>();
        this.parameterList = new ArrayList<>();
        this.tempParameterCategoryList = new ArrayList<>();
        this.tempParameterList = new ArrayList<>();
    }

    @Override
    public void run() {

        System.out.println("\n Registering a new Test: \n");

        this.testTypeList = this.ctrl.getTestTypeList();

        if (testTypeList.size() == 0)
        {
            i = 0;
            System.out.println("\nError: There are no test types created.");
        }
        else
        {
            i = 1;
        }

        try {
            if (readData() && i == 1) {
                if (Utils.confirm("Do you confirm the Test? (Y/N)")) {
                    if (this.ctrl.saveTest()) {
                        System.out.println("Record save with success.");
                    } else {
                        System.out.println("An error occurred while attempting to save the record.");
                    }
                }
            } else {
                System.out.println("Provided information already exists.");
            }
        }catch(Exception ex)
        {
            System.out.println("Ocorreu um erro: operação cancelada. \n" + ex.getMessage());
        }
    }

    private boolean readData() throws Exception {
        long testCode = ctrl.getTestCode();

        String nhsCode = Utils.readLineFromConsole("Nhs Code (12 digits):");
        String testDesignation = Utils.readLineFromConsole("Designation (< 30 characters):");
        long ccNumber = Long.parseLong(Objects.requireNonNull(Utils.readLineFromConsole("Citizen Card Number (16 digits):")));

        System.out.println(ctrl.getTestTypeList());
        String testType = Utils.readLineFromConsole("Select the Type of Test (name):");

        int option1 = 0;
        do
        {
            System.out.println(ctrl.getParameterCategoryList());
            String categoryCode = Utils.readLineFromConsole("Select the Parameter Category (name):");
            this.tempParameterCategoryList.add(categoryCode);

            int option2 = 0;
            do
            {
                System.out.println(ctrl.getInstanceOfParameterCategory(categoryCode));

                String parameter = Utils.readLineFromConsole("Select the Parameter (name):");
                this.tempParameterList.add(parameter);
                if (!Utils.confirm("Do you want to select more Parameters? (Y/N)"))
                    option2 = -1;
        }
        while (option2 != -1);

            if (!Utils.confirm("Do you want to select more Parameter Categories? (Y/N)"))
                option1 = -1;
        }
        while (option1 != -1);

        String state = "Invalid";
        Date date = ctrl.getDate();

        System.out.println("Test: " + "\nTest code: " + testCode + "\nNHS Code: " + nhsCode + "\nTest designation: " + testDesignation +
                "\nClient card number: " + ccNumber + "\nTest Type: " + testType + "\nParameter Category list: " + tempParameterCategoryList +
                "\nParameter list: " + tempParameterList + "\nState: " + state + "\nDate: " + date + '\n');

        return this.ctrl.createTest(testCode, nhsCode, testDesignation, ccNumber, testType, tempParameterCategoryList, tempParameterList, state);
    }
}
