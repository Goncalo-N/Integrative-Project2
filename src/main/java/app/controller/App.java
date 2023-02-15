package app.controller;

import app.domain.model.Company;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

    private final Company company;
    private final AuthFacade authFacade;

    private App(){
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ignored)
        {

        }
        return props;
    }

    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);

        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);

        this.authFacade.addUserWithRole("Receptionist", "receptionist@lei.sem2.pt", "123456",Constants.ROLE_RECEPTIONIST);

        this.authFacade.addUserRole(Constants.ROLE_MEDICALLABTECHNICIAN,Constants.ROLE_MEDICALLABTECHNICIAN);

        this.authFacade.addUserWithRole("Medical Lab Technician", "medicallabtechnician@lei.sem2.pt", "123456",Constants.ROLE_MEDICALLABTECHNICIAN);

        this.authFacade.addUserRole(Constants.ROLE_SPECIALISTDOCTOR,Constants.ROLE_SPECIALISTDOCTOR);

        this.authFacade.addUserWithRole("Specialist Doctor", "specialistdoctor@lei.sem2.pt", "123456",Constants.ROLE_SPECIALISTDOCTOR);

        this.authFacade.addUserRole(Constants.ROLE_LABORATORYCOORDINATOR,Constants.ROLE_LABORATORYCOORDINATOR);

        this.authFacade.addUserWithRole("Laboratory Coordinator", "laboratorycoordinator@lei.sem2.pt", "123456",Constants.ROLE_LABORATORYCOORDINATOR);

        this.authFacade.addUserRole(Constants.ROLE_CLIENT,Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("José", "jose@lei.sem2.pt", "123456",Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("Pedro", "pedro@lei.sem2.pt", "123456",Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("António", "antonio@lei.sem2.pt", "123456",Constants.ROLE_CLIENT);

        this.authFacade.addUserRole(Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST,Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST);

        this.authFacade.addUserWithRole("Clinical Chemistry Technologist", "clinicalchemistrytechnologist@lei.sem2.pt", "123456",Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance(){
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}
