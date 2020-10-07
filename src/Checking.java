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
      if((account instanceof Checking) && super.getHolder().equals(account.getHolder())) {
      //  System.out.println("equals in checking. account is same");
        return true;
      }
      else {
       /* if(!(account instanceof Checking)) {
          System.out.println("equals in checking. account is not instance of checking");
        }
        else if(!(super.getHolder().equals(account.getHolder()))){
          System.out.println(super.getHolder().toString());
          System.out.println(account.getHolder());
          System.out.println("equals in checking. Holder is not same");
        } */
        return false;
      }
    }
	
	@Override
	public String toString() { 
      
      String name = super.getHolder().toString();
      
      String date = super.getDateOpen().toString();
      
      Double[] someVal = new Double[1];
      someVal[0] = new Double(super.getBalance());
      String formattedBalance = String.format("%.2f", someVal); 
      
      String account = "*Checking*"+ name + "* $" + formattedBalance + "*" + date + "*";
      if(this.isDirectDeposit()) {
        account = account + "direct deposit account*";
      }
      
      return account;
  }

}
