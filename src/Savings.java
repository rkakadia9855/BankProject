public class Savings extends Account {
  
  private boolean isLoyal;

	public Savings(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		
	}

	
	public boolean isLoyal() {
		return isLoyal;
	}
	
	public void setLoyal(boolean isLoyal) {
		this.isLoyal = isLoyal;
	}

	@Override
	public double monthlyInterest() {
		double interest = 0;
		
		if(isLoyal) {
			interest = 0.0035/12;
		}else {
			interest = 0.0025/12;
		}
		return interest;
	}

	@Override
	public double monthlyFee() {
		double fee = 0;
		if(super.getBalance() < 300) {
			fee = 5;
		}
		return fee;
	}

}
