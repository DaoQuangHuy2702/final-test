package com.example.postbackend.service.validator;

import com.example.postbackend.service.exception.BadRequestException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PostSearchValidatorTest {
    @InjectMocks
    PostSearchValidator validator;

    @Test
    public void validateSearchPost() {
        validator.validateTermSearch("adasa");
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validateSearchPostShowExceptionWhenWrongMinLength() {
        expected.expect(BadRequestException.class);
        expected.expectMessage("Term input is invalid");

        validator.validateTermSearch("a");
    }

    @Test
    public void validateSearchPostShowExceptionWhenWrongMaxLength() {
        expected.expect(BadRequestException.class);
        expected.expectMessage("Term input is invalid");

        validator.validateTermSearch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
