package app.ui.console;

import app.controller.CreateParameterController;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CreateParameterUI implements Runnable{

    private final CreateParameterController ctrl;

    public CreateParameterUI(){
        this.ctrl = new CreateParameterController();
    }

    @Override
    public void run() {
        System.out.println("\n Creating a new parameter: \n");
        try {
            if (readData())
            {
                if (Utils.confirm("Do you confirm the new parameter (Y/N)")) {
                    if (this.ctrl.saveParameter()) {
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
        long parameterCode = Utils.readIntegerFromConsole("Code:");
        String shortName = Utils.readLineFromConsole("Short Name:");
        String description = Utils.readLineFromConsole("Description:");

        List<ParameterCategoryItem> options = new ArrayList<>();
        for (ParameterCategory pc:
             ctrl.getParameterCategoryList()) {
            options.add(new ParameterCategoryItem(pc.getName()));
        }

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSelect the parameter category(s):");
            System.out.println("Option: " + option);
        }
        while (option != -1);

        String categoryName = "";

        return this.ctrl.createParameter(parameterCode, shortName, description, categoryName);
    }
}
