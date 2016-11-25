package com.acme.payroll.external;

import static com.acme.payroll.utils.JsonUtils.inputStreamToString;

public class JsonFileInput implements Input {

    private static final String INPUT_FILE = "/employees.json";
    private static final String INPUT_FILE_RATES = "/exchange_rates.json";

    @Override
    public Object getEmployeeDataSource() {
        return readJSON(INPUT_FILE);
    }

    @Override
    public Object getCurrencyDataSource() {
        return readJSON(INPUT_FILE_RATES);
    }

    private static String readJSON(String path) {
        return inputStreamToString(JsonFileInput.class.getResourceAsStream(path));
    }
}
