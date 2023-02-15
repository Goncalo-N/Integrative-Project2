package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.shared.Constants;
import java.util.ArrayList;

public class ValidateTestController {

    private final Company company;
    private Test test;
    private final ArrayList<Test> testList;
    public ValidateTestController(){
        this(App.getInstance().getCompany());
    }

    public ValidateTestController(Company company){
        checkUserAuth();
        this.company = company;
        this.testList = company.getTestList();
    }

    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_LABORATORYCOORDINATOR);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public Test getTest() {
        return test;
    }

    public ArrayList<Test> getTestList() {
        return testList;
    }

    public boolean saveValidation()
    {
        return this.company.saveValidation();
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
