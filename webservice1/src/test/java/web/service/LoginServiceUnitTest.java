package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        // Arrange
        String username = "dilshan";
        String password = "dilshan_pass";
        String dob = "1993-8-11";

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidUsername() {
        // Arrange
        String username = "invalid_user";
        String password = "dilshan_pass";
        String dob = "1993-8-11";

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        // Arrange
        String username = "dilshan";
        String password = "invalid_password";
        String dob = "1993-8-11";

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidDOB() {
        // Arrange
        String username = "dilshan";
        String password = "dilshan_pass";
        String dob = "01/01/2000"; // Invalid date format

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertFalse(result);
    }
}
