package com.acme.payroll.model;

public class Salary {

    public String name;
    public String monthlySalary;

    @Override
    public String toString() {
        return "Salary{" +
                "name='" + name + '\'' +
                ", monthlySalary='" + monthlySalary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salary salary = (Salary) o;

        if (name != null ? !name.equals(salary.name) : salary.name != null) return false;
        return monthlySalary != null ? monthlySalary.equals(salary.monthlySalary) : salary.monthlySalary == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (monthlySalary != null ? monthlySalary.hashCode() : 0);
        return result;
    }
}
