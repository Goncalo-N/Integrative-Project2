package app.controller;

import app.domain.model.Test;
import app.domain.model.Company;
import app.domain.shared.Constants;
import java.util.ArrayList;

public class CreateAnalysisController {

    private final Company company;

    public CreateAnalysisController()
    {
        this(App.getInstance().getCompany());
    }
    public CreateAnalysisController(Company company)
    {
        checkUserAuth();
        this.company = company;
    }

    private void checkUserAuth() {
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_LABORATORYCOORDINATOR);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public ArrayList<Test> getTestList() {
        return this.company.getTestList();
    }
}

