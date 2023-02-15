package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;

import java.util.ArrayList;

public class CreateRepDiagController {

    private final Company company;
    private RepDiag repdiag;

    public CreateRepDiagController()
    {
        this(App.getInstance().getCompany());
    }

    public CreateRepDiagController(Company company)
    {
        checkUserAuth();
        this.company = company;
        this.repdiag = null;
    }

    private void checkUserAuth() {
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_SPECIALISTDOCTOR);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public ArrayList<Test> getTestList() {
        return this.company.getTestList();
    }

    public ArrayList<Test> getInstanceOfTestCode(long testCode) {
        return this.company.getInstanceOfTestCode(testCode);
    }

    public void createRepDiag(String report, long testCode) {
        this.repdiag = this.company.createRepDiag(report, testCode);
        this.company.validateRepDiag(repdiag);
    }
}