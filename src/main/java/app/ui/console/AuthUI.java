package app.ui.console;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class AuthUI implements Runnable{
    private final AuthController ctrl;

    public AuthUI() throws ParseException {
        ctrl = new AuthController();
    }

    public void run()
    {
        boolean success = doLogin();

        if (success)
        {
            List<UserRoleDTO> roles = this.ctrl.getUserRoles();
            if ( (roles == null) || (roles.isEmpty()) )
            {
                System.out.println("User has not any role assigned.");
            }
            else
            {
                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role))
                {
                    List<MenuItem> rolesUI = getMenuItemForRoles();
                    this.redirectToRoleUI(rolesUI,role);
                }
                else
                {
                    System.out.println("User did not select a role.");
                }
            }
        }
        this.logout();
    }

    private List<MenuItem> getMenuItemForRoles()
    {
        List<MenuItem> rolesUI = new ArrayList<>();
        rolesUI.add(new MenuItem(Constants.ROLE_ADMIN, new AdminUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_RECEPTIONIST, new ReceptionistUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_MEDICALLABTECHNICIAN, new MedicalLabTechnicianUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_SPECIALISTDOCTOR, new SpecialistDoctorUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_LABORATORYCOORDINATOR, new LaboratoryCoordinatorUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_CLIENT, new ClientUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST, new ClinicalChemistryTechnologistUI()));

        return rolesUI;
    }

    private boolean doLogin()
    {
        System.out.println("\nLogin UI:");

        int maxAttempts = 3;
        boolean success;
        do
        {
            maxAttempts--;
            System.out.println("Main Administrator: \n Email: admin@lei.sem2.pt \n");
            System.out.println("Receptionist: \n Email: receptionist@lei.sem2.pt \n");
            System.out.println("Medical Lab Technician: \n Email: medicallabtechnician@lei.sem2.pt \n");
            System.out.println("Specialist Doctor: \n Email: specialistdoctor@lei.sem2.pt \n");
            System.out.println("Laboratory Coordinator: \n Email: laboratorycoordinator@lei.sem2.pt \n");
            System.out.println("Clinical Chemistry Technologist: \n Email: clinicalchemistrytechnologist@lei.sem2.pt\n");
            System.out.println("Client: \n Email: jose@lei.sem2.pt \n Email: pedro@lei.sem2.pt \n Email: antonio@lei.sem2.pt\n");

            String id = Utils.readLineFromConsole("Enter UserId/Email: ");
            String pwd = Utils.readLineFromConsole("Enter Password: ");

            success = ctrl.doLogin(id, pwd);
            if (!success)
            {
                System.out.println("Invalid UserId and/or Password. \n You have  " + maxAttempts + " more attempt(s).");
            }

        } while (!success && maxAttempts > 0);
        return success;
    }

    private void logout()
    {
        ctrl.doLogout();
    }

    private void redirectToRoleUI(List<MenuItem> rolesUI, UserRoleDTO role)
    {
        boolean found = false;
        Iterator<MenuItem> it = rolesUI.iterator();
        while (it.hasNext() && !found)
        {
            MenuItem item = it.next();
            found = item.hasDescription(role.getDescription());
            if (found)
                item.run();
        }
        if (!found)
            System.out.println("There is no UI for users with role '" + role.getDescription() + "'");
    }

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }
}
