package com.viagogo.payroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.viagogo.payroll.TestUtils.inputStreamToString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PayrollTest {

    private static final String INPUT_FILE = readJSON("/employees.json");

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testInputFile() {
        assertNotNull(INPUT_FILE);
        assertTrue(INPUT_FILE.contains("Mary"));
    }

    private static String readJSON(String path) {
        return inputStreamToString(PayrollTest.class.getResourceAsStream(path));
    }
}
