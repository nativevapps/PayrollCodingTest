package com.acme.payroll.external;

import com.acme.payroll.model.Salary;

import java.util.List;

public interface Output {

    void presentPayroll(List<Salary> salaries);
}
