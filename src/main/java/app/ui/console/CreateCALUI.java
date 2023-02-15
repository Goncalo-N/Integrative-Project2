package app.ui.console;

import app.controller.CreateCALController;
import app.domain.model.TestType;
import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CreateCALUI implements Runnable{

    private final CreateCALController ctrl;
    private final ArrayList<String> CALTestList = new ArrayList<>();

    public CreateCALUI(){
        this.ctrl = new CreateCALController();
    }

    @Override
    public void run() {

        System.out.println("\n Creating a new Clinical Analysis Laboratory: \n");
        try {
            if (readData())
            {
                if (Utils.confirm("Do you confirm the Clinical Analysis Laboratory (Y/N)")) {
                    if (this.ctrl.saveCAL()) {
                        System.out.println("Lista: " + CALTestList);
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

    private boolean readData() throws Exception {
        String laboratoryID = Utils.readLineFromConsole("LaboratoryID:");
        String name = Utils.readLineFromConsole("Description:");
        String address = Utils.readLineFromConsole("Address:");
        String phoneNumber = Utils.readLineFromConsole("Phone Number:");
        String tinNumber = Utils.readLineFromConsole("TIN Number:");

        List<TestTypeItem> options = new ArrayList<>();
        options.add(new TestTypeItem("Blood tests"));
        options.add(new TestTypeItem("Covid-19 tests"));
        int option;
        do
        {
            ctrl.getTestTypes();
            option = Utils.showAndSelectIndex(options, "\n\nSelect the type of test(s):");
            System.out.println("Option: " + option);

            if ((option >= 0) && (option < options.size()))
            {
                if(option == 0)
                {
                    CALTestList.add("Blood tests");
                    System.out.println("Lista: " + CALTestList);
                }
                else
                    if (option == 1)
                    {
                        CALTestList.add("Covid-19 tests");
                        System.out.println("Lista: " + CALTestList);
                    }
            }
            if (!Utils.confirm("Do you want to select more types of test? (Y/N)"))
                option = -1;
        }
        while (option != -1);

        return this.ctrl.createCAL(laboratoryID, name, address, phoneNumber, tinNumber, CALTestList);
    }
}
