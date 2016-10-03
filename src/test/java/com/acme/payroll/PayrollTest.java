package com.acme.payroll;

import com.acme.payroll.external.JsonFileInput;
import com.acme.payroll.external.Output;
import com.acme.payroll.model.Salary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.acme.payroll.utils.JsonUtils.inputStreamToString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PayrollTest {

    private static final String INPUT_FILE = readJSON("/employees.json");

    private Payroll payroll;
    private Output mockOutput;

    @Captor
    ArgumentCaptor<ArrayList<Salary>> captor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        payroll = new Payroll();
        mockOutput = mock(Output.class);
    }

    @After
    public void teardown() {
    }

    @Test
    public void testInputFile() {
        assertNotNull(INPUT_FILE);
        assertTrue(INPUT_FILE.contains("Mary"));
    }

    @Test
    public void testPayrollAcceptance() {
        payroll.getPayroll(new JsonFileInput(), mockOutput);

        verify(mockOutput, timeout(300)).presentPayroll(captor.capture());

        List<Salary> salaries = captor.getAllValues().get(0);
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
            assertEquals("AUD 2083.33", salary.monthlySalary);
        }
        if (salary.name.contains("Billy")) {
            assertEquals("AUD 1250.00", salary.monthlySalary);
        }
        if (salary.name.contains("Jenny")) {
            assertEquals("AUD 1250.00", salary.monthlySalary);
        }
        if (salary.name.contains("Peter")) {
            assertEquals("AUD 2916.67", salary.monthlySalary);
        }
        if (salary.name.contains("Mary")) {
            assertEquals("SGD 3482.35", salary.monthlySalary);
        }
    }

    private static String readJSON(String path) {
        return inputStreamToString(PayrollTest.class.getResourceAsStream(path));
    }
}
