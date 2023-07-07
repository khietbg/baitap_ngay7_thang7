package bt.n7t7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "the anh", "the@gmail.com", "nhan su", Collections.singletonList("ROLE_USER")));
        employeeList.add(new Employee(2, "minh khiet", "khiet@gmail.com", "van hanh", Collections.singletonList("ROLE_ADMIN")));
        employeeList.add(new Employee(3, "quang tuan", "tuan@gmail.com", "truyen thong", Collections.singletonList("ROLE_USER")));
    }

    public List<Employee> findAll() {
        return employeeList;
    }

    public Employee findById(int id) {
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void save(Employee employee) {

        if (employee.getId() == 0) {
            int id = employeeList.get(employeeList.size() - 1).getId() + 1;
            employee.setId(id);
            employeeList.add(employee);
        } else {
            employeeList.set(employeeList.indexOf(findById(employee.getId())), employee);
        }

    }

    public boolean deleteById(int id) {
        if (findById(id) == null) {
            return false;
        } else {
            employeeList.remove(findById(id));
        }
        return true;
    }

    public Employee findByEmail(String email) {
        for (Employee e : employeeList) {
            if (e.getEmail().equals(email)) {
              return e;
                }
            }
      return null;
    }

    public boolean checkEmail(String email) {
        for (Employee e : employeeList) {
            if (e.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
