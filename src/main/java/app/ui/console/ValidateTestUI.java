package app.ui.console;

import app.controller.ValidateTestController;
import app.domain.model.Test;
import app.ui.console.utils.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ValidateTestUI implements Runnable{

    private final ValidateTestController ctrl;

    public ValidateTestUI() throws ParseException {
        this.ctrl = new ValidateTestController();
    }

    @Override
    public void run() {
        System.out.println("\n Validating tests: \n");
        try {
            if (readData())
            {
                if (Utils.confirm("Do you confirm the validation (Y/N)")) {
                    if (this.ctrl.saveValidation()) {
                        System.out.println("Record save with success.");
                    } else {
                        System.out.println("An error occurred while attempting to save the record.");
                    }
                }
            }
            else
            {
                System.out.println("Provided information already exists.");
            }
        }catch(Exception ex)
        {
            System.out.println("Ocorreu um erro: operação cancelada. \n" + ex.getMessage());
        }
    }

    private boolean readData() {

        List<TestItem> options = new ArrayList<>();
        for (Test test:
                ctrl.getTestList()) {
            if (!test.getState().equals("Valid")) options.add(new TestItem("Code: "+test.getTestCode()+" Date: "+test.getDate(),test));
        }

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSelect the test to validate:");
            System.out.println("Option: " + option);
            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).getTest().setState("Valid");
                options.remove(option);
            }
        }
        while (option != -1);

        return ctrl.saveValidation();
    }

}
