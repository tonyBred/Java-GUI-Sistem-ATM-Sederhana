package ATM;

// Account.java
// Represents a bank account

public class Account {
   public int accountNumber; // account number
   public int pin; // PIN for authentication
   public double availableBalance; // funds available for withdrawal

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
   }

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN) {
      if (userPIN == pin) {
         return true;
      }
      else {
         return false;
      }
   } 

   // returns available balance
   public double getAvailableBalance() {
      return availableBalance;
   } 
   
   // returns available balance
   public int getPin() {
      return pin;
   } 

   // credits an amount to the account
   public void credit(double amount) {
        setAvailableBalance(availableBalance + amount); // add to total balance
   }

   // debits an amount from the account
   public void debit(double amount) {
        setAvailableBalance(availableBalance - amount); // subtract from available balance
   }

   // returns account number
   public int getAccountNumber() {
      return accountNumber;  
   }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
} 



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/