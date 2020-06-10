import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    private ArrayList<Accountant> directReport = new ArrayList<>();

    /**
     * The TechnicalLead's base salary should be 1.3 times that of a TechnicalEmployee.
     * TechnicalLeads should have a default head count of 10.
     * @param name employee's name
     */
    public BusinessLead(String name){
        super(name);
        baseSalary*=2.0;
        headCount=10;
    }

    /**
     * Return true if the number of direct reports this manager has is less than their headcount.
     */
    public boolean hasHeadCount(){
        return directReport.size() < headCount;
    }

    /**
     * @param e reference to an Accountant object
     * @param supportTeam Technical Lead
     * @return true/false
     */
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            directReport.add(e);
            budget+=(e.baseSalary*1.1);
            e.supportTeam(supportTeam);
            e.manager=this;
            return true;
        } else {return false;}
    }

    /**
     * Should check if the bonus amount requested would fit in current BusinessLead's budget.
     * If it is, that employee should get that bonus, the BusinessLeader's budget should be
     * deducted and true should be returned. False should be returned otherwise
     * @param e employee's name
     * @param bonus bonus amount requested
     * @return true/false
     */
    public boolean requestBonus(Employee e, double bonus){
        if (bonus<=budget){
            e.bonus+=bonus;
            budget-=bonus;
            return true;
        }
        return false;
    }

    /**
     * This function should look through the Accountants the BusinessLead manages,
     * and if any of them are supporting a the TechnicalLead that is the manager of the Employee
     * passed in then the Accountant's budget should be consulted to see if the bonus could be afforded.
     * If the team can afford the bonus it should be rewarded and true returned, false otherwise
     * @param e employee's name
     * @param bonus requested
     * @return true/false
     */
    public boolean approveBonus(Employee e, double bonus){
        for (Accountant accountant : directReport) {
            if (accountant.equals(e.getManager()) && accountant.canApproveBonus(bonus)) {
                return true;
            }
        }
        return false;
    }

    public String getTeamStatus() {
        StringBuilder s = new StringBuilder(employeeStatus());
        if (directReport.size() == 0) {
            s.append(" and no direct reports yet\n");
        } else {
            s.append(" and is managing:\n");
            for (int i = 0; i < directReport.size(); i++) {
                int j = i + 1;
                s.append("\t").append(j).append(". ").append(directReport.get(i).employeeStatus());
            }
        }
        return s.toString();
    }
}
