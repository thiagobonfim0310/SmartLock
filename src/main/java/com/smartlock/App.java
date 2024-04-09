package com.smartlock;

import com.smartlock.Business.User.UserManager;
import com.smartlock.Infra.Database;
import com.smartlock.View.StartUpPage;
import com.smartlock.View.User.UserPage;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Database database = new Database();
        UserManager userManager = new UserManager(database);
        UserPage userPage = new UserPage(userManager);
        StartUpPage menu = new StartUpPage(userPage);

        menu.menu();
    }
}
