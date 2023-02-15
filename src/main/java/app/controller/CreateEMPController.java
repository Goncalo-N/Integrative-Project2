package app.controller;

import app.domain.model.Company;
import app.domain.model.EMP;
import app.domain.shared.Constants;

public class CreateEMPController
{
    private final Company company;
    private EMP emp;
    public CreateEMPController()
    {
        this(App.getInstance().getCompany());
    }

    public CreateEMPController(Company company)
    {
        checkUserAuth();
        this.company = company;
        this.emp = null;
    }

    private void checkUserAuth() {
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public boolean createEMP(String empID, String organizationRole, String name, String address, String email, String phoneNumber, String soc)
    {
        this.emp = this.company.createEMP(empID, organizationRole, name, address, email, phoneNumber, soc);
        return this.company.validateEMP(emp);
    }

    public boolean saveEMP()
    {
        return this.company.saveEMP(emp);
    }
}
