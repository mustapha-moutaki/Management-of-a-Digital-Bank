package ui;

import entities.Account;
import entities.AccountType;
import entities.Client;
import exceptions.AccountInexistantException;
import services.AccountService;
import services.ClientService;

import java.util.Scanner;

public class Menu {
    private Client clientLogged = null;
//    ClientService clientServ = new ClientService();
    ClientService clientService = new ClientService();
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
                    displayClientMenuRe();
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
    public void displayClientMenuRe(){
        while(true) {
            System.out.println("============================");
            System.out.println("* Welcome in Client space *");
            System.out.println("============================");
            System.out.println("1) Register");
            System.out.println("2) Login/");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            int cchoice = sc.nextInt();
            sc.nextLine();
            switch (cchoice) {
                case 1:
                    System.out.println("Register");
                    register();
                    break;
                case 2: login();
                    break;

                case 0:
                    System.out.println("good bye");
                    System.exit(0);
                default:
                    System.out.println("please select valid number ");
            }
        }
    }

    public void displayClientOperaMenu() {
        while (true) {
            System.out.println("============================");
            System.out.println("* Welcome in Client space *");
            System.out.println("============================");
            System.out.println("1) Create account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Transfer");
            System.out.println("5) Show balance & history");
            System.out.println("6) Show all accounts");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            int cchoice = sc.nextInt();
            sc.nextLine();
            switch (cchoice) {
                case 1:
                    System.out.println("create an count");
//                    LoginAndRegister();
                    break;
                case 2:
//                    Client c = null;
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter account Number for comfirmation:");
                    String accNum = sc.nextLine();
                    Account acc = clientLogged.getAccounts().get(accNum);
                    AccountService accServ = new AccountService();
                    accServ.deposit(acc, amount);
                    System.out.println("* done with success *");
                    break;
                case 3:
                    System.out.println("enter account number: ");
                    int accNum1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter amount");
                    double amountD = sc.nextDouble();
                    sc.nextLine();
                    Account acc1 = clientLogged.getAccounts().get(accNum1);
                    AccountService accServ2 = new AccountService();
                    accServ2.withdraw(acc1, amountD);
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

    public void login(){
        System.out.println("--------Login--------");
        System.out.println("enter ur client id:");
        String clientId  = sc.nextLine();
        System.out.println("enter ur password:");
        String pass  = sc.nextLine();
        AccountService accser = new AccountService();
        try{
            Client c = clientService.findClient(clientId);//here we find the client but we should look for account
//            Account d = AccountService.findAccount()
            if(c.getPassword().equals(pass)){
                clientLogged = c;
                System.out.println("u have logged successfully");
                this.displayClientOperaMenu();
            }else{
                throw new AccountInexistantException("incorrect password or Id");
            }


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
//        ClientService clientService = new ClientService();
        clientService.addClient(newclient);
        Account account = new Account(0, AccountType.CURRENT);
        newclient.getAccounts().put(account.getAccountNumber(), account);// becasuse it's save key and value so we save the account number as string key and account value.
        System.out.println("u have registred successfully");
        System.out.println("welcome "+ newclient.getFirstName());
        System.out.println("------------------warning-----------------");
        System.out.println("ur account password:"+ newclient.getIdClient());
        System.out.println("ur account id: "+ account.getAccountNumber());
        System.out.println("----------------------------------------------");

//        this.displayClientOperaMenu();
        System.out.println("now u can login");
        login();

    }

}
