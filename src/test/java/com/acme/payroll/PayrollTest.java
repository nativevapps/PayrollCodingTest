package com.acme.payroll;

import com.acme.payroll.model.Salary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.acme.payroll.TestUtils.inputStreamToString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PayrollTest {

    private static final String INPUT_FILE = readJSON("/employees.json");

    private Payroll payroll;

    @Before
    public void setup() {
        payroll =  new Payroll();
    }

    @After
    public void teardown() {
    }

    @Test
    public void testInputFile() {
        assertNotNull(INPUT_FILE);
        assertTrue(INPUT_FILE.contains("Mary"));
    }

    @Test public void testPayrollAcceptance() {
        List<Salary> salaries = payroll.getPayroll(INPUT_FILE);
        assertNotNull(salaries);
        assertEquals(6, salaries.size());

        for (Salary salary : salaries) {
            System.out.println(salary.toString());
            validateOutput(salary);
        }
    }

    private void validateOutput(Salary salary) {
        if (salary.name.contains("Joan")) {
            assertEquals("USD 2235.51", salary.monthlySalary);
        }
        if (salary.name.contains("Dan")) {
            assertEquals("AUD 2083.33'", salary.monthlySalary);
        }
        if (salary.name.contains("Billy")) {
            assertEquals("USD 2235.51", salary.monthlySalary);
        }
        if (salary.name.contains("Jenny")) {
            assertEquals("AUD 1250.00", salary.monthlySalary);
        }
        if (salary.name.contains("Jenny")) {
            assertEquals("AUD 1250.00", salary.monthlySalary);
        }
        if (salary.name.contains("Mary")) {
            assertEquals("SGD 3482.35'", salary.monthlySalary);
        }
    }

    private static String readJSON(String path) {
        return inputStreamToString(PayrollTest.class.getResourceAsStream(path));
    }
}
