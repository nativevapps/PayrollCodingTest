package com.acme.payroll.model;

public class EmployeePayment {

    public String fullName;
    public String displayAmount;

    @Override
    public String toString() {
        return "EmployeePayment{" +
                "fullName='" + fullName + '\'' +
                ", displayAmount='" + displayAmount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeePayment employeePayment = (EmployeePayment) o;

        if (fullName != null ? !fullName.equals(employeePayment.fullName) : employeePayment.fullName != null) return false;
        return displayAmount != null ? displayAmount.equals(employeePayment.displayAmount) : employeePayment.displayAmount == null;

    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (displayAmount != null ? displayAmount.hashCode() : 0);
        return result;
    }
}
