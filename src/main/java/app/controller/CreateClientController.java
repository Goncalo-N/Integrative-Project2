package app.controller;

import app.domain.model.Client;
import app.domain.shared.Constants;
import app.domain.model.Company;
import java.util.Date;

public class CreateClientController
{
    private Client client;
    private final Company company;

    public CreateClientController(){ this(App.getInstance().getCompany()); }

    public CreateClientController(Company company){
        checkUserAuth();
        this.company = company;
        this.client = null;
    }

    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_RECEPTIONIST);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public boolean createClient (String Name, long CitizenCardNumber, long NHSNumber, Date BirthDate, String Sex, long TIN, long PhoneNumber, String Email)
    {
        this.client = this.company.createClient(Name, CitizenCardNumber, NHSNumber, BirthDate, Sex, TIN, PhoneNumber, Email);
        return this.company.validateClient(client);
    }

    public boolean saveClient()
    {
        return this.company.saveClient(client);
    }
}

