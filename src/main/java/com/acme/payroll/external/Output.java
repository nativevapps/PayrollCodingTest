package com.acme.payroll.external;

import com.acme.payroll.model.EmployeePayment;

import java.util.List;

public interface Output {

    void presentPayroll(List<EmployeePayment> payments);
}
