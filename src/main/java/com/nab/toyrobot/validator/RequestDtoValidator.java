package com.nab.toyrobot.validator;

import com.nab.toyrobot.model.Commands;
import com.nab.toyrobot.request.RequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class RequestDtoValidator implements ConstraintValidator<ValidRequestDto, RequestDto> {

    @Override
    public void initialize(ValidRequestDto constraintAnnotation) {
    }

    @Override
    public boolean isValid(RequestDto requestDto, ConstraintValidatorContext context) {
        if (requestDto == null) {
            return false;
        }

        // Validate the command field
        if (requestDto.getCommand() == null || requestDto.getCommand().isEmpty() || !isValidCommand(requestDto.getCommand()))
            return false;

            if(requestDto.getCommand().equals(Commands.PLACE.toString()))
            {
                // Validate the x and y fields
                if (requestDto.getX() == null || requestDto.getY() == null) {
                    return false;
                }
                // Validate the direction field
                if (requestDto.getDirection() == null) {
                    return false;
                }
            }

        return true;
    }


    public boolean isValidCommand(String command)
    {
        for (Commands type : Commands.values()) {
            if (type.name().equals(command)) {
                return true;
            }
        }

        return false;
    }
}