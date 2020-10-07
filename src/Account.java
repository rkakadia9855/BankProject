public abstract class Account {
  
    private Profile holder;
	private double balance;
	private Date dateOpen;
	
	public Account(Profile holder, double balance,Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Profile getHolder() {
	  return this.holder;
	}
	
	public Date getDateOpen() {
	  return this.dateOpen;
	}
	
	public void debit(double amount) { 
		balance -= amount;
	} //decrease the balance by amount
	
	public void credit(double amount) {
		balance += amount;
	} //increase the balance by amount
	
	public String toString() { 
		
		String name = holder.toString();
		
		String date = dateOpen.toString();
		
		Double[] someVal = new Double[1];
	    someVal[0] = new Double(balance);
	    String formattedBalance = String.format("%.2f", someVal); 
	    
	    String account = "*"+ name + "* " + formattedBalance + "*" + date + "*";
		
		return account;
	}

	public boolean equals(Account account) {
	  if((account instanceof Account) && (this.holder.equals(account.getHolder())))
	    return true;
	  else 
	    return false;
	}
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
  
}
