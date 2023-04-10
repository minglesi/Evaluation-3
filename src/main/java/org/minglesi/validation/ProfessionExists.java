package org.minglesi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.minglesi.db.dao.ProfessionDao;
import org.minglesi.db.dao.ProfessionDaoImpl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ProfessionExists.Validator.class})
public @interface ProfessionExists {

    String message() default "Invalid Profession";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<ProfessionExists, Long> {
        @Override
        public void initialize(ProfessionExists professionExists) {
        }

        @Override
        public boolean isValid(Long professionId, ConstraintValidatorContext constraintValidatorContext) {
            ProfessionDao professionDao = new ProfessionDaoImpl();
            return professionDao.isValidProfessionId(professionId);
        }
    }
}