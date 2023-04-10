package org.minglesi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.minglesi.db.dao.HeroDao;
import org.minglesi.db.dao.HeroDaoImpl;
import org.minglesi.db.dao.ProfessionDao;
import org.minglesi.db.dao.ProfessionDaoImpl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueProfessionName.Validator.class})
public @interface UniqueProfessionName {

    String message() default "Name already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<UniqueProfessionName, String> {
        @Override
        public void initialize(UniqueProfessionName uniqueProfessionName) {
        }

        @Override
        public boolean isValid(String professionName, ConstraintValidatorContext constraintValidatorContext) {
            ProfessionDao professionDao = new ProfessionDaoImpl();
            return professionDao.isNameAvailable(professionName);
        }
    }
}

