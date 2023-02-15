package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.ui.console.utils.Utils;

public class CreateParameterCategoryUI implements Runnable{

    private final CreateParameterCategoryController ctrl;

    public CreateParameterCategoryUI(){
        this.ctrl = new CreateParameterCategoryController();
    }


    @Override
    public void run() {

        System.out.println("\n Creating a new parameter category: \n");
        try {
            if (readData())
            {
                if (Utils.confirm("Do you confirm the new parameter category (Y/N)")) {
                    if (this.ctrl.saveParameterCategory()) {
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
        String parameterCategoryCode = Utils.readLineFromConsole("Parameter Category Code:");
        String name = Utils.readLineFromConsole("Name:");

        return this.ctrl.createParameterCategory(parameterCategoryCode, name);
    }
}
