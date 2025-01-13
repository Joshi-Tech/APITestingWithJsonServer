package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DepartmentPOJO {
   // private int id;
    private String department;
    private EmployeePOJO employee;
}
