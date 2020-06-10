public class Accountant extends BusinessEmployee {
    private TechnicalLead teamSupported;
    /**
     * Should start with a bonus budget of 0 and no team they are officially supporting
     * @param name employee's name
     */
    public Accountant(String name){
        super(name);
        budget=0;
    }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }

    /**
     * The Accountant's bonus budget should be updated to be the total of each SoftwareEngineer's
     * base salary that reports to that TechnicalLead plus 10%.
     * @param lead technical lead obj ref
     */
    public void supportTeam(TechnicalLead lead){
        teamSupported=lead;
        for (int i=0; i<lead.team.size(); i++){
            budget+=lead.team.get(i).getBaseSalary()*1.1;
        }
    }

    /**
     * Check if there is still enough room in the budget for the suggested bonus amount.
     * @param bonus a suggested bonus amount
     * @return true/false
     */
    public boolean canApproveBonus(double bonus){
        if (bonus<=getBonusBudget()){
            return true;
        } else {
            System.out.print("Not enough budget.");
            return false;
        }
    }

    @Override
    public String employeeStatus(){
        return super.toString()+" with a budget of "+ getBonusBudget() +" is supporting "+ this.getTeamSupported();
    }
}
