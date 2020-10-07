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
	
	@Override
    public boolean equals(Account account) {
      if((account instanceof Savings) && super.getHolder().equals(account.getHolder()))
        return true;
      else 
        return false;
    }
	
	   @Override
	    public String toString() { 
	      
	      String name = super.getHolder().toString();
	      
	      String date = super.getDateOpen().toString();
	      
	      Double[] someVal = new Double[1];
	      someVal[0] = new Double(super.getBalance());
	      String formattedBalance = String.format("%.2f", someVal); 
	      
	      String account = "*Savings*"+ name + "* $" + formattedBalance + "*" + date + "*";
	      if(this.isLoyal()) {
	        account = account + "special Savings account*";
	      }
	      
	      return account;
	  }

}
