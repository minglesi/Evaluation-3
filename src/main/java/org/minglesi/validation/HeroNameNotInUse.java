package org.minglesi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.minglesi.db.dao.HeroDao;
import org.minglesi.db.dao.HeroDaoImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {HeroNameNotInUse.Validator.class})
public @interface HeroNameNotInUse {

    String message() default "Name already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<HeroNameNotInUse, String> {
        @Override
        public void initialize(HeroNameNotInUse heroNameNotInUse) {
        }

        @Override
        public boolean isValid(String heroName, ConstraintValidatorContext constraintValidatorContext) {
            HeroDao heroDao = new HeroDaoImpl();
            return heroDao.isNameAvailable(heroName);
        }
    }
}

