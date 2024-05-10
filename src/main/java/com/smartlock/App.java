package com.smartlock;

import com.smartlock.business.adapters.ValidateEmailAdapter;
import com.smartlock.business.admin.AdminManager;
import com.smartlock.business.enviroment.EnviromentManager;
import com.smartlock.business.lock.LockManager;
import com.smartlock.business.user.UserManagerFacede;
import com.smartlock.business.validators.ValidateEmail;
import com.smartlock.business.reports.ReportTXT;
import com.smartlock.business.reports.ReportTemplate;

import com.smartlock.infra.database.Database;
import com.smartlock.infra.database.Memory;
import com.smartlock.infra.database.SqLite;

import com.smartlock.view.ContextStrategyMenu;
import com.smartlock.view.StartUpPage;
import com.smartlock.view.enviroment.EnviromentMenu;
import com.smartlock.view.enviroment.EnviromentPage;
import com.smartlock.view.lock.LockMenu;
import com.smartlock.view.lock.LockPage;
import com.smartlock.view.reports.ReportMenu;
import com.smartlock.view.reports.ReportPage;
import com.smartlock.view.user.Command;
import com.smartlock.view.user.LoginCommand;
import com.smartlock.view.user.LoginPage;
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
        ValidateEmail validateEmail = new ValidateEmailAdapter();
        AdminManager adminManager = new AdminManager(database);
        UserManagerFacede userManager = UserManagerFacede.getInstance(database, validateEmail);
        LockManager lockManager = LockManager.getInstance(database); // Singleton
        EnviromentManager enviromentManager = new EnviromentManager(database);
        ReportTemplate reportManager = new ReportTXT(database);
        // Pages
        UserPage userPage = new UserPage(userManager, enviromentManager);
        LockPage lockPage = new LockPage(lockManager, enviromentManager);
        EnviromentPage enviromentPage = new EnviromentPage(enviromentManager);
        ReportPage reportPage = new ReportPage(reportManager);
        // Menu
        ContextStrategyMenu context = new ContextStrategyMenu();
        UserMenu userMenu = new UserMenu(userPage);
        LockMenu lockMenu = new LockMenu(lockPage);
        EnviromentMenu enviromentMenu = new EnviromentMenu(enviromentPage);
        LoginPage loginPage = new LoginPage();
        ReportMenu reportMenu = new ReportMenu(reportPage);
        StartUpPage menu = new StartUpPage(userMenu, lockMenu, enviromentMenu, context, reportMenu);

        Command login = new LoginCommand(loginPage, adminManager, menu);

        login.execute();
    }
}
