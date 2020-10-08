public class MoneyMarket extends Account {
  
  private int withdrawals;

	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		this.withdrawals = 0;
	}
	
	public int getWithdrawals() {
		return withdrawals;
	}
	public void setWithdrawals(int withdrawals) {
		this.withdrawals = withdrawals;
	}
	
	@Override
	public void debit(double amount) { 
      super.setBalance((super.getBalance() - amount));
      this.withdrawals++;
  } //decrease the balance by amount

	@Override
	public double monthlyInterest() {
		double interest = 0.0065/12;
		return interest;
	}

	@Override
	public double monthlyFee() {
		double fee = 0;
		if(super.getBalance() < 2500 || withdrawals > 6 ) {
			fee = 12;
		}
		return fee;
	}

	@Override
    public boolean equals(Account account) {
      if((account instanceof MoneyMarket) && super.equals(account))
        return true;
      else 
        return false;
    }
	
	@Override
    public String toString() { 
      String account = "*Money Market*"+ super.toString() + "*";
      account = account + this.getWithdrawals() + " withdrawals*";
      
      return account;
    }

}
