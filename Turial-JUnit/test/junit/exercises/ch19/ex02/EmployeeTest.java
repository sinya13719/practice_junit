package junit.exercises.ch19.ex02;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

/**
 * リスト19.2 Employeeオブジェクトの読み込みテスト
 */
public class EmployeeTest {

    @Test
    public void loadでEmplyoeeの一覧を取得できる() throws Exception {
        // SetUp
    	// input = nullになっている
        InputStream input = EmployeeTest.class.getResourceAsStream("resourses/Employee.properties");
        // Exercise
        List<Employee> actual = Employee.load(input);
        // Verify
        assertEquals(actual.size(), 1);
        Employee actualEmployee = actual.get(0);
        assertEquals(actualEmployee.getFirstName(), "Ichiro");
        assertEquals(actualEmployee.getLastName(), "Tanaka");
        assertEquals(actualEmployee.getEmail(), "ichiro@example.com");
    }

}