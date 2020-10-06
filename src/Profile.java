
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
    
    public boolean equals(String fname, String lname) {
      if(this.fname == fname && this.lname == lname)
        return true;
      else 
        return false;
    }
}
