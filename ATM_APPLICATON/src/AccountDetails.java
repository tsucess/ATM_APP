import java.text.DecimalFormat;
import java.util.Scanner;

public class AccountDetails {
    protected String fullName;
    protected String homeAddress;
    protected String accountType;

    protected int pin;
    protected String accountNumber;

    protected double accountBalance = 100;
//    protected int currentAccountBalance = 0;
    Scanner input = new Scanner(System.in);
    DecimalFormat currencyFormat = new DecimalFormat("'$'###,##0.00");

    public String setFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }

    public String setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
        return homeAddress;
    }

    public String setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
        return accountNumber;
    }

    public int setPinNumber(int pin){
        this.pin = pin;
        return pin;
    }


//    public double setAccountBal(double accountBalance){
//        this.accountBalance = accountBalance ;
//        return accountBalance;
//    }
    public String getAccountNumber(){
        return accountNumber;
    }

    public int getPinNumber(){
        return pin;
    }

//    public double getAccountBalanceNumber(){
//        return accountBalance;
//    }


    public String getFullName() {
        return fullName.toUpperCase();
    }

    public String getHomeAddress() {
        return homeAddress.toUpperCase();
    }

    public double calcSavingsDeposit(double amount){
       return accountBalance += amount;
    }

    public double calcSavingsWithdrawal(double amount){
        accountBalance = accountBalance - amount;
        return accountBalance;
    }

//    public double calcCurrentDeposit(double amount){
//        return currentAccountBalance += amount;
//    }
//
//    public double calcCurrentWithdrawal( double amount){
//        return currentAccountBalance -= amount;
//    }


    public void withdrawFunds(){
        System.out.println("Account Balance: " + currencyFormat.format(accountBalance)); //checkingBalance
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if((accountBalance - amount) >= 0){
            calcSavingsWithdrawal(amount);
            System.out.println("Your New Account Balance: " + currencyFormat.format(accountBalance)); //checkingBalance
        } else {

            System.out.println(" Insufficient Account Balance: " + "\n");
        }
    }



    public void depositFunds(){
        System.out.println("Account Balance: " + currencyFormat.format(accountBalance));
        System.out.println("Enter the Amount you want to Deposit: ");
        double amount = input.nextDouble();
        calcSavingsDeposit(amount);
        System.out.println("Your New Account Balance: " + currencyFormat.format(accountBalance));
    }




}
