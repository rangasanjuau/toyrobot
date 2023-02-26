package com.nab.toyrobot.controller;


import com.nab.toyrobot.model.Direction;
import com.nab.toyrobot.model.Position;
import com.nab.toyrobot.model.Robot;
import com.nab.toyrobot.model.RotationDirection;
import com.nab.toyrobot.service.TableService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    public TableService tableService;


    /************************************************************************************************
     * http://localhost:8080/game/place-robot/{x}/{y}
     *
     * @param
     * @return Robot
     * @throws
     */
    @PostMapping("/place/{x}/{y}")
    public Robot placeRobot(@PathVariable @Positive(message ="Invalid X value") Long x, @PathVariable @Positive(message ="Invalid Y value") Long y) throws Exception {
        return tableService.placeRobot(Position.builder().x(x).y(y).build());
    }


    /************************************************************************************************
     * http://localhost:8080/game/rotate/{direction}
     *
     * @param
     * @return Robot
     * @throws
     */
    @PutMapping("/rotate/{direction}")
    public Robot rotateRobot(@PathVariable String direction) {
        return tableService.rotateRobot(RotationDirection.valueOf(direction));
    }

    /************************************************************************************************
     * http://localhost:8080/game/move
     *
     * @param
     * @return Robot
     * @throws
     */
    @PutMapping("/move")
    public Robot moveRobot()  {
        return tableService.moveRobot();
    }


    /************************************************************************************************
     * http://localhost:8080/game/move
     *
     * @param
     * @return Robot
     * @throws
     */
    @PutMapping("/report")
    public Set<Robot> report()  {
        return tableService.report();
    }


}
