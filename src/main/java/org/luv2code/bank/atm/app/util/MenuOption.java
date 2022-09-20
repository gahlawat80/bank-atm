package org.luv2code.bank.atm.app.util;

import org.luv2code.bank.atm.app.model.Login;
import org.luv2code.bank.atm.app.model.Registration;
import org.luv2code.bank.atm.app.service.AuthService;

import java.util.Scanner;

public class MenuOption {
    private static Scanner sc = new Scanner(System.in);
    private static AuthService authService = new AuthService();



    public void showMainMenu(){
        boolean isExit = false;
        System.out.println("WELCOME TO MY BANKING APPLICATION");

        do {
            System.out.println("1-Login\n" +
                    "2-Register");
            System.out.println("Please enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please provide account id:");
                    String accountId = sc.next();
                    System.out.println("Please enter pin:");
                    int pin = sc.nextInt();
                    Login login = new Login(accountId, pin);
                    boolean isValidUser = authService.isValidAccount(login);
                    if (!isValidUser) {
                        System.out.println("Account ID or Pin is not valid. Please provide valid credentials.");
                    } else {
                        System.out.println("Login is successful!");
                    }
                    break;
                case 2:
                    System.out.println("Please provide the account holder name:");
                    String name = sc.next();
                    System.out.println("Please provide the account holder age:");
                    int age = sc.nextInt();
                    System.out.println("Please provide the account id:");
                    String account = sc.next();
                    System.out.println("Please provide the account pin:");
                    int accountPin = sc.nextInt();
                    System.out.println("Please provide the account pin again to confirm:");
                    int accountPinConfirm = sc.nextInt();
                    authService.registerUser(new Registration(name,age,account,accountPin,accountPinConfirm));
                    break;
                default:
                    System.out.println("Please choose a valid option.");
                    break;
            }
        }while (!isExit);
    }
}
