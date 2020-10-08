public class Checking extends Account {
  
  private boolean directDeposit;
	
	public Checking(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
	}
	
	public boolean isDirectDeposit() {
		return directDeposit;
	}
	
	public void setDirectDeposit(boolean directDeposit) {
		this.directDeposit = directDeposit;
	}

	@Override 
	public double monthlyInterest() {
		double interest = 0.0005/12;
		return interest;
	}

	@Override
	public double monthlyFee() {
		double fee = 0;
		if(!directDeposit || super.getBalance() < 1500) {
			fee = 25;
		}
		return fee;
	}
	
	@Override
	public boolean equals(Account account) {
      if((account instanceof Checking) && super.equals(account)) {
        return true;
      }
      else {
        return false;
      }
    }
	
	@Override
	public String toString() { 

      String account = "*Checking*"+ super.toString();
      if(this.isDirectDeposit()) {
        account = account + "*direct deposit account*";
      }
      
      return account;
  }

}
