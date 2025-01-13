package service;

import java.util.List;
import java.util.Map;

import static response.Responses.getResponse;

public class EmployeeService {

    public static List<Map<String, Object>> getEmployeesWithTheirPosition() {
        List<Map<String, Object>> list = getResponse().jsonPath().getList("");
        List<Map<String, Object>> itEmp = list.stream().filter(x -> x.get("position").equals("QA Analyst")).toList();
        return itEmp;
    }

    /****Extracting values from GET call**/

    /**
     * Code below is extracting a specific employee from the list of all employees
     **/
    public static Map<String, Object> getEmployee(String id) {
        List<Map<String, Object>> list = getResponse().jsonPath().getList("");
        List<Map<String, Object>> employee = list.stream().filter(x -> x.get("id").equals(id)).toList();
        return employee.get(0);
    }

    /***With below code getting specific value of an employee e.g. "name" or "positiion" etc**/
    public static String getEmployeeSpecificValue(String id, String key) {
        return getEmployee(id).get(key).toString();
    }

    /**
     * With below code getting specific value from a nested object e.g. "contact" or "salary"
     **/
    public static String getValueOfSalaryOrContact(String id, String key, String subKey) {
        Map<String, Object> contactOrSalary = (Map<String, Object>) getEmployee(id).get(key);
        return contactOrSalary.get(subKey).toString();
    }
}
