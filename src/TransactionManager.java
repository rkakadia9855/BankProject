import java.util.*;

public class TransactionManager {

  public void run() {
    String command = "";
    boolean quit = false;
    Scanner sc = new Scanner(System.in);
    
    while(!quit) {
      if(sc.hasNext()) {
        command = sc.next();
      }
      if(command.equals("OC")) {
        
      }
      else if(command.equals("OS")) {
        
      }
      else if(command.equals("OM")) {
        
      }
      else if(command.equals("CC")) {
        
      }
      else if(command.equals("CS")) {
              
      }
      else if(command.equals("CM")) {
        
      }
      else if(command.equals("DC")) {
              
            }
      else if(command.equals("DS")) {
        
      }
      else if(command.equals("DM")) {
        
      }
      else if(command.equals("WC")) {
              
      }
      else if(command.equals("WS")) {
        
      }
      else if(command.equals("WM")) {
        
      }
      else if(command.equals("PA")) {
        
      }
      else if(command.equals("PD")) {
        
      }
      else if(command.equals("PN")) {
        
      }
      else if(command.equals("Q")) {
        System.out.println("Transaction processing completed.");
        quit = true;
      }
      else {
        System.out.println("Command \'"+command+"' not supported!");
        sc.nextLine();
      }
    }
  }
}
