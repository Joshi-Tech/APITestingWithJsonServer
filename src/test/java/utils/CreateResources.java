package utils;

import java.util.ArrayList;
import java.util.HashMap;

import static service.Resources.getResourceBundle;

public class CreateResources {

    public static HashMap<String, Object> createResource() {
        ArrayList<String> contact = new ArrayList<>();
        HashMap<String, Object> contactMap = new HashMap<>();
        if (getResourceBundle().getString("employee.requestType").equals("post")) {
           contact.add(getResourceBundle().getString("employee.email"));
        } else {
            contact.add(getResourceBundle().getString("employee.updateEmail"));
        }
        contact.add(getResourceBundle().getString("employee.phone"));
        contactMap.put("email", contact.get(0));
        contactMap.put("phone", contact.get(1));

        ArrayList<Integer> salary = new ArrayList<>();
        HashMap<String, Object> salaryMap = new HashMap<>();
        salary.add(Integer.parseInt(getResourceBundle().getString("salary.basic")));
        salary.add(Integer.parseInt(getResourceBundle().getString("salary.bonus")));
        salaryMap.put("email", salary.get(0));
        salaryMap.put("phone", salary.get(1));

        HashMap<String, Object> employee = new HashMap<>();
        employee.put("name", getResourceBundle().getString("employee.name"));
        employee.put("position", getResourceBundle().getString("employee.position"));
        employee.put("department", getResourceBundle().getString("employee.department"));
        employee.put("salary", salaryMap);
        employee.put("contact", contactMap);
        return employee;
    }

    public static HashMap<String, Object> createEmployeePatchRequest() {
        // Create a nested map for the updated contact object
        HashMap<String, Object> contactMap = new HashMap<>();
        contactMap.put("phone", getResourceBundle().getString("employee.updatePhone"));
        contactMap.put("email", getResourceBundle().getString("employee.updateEmail"));

        // Add the updated contact object to the employee map
        HashMap<String, Object> employee = new HashMap<>();
        employee.put("contact", contactMap);
        return employee;
    }
}
