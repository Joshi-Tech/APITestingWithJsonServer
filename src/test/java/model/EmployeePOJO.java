package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeePOJO {
    private String firstName;
    private String lastName;
    private float salary;
    private int age;
}
