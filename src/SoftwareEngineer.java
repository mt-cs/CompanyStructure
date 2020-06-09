public class SoftwareEngineer extends TechnicalEmployee{
    public boolean codeAccess;
    /**
     * Should start without access to code and with 0 code check ins
     * @param name of employee from super
     */
    public SoftwareEngineer(String name){
        super(name);
    }

    /**
     * Should return whether or not this SoftwareEngineer has access to make changes to the code base
     * @return codeAccess
     */
    public boolean getCodeAccess(){
        return codeAccess;
    }

    /**
     * Should allow an external piece of code to update
     * the SoftwareEngineer's code privileges to either true or false
     */
    public void setCodeAccess(boolean access){
        codeAccess = access;
    }

    /**
     * Should return the current count of how many times this
     * SoftwareEngineer has successfully checked in code
     * @return
     */
    public int getSuccessfulCheckIns(){
        return checkIn;
    }

    /**
     * Should check if this SoftwareEngineer's manager approves of their check in.
     * If the check in is approved their successful checkin count should be increased
     * and the method should return "true".
     * If the manager does not approve the check in the SoftwareEngineer's code access
     * should be changed to false and the method should return "false"
     * @return
     */
    public boolean checkInCode(){
        TechnicalLead manager = (TechnicalLead)this.getManager();
        if (manager.approveCheckIn(this)){
            this.checkIn++;
            return true;
        } else {
            codeAccess=false;
            return false;
        }
    }



}
