import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee{
    public ArrayList<SoftwareEngineer> team = new ArrayList<>();

    /**
     * The TechnicalLead's base salary should be 1.3 times that of a TechnicalEmployee.
     * TechnicalLeads should have a default head count of 4.
     * @param name employee's name
     */
    public TechnicalLead(String name){
        super(name);
        this.baseSalary *= 1.3;
        headcount=4;
    }

    /**
     * Return true if the number of direct reports this manager has is less than their headcount.
     */
    public boolean hasHeadCount(){
        if(team.size()<headcount){
            return true;
        } else { return false;}
    }

    /**
     *  If the TechnicalLead has head count left should add this employee to their list of direct reports.
     *  If the employee is successfully added to the TechnicalLead's direct reports
     *  true should be returned, false should be returned otherwise
     * @param e the reference to a SoftwareEngineer object
     */
    public boolean addReport(SoftwareEngineer e){
        if (hasHeadCount()){
            team.add(e);
            e.setManager(this);
            return true;
        } else {return false;}
    }

    /**
     * See if the employee passed in does report to this manager
     * and if their code access is currently set to "true".
     * @param e the reference to a SoftwareEngineer object
     * @return true/false
     */
    public boolean approveCheckIn(SoftwareEngineer e){
        if (e.getManager().equals(this)&& e.getCodeAccess()){
            return true;
        } else{return false;}
    }

    /**
     * Check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead.
     * @param e the reference to an Employee object
     * @param bonus
     * @return true/false
     */
//    public boolean requestBonus(Employee e, double bonus){
//
//    }

    /**
     * return a String that gives insight into this Manager and all their direct reports.
     */
    public String getTeamStatus(){
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }

    }

}
