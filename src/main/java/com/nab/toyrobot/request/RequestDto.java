package com.nab.toyrobot.request;

import com.nab.toyrobot.model.Direction;
import com.nab.toyrobot.validator.ValidRequestDto;
import lombok.Data;

@Data
@ValidRequestDto
public class RequestDto {
    private String command;
    private Integer x;
    private Integer y;
    private Direction direction;

}