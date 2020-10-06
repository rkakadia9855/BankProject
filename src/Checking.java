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
		double interest = 0.005/12;
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
      if((account instanceof Checking) && super.getHolder().equals(account.getHolder()) &&
          (super.getDateOpen().compareTo(account.getDateOpen()) == 0))
        return true;
      else 
        return false;
    }

}
