package org.minglesi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.minglesi.db.dao.ProfessionDao;
import org.minglesi.db.dao.ProfessionDaoImpl;
import org.minglesi.db.model.Profession;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {HpManaRelation.Validator.class})
public @interface HpManaRelation {

    String message() default "Invalid relation between Hp and Mana.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<HpManaRelation, Profession> {
        @Override
        public void initialize(HpManaRelation hpManaRelation) {
        }

        @Override
        public boolean isValid(Profession profession, ConstraintValidatorContext context) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode("Hp_Mana").addConstraintViolation();
            return (profession.getHp() + profession.getMana()) == 100;
        }
    }
}