package com.acme.payroll;

import com.acme.payroll.external.JsonFileInput;
import com.acme.payroll.external.Output;
import com.acme.payroll.model.EmployeePayment;
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
    ArgumentCaptor<ArrayList<EmployeePayment>> captor;

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

        List<EmployeePayment> salaries = captor.getAllValues().get(0);
        assertNotNull(salaries);
        assertEquals(6, salaries.size());

        for (EmployeePayment employeePayment : salaries) {
            System.out.println(employeePayment.toString());
            validateOutput(employeePayment);
        }
    }

    private void validateOutput(EmployeePayment employeePayment) {
        if (employeePayment.fullName.contains("Joan")) {
            assertEquals("USD 2235.51", employeePayment.displayAmount);
        }
        if (employeePayment.fullName.contains("Dan")) {
            assertEquals("AUD 2083.33", employeePayment.displayAmount);
        }
        if (employeePayment.fullName.contains("Billy")) {
            assertEquals("AUD 1250.00", employeePayment.displayAmount);
        }
        if (employeePayment.fullName.contains("Jenny")) {
            assertEquals("AUD 1250.00", employeePayment.displayAmount);
        }
        if (employeePayment.fullName.contains("Peter")) {
            assertEquals("AUD 2916.67", employeePayment.displayAmount);
        }
        if (employeePayment.fullName.contains("Mary")) {
            assertEquals("SGD 3482.36", employeePayment.displayAmount);
        }
    }

    private static String readJSON(String path) {
        return inputStreamToString(PayrollTest.class.getResourceAsStream(path));
    }
}
