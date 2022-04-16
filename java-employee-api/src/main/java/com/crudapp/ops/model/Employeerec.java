package com.crudapp.ops.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_table")
public class Employeerec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "employee_id") 
    private String employeeID;

    @Column(name = "employee_fname")
    private String employeeFirstName;

    @Column(name = "employee_lname")
    private String employeeLastName;

    public Employeerec() {
    }

    public Employeerec(String employeeID, String employeeFirstName, String employeeLastName) {
       this.employeeID = employeeID;
       this.employeeFirstName = employeeFirstName;
       this.employeeLastName = employeeLastName;
    }

    public long getId() {
	return id;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;  
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    @Override
    public String toString() {
        return "[id="
            + id
            + ",employeeid="
            + employeeID
            + ", employeefirstname="
            + employeeFirstName
            + ", employeelastname="
            + employeeLastName 
            + "]"; 
    }

}
