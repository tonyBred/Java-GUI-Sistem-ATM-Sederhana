
package ATM;
// BankDatabase.java
// Represents the bank account information database 

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class BankDatabase {
   public Account[] accounts; // array of Accounts
   
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase() throws IOException {
        try{
            Reader reader = Files.newBufferedReader(Paths.get("account.json"));
            LinkedList<Account>listAkun = new Gson().fromJson(reader, new TypeToken<LinkedList<Account>>() {}.getType()); 
            
            accounts = new Account[listAkun.size()];
            
            for(int i=0;i<listAkun.size();i++){
                accounts[i] = new Account(listAkun.get(i).getAccountNumber(), listAkun.get(i).getPin(), listAkun.get(i).getAvailableBalance());
            }
            
        }catch(FileNotFoundException ex){
            ex.getStackTrace();
            throw new IOException("Unrecoverable client exception encountered",ex);
        }
   }
   
   // retrieve Account object containing specified account number
   public Account getAccount(int accountNumber) {
      // loop through accounts searching for matching account number
      for (Account currentAccount : accounts) {
         // return current account if match found
         if (currentAccount.getAccountNumber() == accountNumber) {
            return currentAccount;
         }
      } 

      return null; // if no matching account was found, return null
   } 

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser(int userAccountNumber, int userPIN) {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount(userAccountNumber);

      // if account exists, return result of Account method validatePIN
      if (userAccount != null) {
         return userAccount.validatePIN(userPIN);
      }
      else {
         return false; // account number not found, so return false
      }
   } 

   // return available balance of Account with specified account number
   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } 

   // credit an amount to Account with specified account number
   public void credit(int userAccountNumber, double amount) throws IOException {
       getAccount(userAccountNumber).credit(amount);
       
       try (Writer writer = new FileWriter("account.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accounts, writer);
        }
       
   }

   // debit an amount from Account with specified account number
   public void debit(int userAccountNumber, double amount) throws IOException {
        getAccount(userAccountNumber).debit(amount);
       
       try (Writer writer = new FileWriter("account.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accounts, writer);
        }

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