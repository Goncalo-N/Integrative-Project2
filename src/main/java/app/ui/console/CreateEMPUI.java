package app.ui.console;

import app.controller.CreateEMPController;
import app.ui.console.utils.Utils;

public class CreateEMPUI implements Runnable{

    private final CreateEMPController ctrl;

    public CreateEMPUI(){
        this.ctrl = new CreateEMPController();
    }

    @Override
    public void run() {

        System.out.println("\n Creating a new EMP: \n");
        try {
            if (readData())
            {
                if (Utils.confirm("Do you confirm the EMP (Y/N)")) {
                    if (this.ctrl.saveEMP()) {
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
        String empID = Utils.readLineFromConsole("empID:");
        String organizationRole = Utils.readLineFromConsole("organization Role:");
        String name = Utils.readLineFromConsole("Name:");
        String address = Utils.readLineFromConsole("Address:");
        String email = Utils.readLineFromConsole("Email:");
        String phoneNumber = Utils.readLineFromConsole("Phone Number:");
        String soc = Utils.readLineFromConsole("Soc:");

        return this.ctrl.createEMP(empID, organizationRole, name, address, email, phoneNumber, soc);
    }
}
