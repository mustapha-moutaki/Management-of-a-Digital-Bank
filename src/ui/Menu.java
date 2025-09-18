package ui;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public void start(){
        System.out.println("|===> Welcome in Digital bank <===|");
        System.out.println("---------");
        System.out.println("1) Banker");
        System.out.println("2) Client");
        System.out.println("0) exit");
        System.out.println("---------");
        System.out.println("please select: ");

        int choice = sc.nextInt();

        switch (choice){
            case 1: displayGenstionnaireMenu();
                break;
            case 2: displayClientMenu();
                break;
            case 0:
                System.out.println("good bye");
                System.exit(0);
            default:
                System.out.println("invalid select,pls try again");
        }
    }

    public void displayGenstionnaireMenu(){

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
        switch (gchoice){
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
    public void displayClientMenu(){
        System.out.println("============================");
        System.out.println("* Welcome in Client space *");
        System.out.println("============================");
        System.out.println("1) Create account");
        System.out.println("2) Edit account");
        System.out.println("3) Deposit");
        System.out.println("4) Widthraw");
        System.out.println("5) Transfer");
        System.out.println("0) Exit");
        System.out.println("please select: ");
        int cchoice = sc.nextInt();
        switch (cchoice){
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
