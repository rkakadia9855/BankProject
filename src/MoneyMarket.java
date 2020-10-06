public class MoneyMarket extends Account {
  
  private int withdrawals;

	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		
	}
	
	public int getWithdrawals() {
		return withdrawals;
	}
	public void setWithdrawals(int withdrawals) {
		this.withdrawals = withdrawals;
	}

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
      if((account instanceof MoneyMarket) && super.getHolder().equals(account.getHolder()) &&
          (super.getDateOpen().compareTo(account.getDateOpen()) == 0))
        return true;
      else 
        return false;
    }

}
