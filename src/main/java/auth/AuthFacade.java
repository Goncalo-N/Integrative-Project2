package auth;

import auth.domain.model.User;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;
import auth.domain.store.UserStore;

import java.util.Optional;

public class AuthFacade {
    private UserSession userSession;

    private final UserRoleStore roles ;
    private final UserStore users;

    public AuthFacade()
    {
        this.userSession = new UserSession();
        this.roles = new UserRoleStore();
        this.users = new UserStore();
    }


    public void addUserRole(String id, String description)
    {
        UserRole role = this.roles.create(id, description);
        this.roles.add(role);
    }

    public void addUserWithRole(String name, String email, String pwd, String roleId)
    {
        Optional<UserRole> roleResult = this.roles.getById(roleId);
        if (!roleResult.isPresent())
            return;

        User user = this.users.create(name,email,pwd);
        user.addRole(roleResult.get());
        this.users.add(user);
    }

    public UserSession doLogin(String email, String password)
    {
        Optional<User> result = this.users.getById(email);
        if (result.isPresent())
        {
            User user = result.get();
            if (user.hasPassword(password)){
                this.userSession = new UserSession(user);
            }
        }
        return this.userSession;
    }

    public void doLogout()
    {
        this.userSession.doLogout();
    }

    public UserSession getCurrentUserSession()
    {
        return this.userSession;
    }
}
