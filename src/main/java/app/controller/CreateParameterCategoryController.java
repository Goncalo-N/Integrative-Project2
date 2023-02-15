package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.shared.Constants;

public class CreateParameterCategoryController {

    private final Company company;
    private ParameterCategory pc;
    public CreateParameterCategoryController()
    {
        this(App.getInstance().getCompany());
    }

    public CreateParameterCategoryController(Company company)
    {
        checkUserAuth();
        this.company = company;
        this.pc = null;
    }

    private void checkUserAuth() {
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public boolean createParameterCategory(String parameterCategoryCode, String name)
    {
        this.pc = this.company.createParameterCategory(parameterCategoryCode,name);
        return this.company.validateParameterCategory(pc);
    }

    public boolean saveParameterCategory()
    {
        return this.company.saveParameterCategory(pc);
    }
}
