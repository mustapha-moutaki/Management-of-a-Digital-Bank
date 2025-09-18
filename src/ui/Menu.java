package ui;

import entities.Client;
import exceptions.AccountInexistantException;
import services.AccountService;
import services.ClientService;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public void start(){
        while(true) {
            System.out.println("|===> Welcome in Digital bank <===|");
            System.out.println("---------");
            System.out.println("1) Banker");
            System.out.println("2) Client");
            System.out.println("0) exit");
            System.out.println("---------");
            System.out.println("please select: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayGenstionnaireMenu();
                    break;
                case 2:
                    displayClientMenu();
                    break;
                case 0:
                    System.out.println("good bye");
                    System.exit(0);
                default:
                    System.out.println("invalid select,pls try again");
            }
        }
    }

    public void displayGenstionnaireMenu(){
    while(true) {
            System.out.println("============================");
            System.out.println("* Welcome in Banker space *");
            System.out.println("============================");
            System.out.println("1) Search for client");
            System.out.println("2) Create account");
            System.out.println("3) See client transaction");
            System.out.println("4) Edit client info");
            System.out.println("5) Block a client");
            System.out.println("0) Exit");
            System.out.println("please select: ");
            int gchoice = sc.nextInt();
            sc.nextLine();
            switch (gchoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("good bye");
                    System.exit(0);
                default:
                    System.out.println("please select valid number ");
            }
        }
    }
    public void displayClientMenu(){
        while(true) {
            System.out.println("============================");
            System.out.println("* Welcome in Client space *");
            System.out.println("============================");
            System.out.println("1) Login/Register");
            System.out.println("2) Create account");
            System.out.println("3) Deposit");
            System.out.println("4) Withdraw");
            System.out.println("5) Transfer");
            System.out.println("6) Show balance & history");
            System.out.println("7) Show all accounts");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            int cchoice = sc.nextInt();
            sc.nextLine();
            switch (cchoice) {
                case 1:
                    System.out.println("create an count");
                    LoginAndRegister();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("enter account number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter amount");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    AccountService accountservice = new AccountService();
                    accountservice.deposit(acc);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("good bye");
                    System.exit(0);
                default:
                    System.out.println("please select valid number ");
            }
        }
    }

    public void LoginAndRegister(){
        System.out.println("-----------");
        System.out.println("1-login");
        System.out.println("2-register");
        System.out.println("selecte ur option: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op){
            case 1:login();
                break;
            case 2:register();
                break;
            default:
                System.out.println("invalid choice");;
        }
    }
    public void login(){
        System.out.println("enter ur client id:");
         String clientId  = sc.nextLine();
            ClientService clientService = new ClientService();
         try{
             clientService.findClient(clientId);
             System.out.println("u have logged successfully");
         }catch (AccountInexistantException e){
             System.out.println(e.getMessage());
         }
    }

    public void register(){
        System.out.println("-----register----");
        System.out.println("enter ur first Name:");
        String firstname = sc.nextLine();
        System.out.println("enter ur last Name:");
        String lastname = sc.nextLine();
        System.out.println("enter email:");
        String userEmail = sc.nextLine();
        System.out.println("enter password:");
        String password = sc.nextLine();
        Client newclient = new Client(firstname, lastname, userEmail, password, null);
        ClientService clientServ = new ClientService();
        clientServ.addClient(newclient);
        System.out.println("u have registred successfully");
        System.out.println("welcome "+ newclient.getFirstName());
        System.out.println("ur client id: "+ newclient.getIdClient());

    }

}
