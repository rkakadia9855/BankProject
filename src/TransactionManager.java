/**
 * This class is the interface that the user will use to run this program
 * @author John Juarez, Rudra Kakadia
 */
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TransactionManager {

  /**
   * the method that will run the program
   */
  public void run() {
    String command = "";
    boolean quit = false;
    Scanner sc = new Scanner(System.in);
    String fname = "";
    String lname = "";
    Profile holder;
    Date dateOpen;
    double balance = 0.0;
    String balanceString = "";
    String dateString = "";
    boolean lastArg = false;
    StringTokenizer tokenizeDate;
    StringTokenizer tokenizeLine;
    
    AccountDatabase db = new AccountDatabase();
    
    System.out.println("Transaction processing starts.....");
    
    while(!quit) {
      String holdLine = sc.nextLine();
      tokenizeLine = new StringTokenizer(holdLine, " ");
      command = tokenizeLine.nextToken();
      if(command.equals("OC")) {
        if(tokenizeLine.countTokens() != 5) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        balanceString = tokenizeLine.nextToken();
        dateString = tokenizeLine.nextToken();
        tokenizeDate = new StringTokenizer(dateString, "/");
        int month = 0, day = 0, year = 0;
        try {
          month = Integer.parseInt(tokenizeDate.nextToken());
          day = Integer.parseInt(tokenizeDate.nextToken());
          year = Integer.parseInt(tokenizeDate.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        dateOpen = new Date(month, day, year);
        if(!(dateOpen.isValid())) {
          System.out.println(dateString + " is not a valid date!");
          continue;
        }
        String tempBool = tokenizeLine.nextToken();
        tempBool = tempBool.toLowerCase();
        if(tempBool.equals("true"))
          lastArg = true;
        else if(tempBool.equals("false"))
          lastArg = false;
        else {
          System.out.println("Input data type mismatch.");
          continue;
        }
        try {
          balance = Double.parseDouble(balanceString);
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        Checking temp = new Checking(holder, balance, dateOpen);
        temp.setDirectDeposit(lastArg);
        if(db.add(temp)) {
          System.out.println("Account opened and added to the database.");
        }
        else {
          System.out.println("Account is already in the database.");
        }
      }
      else if(command.equals("OS")) {
        if(tokenizeLine.countTokens() != 5) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        balanceString = tokenizeLine.nextToken();
        dateString = tokenizeLine.nextToken();
        tokenizeDate = new StringTokenizer(dateString, "/");
        int month = 0, day = 0, year = 0;
        try {
          month = Integer.parseInt(tokenizeDate.nextToken());
          day = Integer.parseInt(tokenizeDate.nextToken());
          year = Integer.parseInt(tokenizeDate.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        dateOpen = new Date(month, day, year);
        if(!(dateOpen.isValid())) {
          System.out.println(dateString + " is not a valid date!");
          continue;
        }
        String tempBool = tokenizeLine.nextToken();
        tempBool = tempBool.toLowerCase();
        if(tempBool.equals("true"))
          lastArg = true;
        else if(tempBool.equals("false"))
          lastArg = false;
        else {
          System.out.println("Input data type mismatch.");
          continue;
        }
        try {
          balance = Double.parseDouble(balanceString);
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        Savings temp = new Savings(holder, balance, dateOpen);
        temp.setLoyal(lastArg);
        if(db.add(temp)) {
          System.out.println("Account opened and added to the database.");
        }
        else {
          System.out.println("Account is already in the database.");
        }
      }
      else if(command.equals("OM")) {
        if(tokenizeLine.countTokens() != 4) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        balanceString = tokenizeLine.nextToken();
        dateString = tokenizeLine.nextToken();
        tokenizeDate = new StringTokenizer(dateString, "/");
        int month = 0, day = 0, year = 0;
        try {
          month = Integer.parseInt(tokenizeDate.nextToken());
          day = Integer.parseInt(tokenizeDate.nextToken());
          year = Integer.parseInt(tokenizeDate.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        dateOpen = new Date(month, day, year);
        if(!(dateOpen.isValid())) {
          System.out.println(dateString + " is not a valid date!");
          continue;
        }
        try {
          balance = Double.parseDouble(balanceString);
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        MoneyMarket temp = new MoneyMarket(holder, balance, dateOpen);
        if(db.add(temp)) {
          System.out.println("Account opened and added to the database.");
        }
        else {
          System.out.println("Account is already in the database.");
        }
      }
      else if(command.equals("CC")) {
        if(tokenizeLine.countTokens() != 2) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        boolean accountRemoved = db.remove(new Checking(holder, 0.0, null));
        if(!accountRemoved) {
          System.out.println("Account does not exist.");
        }
        else {
          System.out.println("Account closed and removed from the database.");
        }
      }
      else if(command.equals("CS")) {
        if(tokenizeLine.countTokens() != 2) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        boolean accountRemoved = db.remove(new Savings(holder, 0.0, null));
        if(!accountRemoved) {
          System.out.println("Account does not exist.");
        }
        else {
          System.out.println("Account closed and removed from the database.");
        }
      }
      else if(command.equals("CM")) {
        if(tokenizeLine.countTokens() != 2) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        boolean accountRemoved = db.remove(new MoneyMarket(holder, 0.0, null));
        if(!accountRemoved) {
          System.out.println("Account does not exist.");
        }
        else {
          System.out.println("Account closed and removed from the database.");
        }
      }
      else if(command.equals("DC")) {
        if(tokenizeLine.countTokens() != 3) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        double amount = 0.0;
        try {
          amount = Double.parseDouble(tokenizeLine.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        boolean depositSuccessful = db.deposit(new Checking(holder, 0, null), amount);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        if(depositSuccessful) {
          System.out.println(formatter.format(amount) + " deposited to account.");
        }
        else {
          System.out.println("Account does not exist.");
        }
      }
      else if(command.equals("DS")) {
        if(tokenizeLine.countTokens() != 3) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        double amount = 0.0;
        try {
          amount = Double.parseDouble(tokenizeLine.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        boolean depositSuccessful = db.deposit(new Savings(holder, 0, null), amount);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        if(depositSuccessful) {
          System.out.println(formatter.format(amount) + " deposited to account.");
        }
        else {
          System.out.println("Account does not exist.");
        }
      }
      else if(command.equals("DM")) {
        if(tokenizeLine.countTokens() != 3) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        double amount = 0.0;
        try {
          amount = Double.parseDouble(tokenizeLine.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        boolean depositSuccessful = db.deposit(new MoneyMarket(holder, 0, null), amount);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        if(depositSuccessful) {
          System.out.println(formatter.format(amount) + " deposited to account.");
        }
        else {
          System.out.println("Account does not exist.");
        }
      }
      else if(command.equals("WC")) {
        if(tokenizeLine.countTokens() != 3) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        double amount = 0.0;
        try {
          amount = Double.parseDouble(tokenizeLine.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        int withdrawn = db.withdrawal(new Checking(holder, 0, null), amount);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        if(withdrawn == 0) {
          System.out.println(formatter.format(amount) + " withdrawn from account.");
        }
        else if(withdrawn == -1) {
          System.out.println("Account does not exist.");
        }
        else if(withdrawn == 1) {
          System.out.println("Insufficient funds.");
        }
      }
      else if(command.equals("WS")) {
        if(tokenizeLine.countTokens() != 3) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        double amount = 0.0;
        try {
          amount = Double.parseDouble(tokenizeLine.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        int withdrawn = db.withdrawal(new Savings(holder, 0, null), amount);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        if(withdrawn == 0) {
          System.out.println(formatter.format(amount) + " withdrawn from account.");
        }
        else if(withdrawn == -1) {
          System.out.println("Account does not exist.");
        }
        else if(withdrawn == 1) {
          System.out.println("Insufficient funds.");
        }
      }
      else if(command.equals("WM")) {
        if(tokenizeLine.countTokens() != 3) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        fname = tokenizeLine.nextToken();
        lname = tokenizeLine.nextToken();
        holder = new Profile(fname, lname);
        double amount = 0.0;
        try {
          amount = Double.parseDouble(tokenizeLine.nextToken());
        }
        catch(NumberFormatException e) {
          System.out.println("Input data type mismatch.");
          continue;
        }
        int withdrawn = db.withdrawal(new MoneyMarket(holder, 0, null), amount);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        if(withdrawn == 0) {
          System.out.println(formatter.format(amount) + " withdrawn from account.");
        }
        else if(withdrawn == -1) {
          System.out.println("Account does not exist.");
        }
        else if(withdrawn == 1) {
          System.out.println("Insufficient funds.");
        }
      }
      else if(command.equals("PA")) {
        db.printAccounts();
      }
      else if(command.equals("PD")) {
       db.printByDateOpen(); 
      }
      else if(command.equals("PN")) {
        db.printByLastName();
      }
      else if(command.equals("Q")) {
        System.out.println("Transaction processing completed.");
        quit = true;
      }
      else {
        System.out.println("Command \'"+command+"' not supported!");
        continue;
      }
    }
    sc.close();
  }
}
