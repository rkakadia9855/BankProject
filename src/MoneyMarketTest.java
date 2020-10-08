/**
 * the junit test case for money market class
 * @author John Juarez, Rudra Kakadia
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class MoneyMarketTest {

  @Test
  /**
   * tests the monthly interest rate
   */
  public void testMonthlyInterest() {
    MoneyMarket m1 = new MoneyMarket(new Profile("Rudra", "Kakadia"), 500, new Date(11, 15, 2020));
    double actualInterest = 0.0065/12;
    boolean correctInterest = (m1.monthlyInterest() == actualInterest);
    assertTrue(correctInterest);
  }

  @Test
  /**
   * tests the monthly fee
   */
  public void testMonthlyFee() {
    MoneyMarket m1 = new MoneyMarket(new Profile("Rudra", "Kakadia"), 500, new Date(11, 15, 2020));
    MoneyMarket m2 = new MoneyMarket(new Profile("John", "Juarez"), 3000, new Date(11, 15, 2020));
    MoneyMarket m3 = new MoneyMarket(new Profile("Some", "Person"), 5000, new Date(11, 15, 2020));
    MoneyMarket m4 = new MoneyMarket(new Profile("Other", "Person"), 200, new Date(11, 15, 2020));
    m3.setWithdrawals(7);
    m4.setWithdrawals(10);
    double fee = 12.00;
    double waived = 0.00;
    assertTrue((m1.monthlyFee() == fee));
    assertTrue((m2.monthlyFee() == waived));
    assertTrue((m3.monthlyFee() == fee));
    assertTrue((m4.monthlyFee() == fee));
  }

}
