package org.danlee.cardealership.datatransfers.validators.samefield;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class SameFieldValueValidator implements
        ConstraintValidator<SameFieldValueConstraint, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(SameFieldValueConstraint constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object dto, ConstraintValidatorContext context) {
        try {
            String firstGetter = "get" + firstFieldName.substring(0,1).toUpperCase(Locale.ROOT) + firstFieldName.substring(1);
            String secondGetter = "get" + secondFieldName.substring(0,1).toUpperCase(Locale.ROOT) + secondFieldName.substring(1);
            String firstFieldValue = dto.getClass().getMethod(firstGetter).invoke(dto).toString();
            String secondFieldValue = dto.getClass().getMethod(secondGetter).invoke(dto).toString();
            if (firstFieldValue.equals(secondFieldValue)) {
                return true;
            } else {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode("matchingField").addConstraintViolation()
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

}