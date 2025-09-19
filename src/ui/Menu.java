package ui;

import entities.Account;
import entities.AccountType;
import entities.Client;
import exceptions.AccountInexistantException;
import exceptions.SoldInsuffisantException;
import repository.AccountRepository;
import services.AccountService;
import services.ClientService;

import java.util.Scanner;

public class Menu {
    private Client clientLogged = null;
//    ClientService clientServ = new ClientService();
    ClientService clientService = new ClientService();
    String accnumber = null;
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
                    System.out.println("===search fro a client=====");
                    System.out.println("enter account Number:");
                    String accountNum = sc.nextLine();
                    search(accountNum);
                    break;
                case 2:
                    System.out.println("first name: ");
                    String firstname= sc.nextLine();
                    System.out.println("last name: ");
                    String lastname= sc.nextLine();
                    System.out.println("first name: ");
                    String email= sc.nextLine();
                    System.out.println("password: ");
                    String password= sc.nextLine();
                    System.out.println("account type:");
                    System.out.println("1- current:");
                    System.out.println("2- saving:");
                    AccountType accountype = null;
                    int choiceAcc= sc.nextInt();
                    sc.nextLine();
                    switch (choiceAcc){
                        case 1:  accountype = AccountType.CURRENT;
                        break;
                        case 2:  accountype = AccountType.SAVINGS;
                    }
                    createAccountClient(firstname, lastname, email, password, 0.0,accountype);
                    break;
                case 3:
                    System.out.println("Enter account number: ");
                    String accountNumn = sc.nextLine();

                    AccountRepository repo = new AccountRepository();
                    repo.showTransactions(accountNumn);

                    break;
                case 4: //editClientInfo(String clientId);
                    break;
                case 5: //blockClient(String clientId);
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
            System.out.println("5) Show balance");
            System.out.println("6) Show all accounts");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            int cchoice = sc.nextInt();
            sc.nextLine();
            switch (cchoice) {
                case 1:
                    System.out.println("create an count");
                    break;
                case 2:
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                   Account acc = clientLogged.getAccounts().get(accnumber);
                    AccountService accServ = new AccountService();
                    accServ.deposit(acc, amount);
                    System.out.println("* [Deposit]done with success *");
                    break;
                case 3:
                    System.out.println("enter amount");
                    double amountD = sc.nextDouble();
                    sc.nextLine();
                    Account acc1 = clientLogged.getAccounts().get(accnumber);
                    AccountService accServ2 = new AccountService();
                    accServ2.withdraw(acc1, amountD);
                    System.out.println("* [withdraw]done with success *");
                    break;
                case 4:
                    System.out.println("------- --------");
                    System.out.println("*  tranasfer   *");
                    System.out.println("------- --------");
                    System.out.println("enter amount: ");
                    double transAmount = sc.nextDouble();
                    sc.nextLine();
                    Account srcAcc = clientLogged.getAccounts().get(accnumber);// to get the source account
                    if(transAmount <= 0){
                        throw new SoldInsuffisantException("amount must be positive");
                    } else if (transAmount > (srcAcc.getSold())) {
                        System.out.println("ur balance is not enough to complete this transaction");
                        break;
                    }
                    System.out.println("enter Account Number: ");
                    String accnumberdes = sc.nextLine();
                    if(accnumber.equals(null)){
                        throw new AccountInexistantException("the account number must be at least 5 numbers");
                    }
                    Account accdestination = AccountService.findAccountByNumber(accnumberdes);
                    if(accdestination != null){
                        /**
                         * deposit in the account of the destinater
                         * withraw from my account
                         */

                        AccountService accService = new AccountService();
                        accService.deposit(accdestination, transAmount);//
                        accService.withdraw(srcAcc, transAmount);
                    }

                    break;
                case 5:
                    System.out.println("--------balance------");
                    Account srcAcc1 = clientLogged.getAccounts().get(accnumber);
                    double balance = srcAcc1.getSold();
                    System.out.println("your balance: "+ balance + "$");
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
        accnumber = account.getAccountNumber();
        System.out.println("u have registred successfully");
        System.out.println("welcome "+ newclient.getFirstName());
        System.out.println("------------------warning-----------------");
        System.out.println("|==>ur account password:"+ newclient.getIdClient());
        System.out.println("----------------------------------------------");

//        this.displayClientOperaMenu();
        System.out.println("now u can login");
        login();

    }

    // for the gestionnaire
    public Account search(String accnumber){
        ClientService clients = new ClientService();
        for (Client client : clients.getClients().values()) {
            Account acc = client.getAccounts().get(accnumber);
            if (acc != null) return acc;
        }
        return null;
    }

    public void createAccountClient(String firstName, String lastName, String email, String password, double amount, AccountType accountType){
        Client newClient = new Client(firstName, lastName, email, password, null);
        Account account = new Account(amount, accountType);
        clientService.addClient(newClient);
        System.out.println("account number: ");
        System.out.println(newClient.getIdClient());
    }

}
