import static org.junit.Assert.*;
import org.junit.Test;

public class CheckingTest {

  @Test
  public void testMonthlyInterest() {
    Checking c1 = new Checking(new Profile("John", "Juarez"), 500, new Date(11, 15, 2020));
    boolean correctInterest = (c1.monthlyInterest() == (0.0005/12));
    assertTrue(correctInterest);
  }

  @Test
  public void testMonthlyFee() {
    Checking m1 = new Checking(new Profile("Rudra", "Kakadia"), 500, new Date(11, 15, 2020));
    Checking m2 = new Checking(new Profile("John", "Juarez"), 1600, new Date(11, 15, 2020));
    Checking m3 = new Checking(new Profile("Some", "Person"), 200, new Date(11, 15, 2020));
    Checking m4 = new Checking(new Profile("Other", "Person"), 2000, new Date(11, 15, 2020));
    m3.setDirectDeposit(true);
    m4.setDirectDeposit(true);
    double fee = 25.00;
    double waived = 0.00;
    assertTrue((m1.monthlyFee() == fee));
    assertTrue((m2.monthlyFee() == waived));
    assertTrue((m3.monthlyFee() == waived));
    assertTrue((m4.monthlyFee() == waived));
  }

}
