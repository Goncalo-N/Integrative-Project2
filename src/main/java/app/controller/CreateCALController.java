package app.controller;

import app.domain.model.CAL;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestType;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

public class CreateCALController
{
    private final Company company;
    private CAL cal;
    private List<String> CALTestList;
    private List<String> TestTypeList;
    public CreateCALController(){
        this(App.getInstance().getCompany());
    }

    public CreateCALController(Company company){
        checkUserAuth();
        this.company = company;
        this.cal = null;
    }

    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public void getTestTypes()
    {
        System.out.println("Test Type: " + TestTypeList);
    }

    public Test getTests()
    {
        return (Test) this.CALTestList;
    }

    public boolean createCAL(String laboratoryID, String name, String address, String phoneNumber, String tinNumber, ArrayList<String> CALTestList) throws Exception {
        this.cal = this.company.createCAL(laboratoryID, name, address, phoneNumber, tinNumber, CALTestList);
        return this.company.validateCAL(cal);
    }

    public boolean saveCAL()
    {
        return this.company.saveCAL(cal);
    }

    public void setTestTypeList(List<String> testTypeList) {
        TestTypeList = testTypeList;
    }

    public void setCALTestList(List<String> CALTestList) {
        this.CALTestList = CALTestList;
    }
}
