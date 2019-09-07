package br.com.fluentvalidator.spring.validator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.equalTo;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringContains;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

import org.springframework.stereotype.Component;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.model.Boy;
import br.com.fluentvalidator.model.Gender;

@Component
public class ValidatorSpringBoy extends AbstractValidator<Boy>{

	@Override
	protected void rules() {
		
		ruleFor(Boy::getGender)
			.when(not(nullValue()))
				.must(equalTo(Gender.MALE))
				.withMessage("gender of boy must be MALE")
				.withFieldName("gender")
				.critical();
		
		ruleFor(Boy::getName)
			.when(not(stringEmptyOrNull()))
				.must(stringContains("John"))
				.withMessage("child name must contains key John")
				.withFieldName("name");
	}

}