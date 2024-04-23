package com.smartlock;

import com.smartlock.Business.Admin.AdminManager;
import com.smartlock.Business.Enviroment.EnviromentManager;
import com.smartlock.Business.Lock.LockManager;
import com.smartlock.Business.User.UserManager;
import com.smartlock.Infra.database.Database;
import com.smartlock.Infra.database.Memory;
import com.smartlock.Infra.database.SqLite;
import com.smartlock.View.LoginPage;
import com.smartlock.View.StartUpPage;
import com.smartlock.View.Enviroment.EnviromentMenu;
import com.smartlock.View.Enviroment.EnviromentPage;
import com.smartlock.View.Lock.LockMenu;
import com.smartlock.View.Lock.LockPage;
import com.smartlock.View.User.UserMenu;
import com.smartlock.View.User.UserPage;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Database database = new SqLite();
        // Managers
        AdminManager adminManager = new AdminManager(database);
        UserManager userManager = new UserManager(database);
        LockManager lockManager = new LockManager(database);
        EnviromentManager enviromentManager = new EnviromentManager(database);
        // Pages
        UserPage userPage = new UserPage(userManager);
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
