package com.nab.toyrobot.controller;


import com.nab.toyrobot.exception.CollisionException;
import com.nab.toyrobot.exception.EdgeDetectedException;
import com.nab.toyrobot.exception.ResourceNotFoundException;
import com.nab.toyrobot.exception.TableInitializationException;
import com.nab.toyrobot.model.RobotPosition;
import com.nab.toyrobot.model.Rotation;
import com.nab.toyrobot.model.Table;
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
    public ToyRobot placeRobot(@Valid @RequestBody RequestDto requestDto) throws CollisionException, EdgeDetectedException {
        return (ToyRobot) tableService.placeRobot(RobotPosition.builder()
                .x(requestDto.getX())
                .y(requestDto.getY())
                .direction(requestDto.getDirection())
                .build());

    }


    /************************************************************************************************
     * http://localhost:8080/game/rotate/{direction}
     *
     * @param
     * @return Robot
     * @throws
     */
    @PutMapping("/rotate/{direction}")
    public ToyRobot rotateRobot(@Valid @RequestBody RequestDto requestDto) throws TableInitializationException, ResourceNotFoundException {
        return tableService.rotateRobot(Rotation.valueOf(requestDto.getCommand()));
    }

    /************************************************************************************************
     * http://localhost:8080/game/move
     *
     * @param
     * @return Robot
     * @throws
     */
    @PutMapping("/move")
    public ToyRobot moveRobot(@Valid @RequestBody RequestDto requestDto) throws CollisionException, EdgeDetectedException, TableInitializationException, ResourceNotFoundException {
        return tableService.moveRobot();
    }


    /************************************************************************************************
     * http://localhost:8080/game/move
     *
     * @param
     * @return Set<Robot>
     * @throws
     */
    @GetMapping("/report")
    public Table report() throws TableInitializationException {
        return tableService.report();
    }


}
