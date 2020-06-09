public class BusinessEmployee extends Employee{
    int bonusBudget;
    /**
     * Has a default base salary of 50000
     * @param name Employee's name
     */
    public BusinessEmployee(String name){
        super(name,50000);
        bonusBudget=0;
    }

    public double getBonusBudget(){
        return bonusBudget;
    }

    /**
     * Should return a String representation of this BusinessEmployee that includes their ID, name
     * and the size of their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
     */
    @Override
    public String employeeStatus(){
        return super.toString()+" with a budget of "+String.format("%.2f",bonusBudget);
    }
}
