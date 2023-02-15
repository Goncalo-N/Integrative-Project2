package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.shared.Constants;
import java.util.List;

public class CreateParameterController {

    private final Company company;
    private Parameter parameter;
    private final List<ParameterCategory> parameterCategoryList;
    public CreateParameterController(){
        this(App.getInstance().getCompany());
    }

    public CreateParameterController(Company company){
        checkUserAuth();
        this.company = company;
        this.parameter = null;
        this.parameterCategoryList = company.getParameterCategoryList();
    }

    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    public boolean createParameter(long parameterCode, String shortName, String description, String categoryName)
    {
        this.parameter = this.company.createParameter(parameterCode, shortName, description, categoryName);
        return this.company.validateParameter(parameter);
    }

    public boolean saveParameter()
    {
        return this.company.saveParameter(parameter);
    }

    public List<ParameterCategory> getParameterCategoryList() {
        return parameterCategoryList;
    }
}


