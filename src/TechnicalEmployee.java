public abstract class TechnicalEmployee extends Employee {
    int checkIn;
    /**
     * Has a default base salary of 75000
     * @param name Employee's name
     */
    public TechnicalEmployee(String name){
        super(name,75000.0);
    }

    @Override
    public String employeeStatus(){
        return super.toString()+" has "+checkIn+" successful check ins\n";
    }
}
