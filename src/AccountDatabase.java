
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
    else if(amount > account.getBalance())
      return 1;
    else {
      account.debit(amount);
    }
    
    return withdrawalStatus;
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
    
  public void printByDateOpen() { }
    
  public void printByLastName() { }
    
  public void printAccounts() { }
}
