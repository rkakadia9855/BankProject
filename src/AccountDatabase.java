
public class AccountDatabase {
    
  private Account[] accounts;
    
  private int size;
  
  public AccountDatabase() {
    this.size = 0;
    accounts = new Account[5];
  }
    
  private int find(Account account) {
    
    int i = 0;
    int index = -1;
    
    for(i = 0; i < size; i++) {
      if(accounts[i].equals(account)) {
        return i;
      }
    }
    
    return index;
  }
    
  private void grow() { 
    Account[] temp = new Account[accounts.length + 5];
    int i = 0;
    for(i = 0; i < size; i++) {
      temp[i] = accounts[i];
    }
    accounts = temp;
  }
    
  //return false if account exists
  public boolean add(Account account) { 
    
    boolean canAddAccount = true;
    int i = 0;
    
    for(i = 0; i < size; i++) {
      if(account.equals(accounts[i])) {
        canAddAccount = false;
        return canAddAccount;
      }
    }

    if(size < accounts.length) {
      accounts[size] = account;
      size++;
    }
    
    return canAddAccount;
  } 
    
  //return false if account doesn’t exist
  public boolean remove(Account account) {
    boolean accountRemoved = false;
    int i = 0;
    
    for(i = 0; i < size; i++) {
      if(account.equals(accounts[i])) {
        accountRemoved = true;
        accounts[i] = accounts[size - 1];
        accounts[size - 1] = null;
        size--;
        return accountRemoved;
      }
    }
    
    return accountRemoved;
  }
  
  public boolean deposit(Account account, double amount) { 
    boolean depositSuccessful = false;
    int accountIndex = find(account);
    if(accountIndex != -1) {
      accounts[accountIndex].credit(amount);
      depositSuccessful = true;
    }
    return depositSuccessful;
  }
    
//return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
  public int withdrawal(Account account, double amount) {
    int withdrawalStatus = 0;
    int accountIndex = find(account);
    if(accountIndex == -1)
      return accountIndex;
    else if(amount > accounts[accountIndex].getBalance()) {
      return 1;
    }
    else {
      accounts[accountIndex].debit(amount);
    }
    
    return withdrawalStatus;
  }
  
  private double calcInterest(Account account) {
    double interest = 0.0;
    interest = account.monthlyInterest() * account.getBalance();
    return interest;
  }
  
  private double newBalance(Account account) {
    double updatedBalance = 0.0;
    updatedBalance = account.getBalance() + this.calcInterest(account);
    updatedBalance = updatedBalance - account.monthlyFee();
    account.setBalance(updatedBalance);
    return updatedBalance;
  }
    
//sort in ascending order
  private void sortByDateOpen() { 
    int n = accounts.length; 
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
          if(accounts[j] != null && accounts[j+1] != null) {
            if (accounts[j].getDateOpen().compareTo(accounts[j+1].getDateOpen()) > 1) { 
                Account temp = accounts[j]; 
                accounts[j] = accounts[j+1]; 
                accounts[j+1] = temp; 
            } 
          }
        }
    }
  } 
    
//sort in ascending order
  private void sortByLastName() { 
    int n = accounts.length; 
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
          if(accounts[j] != null && accounts[j+1] != null) {
            if (accounts[j].getHolder().getLName().compareTo(
                accounts[j+1].getHolder().getLName()) > 1) { 
                Account temp = accounts[j]; 
                accounts[j] = accounts[j+1]; 
                accounts[j+1] = temp; 
            } 
          }
        }
    }
  } 
    
  public void printByDateOpen() {
    if(size != 0) {
      System.out.println("--Printing statements by date opened--");
      sortByDateOpen();
      for(int i = 0; i < size; i++) {
        System.out.println();
        System.out.println(accounts[i].toString());
        System.out.println("-interest: $ "+this.calcInterest(accounts[i]));
        System.out.println("-fee: $ "+ accounts[i].monthlyFee());
        System.out.println("-new balance: $ "+this.newBalance(accounts[i]));
      }
      System.out.println("--end of printing--");
    }
    else {
      System.out.println("Database is empty.");
    }
  }
    
  public void printByLastName() { 
    if(size != 0) {
      System.out.println("--Printing statements by last name--");
      sortByLastName();
      for(int i = 0; i < size; i++) {
        System.out.println(accounts[i].toString());
        System.out.println("-interest: $ "+this.calcInterest(accounts[i]));
        System.out.println("-fee: $ "+ accounts[i].monthlyFee());
        System.out.println("-new balance: $ "+this.newBalance(accounts[i]));
      }
      System.out.println("--end of printing--");
    }
    else {
      System.out.println("Database is empty.");
    }
  }
    
  public void printAccounts() { 
    if(size != 0) {
      System.out.println("--Listing accounts in the database--");
      for(int i = 0; i < size; i++) {
        System.out.println(accounts[i].toString());
      }
      System.out.println("--end of listing--");
    }
    else {
      System.out.println("Database is empty.");
    }
  }
}
