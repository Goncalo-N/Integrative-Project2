package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.shared.Constants;

import java.util.ArrayList;

public class CreateSampleController {
    private final Company company;
    private Sample sample;
    public CreateSampleController()
    {
        this(App.getInstance().getCompany());
    }

    public CreateSampleController(Company company)
    {
        checkUserAuth();
        this.company = company;
        this.sample = null;
    }

    private void checkUserAuth() {
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_MEDICALLABTECHNICIAN);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public boolean createSample(String barcode, String testDesignation)
    {
        this.sample = this.company.createSample(barcode, testDesignation);
        return this.company.validateSample(sample);
    }

    public boolean saveSample()
    {
        return this.company.saveSample(sample);
    }

    public ArrayList<Test> getTestList() {
      return this.company.getTestList();
  }

    public ArrayList<Test> getInstanceOfState(String state) {
        return this.company.getInstanceOfState(state);
    }
}