
public class AccountDatabase {
    
  private Account[] accounts;
    
  private int size;
  
  public AccountDatabase() {
    this.size = 0;
    accounts = new Account[5];
  }
    
  private int find(Account account) {}
    
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
    
  } 
    
  public boolean remove(Account account) { } //return false if account doesn’t exist
    
  public boolean deposit(Account account, double amount) { }
    //return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
    
  public int withdrawal(Account account, double amount) { }
    
  private void sortByDateOpen() { } //sort in ascending order
    
  private void sortByLastName() { } //sort in ascending order
    
  public void printByDateOpen() { }
    
  public void printByLastName() { }
    
  public void printAccounts() { }
}
