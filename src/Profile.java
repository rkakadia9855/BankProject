
public class Profile {
    private String fname;
    private String lname;
    
    public Profile(String fname, String lname) {
      this.fname = fname;
      this.lname = lname;
    }
    
    public String getFName() {
      return this.fname;
    }
    
    public String getLName() {
      return this.lname;
    }
    
    public String toString() {
      return (fname + " " +lname);
    }

    public boolean equals(Profile holder) {
      if(this.fname.equals(holder.fname) && this.lname.equals(holder.lname)) {
        //System.out.println("equals in holder: holder is same");
        return true;
      }
      else {
       /* if(this.fname.equals(holder.fname)) {
          System.out.println("equals in holder: fname diff");
        }
        else if(this.lname.equals(holder.lname)) {
          System.out.println("equals in holder: lname is diff");
        }
        else {
          System.out.println("no idea");
        } */
        return false;
      }
    }
}
