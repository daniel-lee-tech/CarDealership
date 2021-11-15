package org.danlee.cardealership.datatransfers;


import org.danlee.cardealership.datatransfers.validators.samefield.SameFieldValueConstraint;
import org.springframework.beans.BeanUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;

@SameFieldValueConstraint(first="password", second="passwordConfirmation")
public class UserRegistrationDTO {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String passwordConfirmation;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
