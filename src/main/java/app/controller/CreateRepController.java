package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;

/**
 *
 */
public class CreateRepController {

    private final Company company;

    public CreateRepController()
    {
        this(App.getInstance().getCompany());
    }

    /**
     * checks userAuth and gives initializes the variables this.company and this.rep
     * @param company Company
     */
    public CreateRepController(Company company)
    {
        checkUserAuth();
        this.company = company;
    }


    /**
     * Checks if user is logged in with the role of admin
     */
    private void checkUserAuth() {
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    /**
     * Creates the report
     * @param rep  corresponds to the report
     */
    public void createRep(String rep)
    {
        this.company.validateRep(rep);
    }

    /**
     * "Sends" the report to NHS
     * @param rep corresponds to the report
     * @return returns report (rep)
     */
    public boolean sendRep(String rep)
    {
        return this.company.sendRep(rep);
    }
}

