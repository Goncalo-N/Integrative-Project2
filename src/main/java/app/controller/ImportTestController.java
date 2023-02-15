package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.shared.Constants;
import java.text.ParseException;
import java.util.ArrayList;

public class ImportTestController {

    private final Company company;

    public ImportTestController(){
        this(App.getInstance().getCompany());
    }

    public ImportTestController(Company company){
        checkUserAuth();
        this.company = company;
    }

    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_LABORATORYCOORDINATOR);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public boolean createTest(long testCode, String nhsCode, String testDesignation, long ccNumber, String testType, ArrayList<String> parameterCategoryList,
                              ArrayList<String> parameterList, String state) throws ParseException {
        Test test = this.company.createTest(testCode, nhsCode, testDesignation, ccNumber, testType, parameterCategoryList, parameterList, state);
        return this.company.validateTest(test);
    }
    /**
     * Gets the Test List
     * @return test list of test
     */
    public ArrayList<Test> getTestList() {
        return this.company.getTestList();
    }
}