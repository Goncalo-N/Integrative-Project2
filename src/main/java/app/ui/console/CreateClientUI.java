package app.ui.console;

import app.controller.CreateClientController;
import app.ui.console.utils.Utils;
import java.util.Date;


public class CreateClientUI implements Runnable{

    private final CreateClientController ctrl;

    public CreateClientUI(){
        this.ctrl = new CreateClientController();
    }

    public void run() {

        System.out.println("\n Registering a new Client: \n");
        try {
            if (readData())
            {
                if (Utils.confirm("Do you confirm the new client? (Y/N)")) {
                    if (this.ctrl.saveClient()) {
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
        String Name = Utils.readLineFromConsole("Name:");
        long CitizenCardNumber = Utils.readIntegerFromConsole("CitizenCardNumber: ");
        long NHSNumber = Utils.readIntegerFromConsole("NHSNumber: ");
        Date BirthDate = Utils.readDateFromConsole("BirthDate: ");
        String Sex = Utils.readLineFromConsole("Sex: ");
        long TIN = Utils.readIntegerFromConsole("TIN: ");
        long PhoneNumber = Utils.readIntegerFromConsole("PhoneNumber: ");
        String Email = Utils.readLineFromConsole("Email: ");

        return this.ctrl.createClient(Name, CitizenCardNumber, NHSNumber, BirthDate, Sex, TIN, PhoneNumber, Email);
    }
}
