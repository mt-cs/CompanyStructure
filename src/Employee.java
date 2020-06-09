public abstract class Employee {
    String name;
    double baseSalary;
    int ID;
    private int countID;
    Employee manager;
    String status;
    int headcount;


    /**
     * Should construct a new employee object and take in two parameters,
     * @param Name the name of the user
     * @param BaseSalary their base salary
     */
    public Employee(String Name, double BaseSalary){
        name = Name;
        baseSalary = BaseSalary;
        countID++;
        ID = countID;
    }

    /**
     * @return baseSalary, the employee's current salary
     */
    public double getBaseSalary(){
        return baseSalary;
    }

    /**
     * @return name, the employee's current salary
     */
    public String getName(){
        return name;
    }

    /**
     * The ID should be issued on behalf of the employee at the time they are constructed.
     * The first ever employee should have an ID of "1", the second "2" and so on
     * @return ID
     */
    public int getEmployeeID(){
        return ID;
    }

    /**
     * Should return a reference to the Employee object that represents this employee's manager
     * @return manager
     */
    public Employee getManager(){
        return manager;
    }

    public void setManager(Employee manager){ this.manager=manager; }
    /**
     * @param other another Employee
     * @return true if the two employee IDs are the same, false otherwise
     */
    public boolean equals(Employee other){
        return this.getEmployeeID() == other.getEmployeeID();
    }

    /**
     * @return a String representation of the employee that is a combination of
     * their id followed by their name.
     */
    public String toString(){
        return getEmployeeID() + " " + getName();
    }

    /**
     * Should return a String representation of that Employee's current status.
     * This will be different for every subclass of Employee
     * @return status
     */
    public String employeeStatus(){
        return status;
    }
}
