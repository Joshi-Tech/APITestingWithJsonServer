package tests;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static service.EmployeeService.getEmployeeSpecificValue;
import static service.EmployeeService.getValueOfSalaryOrContact;
import static service.Resources.getResourceBundle;

public class GETResponseTests {
    private static final Logger Log = LoggerFactory.getLogger(GETResponseTests.class);

    @Test
    public void GETResponseRelatedTests() {
        Log.info("Employee details Test starts");
        Assert.assertEquals(getResourceBundle().getString("get.employee.name"), getEmployeeSpecificValue("1", "name"));
        Assert.assertEquals(getResourceBundle().getString("get.employee.position"), getEmployeeSpecificValue("1", "position"));
        Assert.assertEquals(getResourceBundle().getString("get.employee.department"), getEmployeeSpecificValue("1", "department"));
        Assert.assertEquals(getResourceBundle().getString("get.employee.bonus"), getValueOfSalaryOrContact("1", "salary", "bonus"));
        Assert.assertEquals(getResourceBundle().getString("get.employee.base"), getValueOfSalaryOrContact("1", "salary", "base"));
        Assert.assertEquals(getResourceBundle().getString("get.employee.email"), getValueOfSalaryOrContact("1", "contact", "email"));
        Assert.assertEquals(getResourceBundle().getString("get.employee.phone"), getValueOfSalaryOrContact("1", "contact", "phone"));
    }
}
