package com.smartlock;

import com.smartlock.business.admin.AdminManager;
import com.smartlock.business.enviroment.EnviromentManager;
import com.smartlock.business.lock.LockManager;
import com.smartlock.business.user.UserManager;
import com.smartlock.business.validators.ValidateEmail;
import com.smartlock.infra.database.Database;
import com.smartlock.infra.database.Memory;
import com.smartlock.infra.database.SqLite;
import com.smartlock.view.LoginPage;
import com.smartlock.view.StartUpPage;
import com.smartlock.view.enviroment.EnviromentMenu;
import com.smartlock.view.enviroment.EnviromentPage;
import com.smartlock.view.lock.LockMenu;
import com.smartlock.view.lock.LockPage;
import com.smartlock.view.user.UserMenu;
import com.smartlock.view.user.UserPage;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Database database = new SqLite();
        // Managers
        ValidateEmail validateEmail = new ValidateEmail();
        AdminManager adminManager = new AdminManager(database);
        UserManager userManager = new UserManager(database, validateEmail);
        LockManager lockManager = new LockManager(database);
        EnviromentManager enviromentManager = new EnviromentManager(database);
        // Pages
        UserPage userPage = new UserPage(userManager, enviromentManager);
        LockPage lockPage = new LockPage(lockManager, enviromentManager);
        EnviromentPage enviromentPage = new EnviromentPage(enviromentManager);
        // Menu
        UserMenu userMenu = new UserMenu(userPage);
        LockMenu lockMenu = new LockMenu(lockPage);
        EnviromentMenu enviromentMenu = new EnviromentMenu(enviromentPage);

        StartUpPage menu = new StartUpPage(userMenu, lockMenu, enviromentMenu);

        LoginPage login = new LoginPage(adminManager, menu);

        login.login();
    }
}
