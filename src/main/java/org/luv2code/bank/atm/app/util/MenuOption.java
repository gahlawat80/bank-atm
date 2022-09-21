package org.luv2code.bank.atm.app.util;

import org.luv2code.bank.atm.app.model.Login;
import org.luv2code.bank.atm.app.model.Registration;
import org.luv2code.bank.atm.app.service.AuthService;
import org.luv2code.bank.atm.app.service.TransactionService;

import java.util.Scanner;

public class MenuOption {
    private static Scanner sc = new Scanner(System.in);
    private static AuthService authService = new AuthService();
    private static TransactionService txService = new TransactionService();

    public void showMainMenu() throws Exception {
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
                        while(!isExit) {
                            showSubMenu();
                            System.out.println("Please make your transaction choice: ");
                            int txChoice = sc.nextInt();
                            switch (txChoice) {
                                case 1:
                                    txService.getCurrentBalance(accountId);
                                    break;
                                case 2:
                                    System.out.println("Deposit amount");
                                    break;
                                case 3:
                                    System.out.println("Withdraw amount");
                                    break;
                                case 4:
                                    System.out.println("View mini-statement");
                                    break;
                                case 5:
                                    System.out.println("View detailed statement");
                                    break;
                                case 6:
                                    System.out.println("Exiting the system. Thanks for doing business with us!");
                                    isExit = true;
                                    break;
                                default:
                                    System.out.println("Provide a valid input choice");
                                    break;
                            }
                        }
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

    private void showSubMenu(){
        System.out.println("1-View Balance\n" +
                "2-Deposit amount\n" +
                "3-Withdraw amount\n" +
                "4-View Mini-statement\n" +
                "5-View Detailed-statement \n" +
                "6-Exit application");
    }
}
