import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends AccountDetails{
    Scanner input = new Scanner(System.in);
    DecimalFormat currencyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<String, Integer> acctData = new HashMap<>();
    HashMap<String, String> acctName = new HashMap<>();
    HashMap<String, String> acctAddress = new HashMap<>();
    HashMap<String, String> acctBalance = new HashMap<>();
    HashMap<String, String> acctType = new HashMap<>();
    public void initApp(){
        System.out.println("Welcome to our ATM stand, We are happy to see you... ");
        System.out.println(" Type 1 - Create Account");
        System.out.println(" Type 2 - Login Account");
        System.out.println (" Type 3 - Exit");

        int selection = Integer.parseInt(input.nextLine());

        switch (selection){
            case 1:
                createAccount();
            break;
            case 2:
                loginAccount();
//                initApp();
                break;
            case 3:
                System.out.println("Thank you for Banking with us! ");
                break;
            default:
                System.out.println(" Invalid Number Try Again... ");
                initApp();
        }

    }

    public void stayOnApp(){
        System.out.println(" TYPE 1 to PERFORM another Transaction OR TYPE 2 to Exit");

        int selection = Integer.parseInt(input.nextLine());

        switch (selection){
            case 1:
                menuOption();
                break;
            case 2:
                System.out.println("Thank you for Banking with us! ");
                break;
            default:
                System.out.println(" Invalid Number Try Again... ");
                initApp();
        }

    }

    public void createAccount(){
            System.out.println("Enter your Full Name: ");
            setFullName(input.nextLine());
            System.out.println("Enter your Home Address: ");
            setHomeAddress(input.nextLine());
            getAccountType();

    }
    public void linkAccountDetails (){
        acctName.put(accountNumber, getFullName());
        acctAddress.put(accountNumber, getHomeAddress());
        acctBalance.put(accountNumber, currencyFormat.format(accountBalance));
        acctType.put(accountNumber, accountType);
}


    public void getAccountType(){
        System.out.println("Select the Type of Account you would like to Open: ");
        System.out.println(" Type 1 - Current Account");
        System.out.println(" Type 2 - Savings Account");
        System.out.println (" Type 3 - Exit");


        int selection = Integer.parseInt(input.nextLine());
        switch (selection){
            case 1:
                accountType = "CURRENT ACCOUNT";
                acctData.put(generateAccountNumber(), createPin());
                linkAccountDetails();

                fileHandle();
                System.out.println("ACCOUNT NUMBER: "+ accountNumber);
                System.out.println("You have successfully Open a "+ accountType + "\n");
//                System.out.println("You have successfully Open a Current Account \n");
                initApp();
                break;
            case 2:
                accountType = "SAVINGS ACCOUNT";
                acctData.put(generateAccountNumber(), createPin());
                linkAccountDetails();

                fileHandle();
                System.out.println("ACCOUNT NUMBER: "+ accountNumber);
                System.out.println("You have successfully Open a "+ accountType + "\n");
                 initApp();
                 break;
//            case 3:
//                System.out.println("Would you like to perform another Transaction! ");
//                menuOption();
//                break;
            default:
                System.out.println(" Invalid Number Try Again... ");
                getAccountType();
        }

    }

//    GENERATE ACCOUNT NUMBER
    protected long id = 0;

    public String generateAccountNumber(){
        long savingsId = 1001 + id;
//            long currentId = 2001;
        id++;
        String accountNumberGen;

        accountNumberGen = "234567" + savingsId;
//        System.out.println(accountNumberGen);
        accountNumber = accountNumberGen;
        return accountNumberGen;
    }


    public int createPin (){
        System.out.println("Create pin");
         pin = Integer.parseInt(input.nextLine());
        return pin;
    }


    public void menuOption(){
        System.out.println("_________________________________");
        System.out.println(" Menu Option Account:");
        System.out.println(" Type 1 - View Account Details");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.println("________________________________ \n");

        int selection = Integer.parseInt(input.nextLine());

        switch (selection){
            case 1:
                displayAccountDetails(accountBalance);
                stayOnApp();
                break;
            case 2:
                withdrawFunds();
                stayOnApp();
                break;
            case 3:
                depositFunds();
                stayOnApp();
                break;
            case 4:
                initApp();
                System.out.println("Thank You for Banking with us! bye. \n");
                break;
            default:
                System.out.println(" Please Enter a valid number!" + "\n");
                menuOption();
        }
    }


public void loginAccount(){
    System.out.println("Enter your Account Number: ");
    setAccountNumber(input.nextLine());

    System.out.print("Enter your Security PIN: \n");
    setPinNumber(Integer.parseInt(input.nextLine()));

     String acctNumber = getAccountNumber();
     int inputPin = getPinNumber();

    if (acctData.containsKey(acctNumber) && (acctData.get(acctNumber) == pin) ){


        menuOption();
    } else{
        System.out.println(acctData);
        System.out.println("\n" + "Wrong Account Number or Account Pin " + "\n");

    loginAccount();
    }
}
//        acctBalance.put(accountNumber, currencyFormat.format(accountBalance));

    public void displayAccountDetails(double accountBalance){
//                DISPLAY METHOD
        System.out.println("********** YOUR " + acctType.get(accountNumber) + " DETAILS ******** \n");
        System.out.println("ACCOUNT NAME:" + acctName.get(accountNumber));
        System.out.println("HOME ADDRESS: " + acctAddress.get(accountNumber) + "\n");
        System.out.println("ACCOUNT NUMBER: "+ accountNumber);
        System.out.println("ACCOUNT PIN: "+ pin);
        System.out.println("Account Balance: " + currencyFormat.format(accountBalance));
        System.out.println("*********************************************** \n");
    }


//File Creation
public  void fileHandle(){
    try {
        File myObj = new File("C:\\Users\\OWNER\\Desktop\\Atm\\file.txt");
        FileWriter writeFile= new FileWriter("C:\\Users\\OWNER\\Desktop\\Atm\\file.txt",true );
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
            writeFile.write(id +". | "+ getFullName() + " | - | " + getAccountNumber() +" | - | " + getPinNumber() + " | - | " + accountType+ " \n");
            writeFile.close();
        } else {
            System.out.println("File already exists.");
            writeFile.write(id +". | "+ getFullName() + " | - | " + getAccountNumber() +" | - | " + getPinNumber() + " | - | " + accountType+ " \n");
            writeFile.close();
        }
    }catch (
    IOException e){
        System.out.println("An error Occurred");
        e.printStackTrace();
    }
}

}
