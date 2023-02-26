package com.nab.toyrobot.controller;


import com.nab.toyrobot.exception.CollisionException;
import com.nab.toyrobot.model.RobotPosition;
import com.nab.toyrobot.model.ToyRobot;
import com.nab.toyrobot.request.RequestDto;
import com.nab.toyrobot.service.TableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    public TableService tableService;


    /************************************************************************************************
     * http://localhost:8080/game/place-robot
     *
     * @param
     * @return Robot
     * @throws
     */
    @PostMapping("/place")
    public ToyRobot placeRobot(@Valid @RequestBody RequestDto requestDto) throws CollisionException {
        ToyRobot toyRobot = tableService.placeRobot(RobotPosition.builder().x(requestDto.getX()).y(requestDto.getY()).direction(requestDto.getDirection()).build());

        return toyRobot;

    }

//
//    /************************************************************************************************
//     * http://localhost:8080/game/rotate/{direction}
//     *
//     * @param
//     * @return Robot
//     * @throws
//     */
//    @PutMapping("/rotate/{direction}")
//    public ToyRobot rotateRobot(@PathVariable String direction) {
//        return tableService.rotateRobot(RotationDirection.valueOf(direction));
//    }
//
//    /************************************************************************************************
//     * http://localhost:8080/game/move
//     *
//     * @param
//     * @return Robot
//     * @throws
//     */
//    @PutMapping("/move")
//    public ToyRobot moveRobot() {
//        return tableService.moveRobot();
//    }
//
//
    /************************************************************************************************
     * http://localhost:8080/game/move
     *
     * @param
     * @return Set<Robot>
     * @throws
     */
    @GetMapping("/report")
    public String report() {
        return "Hello";
    }


}
