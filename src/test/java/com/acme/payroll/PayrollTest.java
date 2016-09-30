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
        }
    }

    private static String readJSON(String path) {
        return inputStreamToString(PayrollTest.class.getResourceAsStream(path));
    }
}
