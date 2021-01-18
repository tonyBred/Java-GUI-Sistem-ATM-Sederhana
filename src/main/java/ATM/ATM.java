 
package ATM;

import java.io.IOException;

public class ATM {
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private BankDatabase bankDatabase; // account information database

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT  = 3; 
   private static final int EXIT = 4;

   // no-argument ATM constructor initializes instance variables
   public ATM() throws IOException{
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
   }

   // attempts to authenticate user against database
   public boolean authenticateUser(int accountNumber, int pin) {
      
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser(accountNumber, pin);
      
      // check whether authentication succeeded
      if (userAuthenticated) {
         currentAccountNumber = accountNumber; // save user's account #
         return true;
      } 
      else {
         return false;
      } 
   } 
     
   
   // return account number 
   public int getAccountNumber() {
      return currentAccountNumber; 
   } 

   // return reference to bank database
   public BankDatabase getBankDatabase() {
      return bankDatabase;
   }
   
   public CashDispenser getCashDispenser(){
       return cashDispenser;
   }
   
}

 