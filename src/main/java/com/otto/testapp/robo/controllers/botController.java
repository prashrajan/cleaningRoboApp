package com.otto.testapp.robo.controllers;

import java.util.*;

import javax.validation.*;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.otto.testapp.robo.datatransferobject.*;
import com.otto.testapp.robo.domainobject.*;
import com.otto.testapp.robo.mapper.*;
import com.otto.testapp.robo.service.*;
import com.otto.testapp.robo.util.CustumInvalidInputParameterException;
import com.otto.testapp.robo.util.CustumPathNotException;

@RestController
@RequestMapping("robo/bot")
public class botController {

    private final BotService botService;

    @Autowired
    public botController(final BotService botService) {
        this.botService = botService;
    }

    @GetMapping()
    public String Bot() {
        return "hello Bot";
    }

    @PostMapping("/input")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> inputInitialCondition(@Valid @NotNull @RequestBody InitialConditionInputDTO initialConditionInputDTO) throws CustumInvalidInputParameterException, CustumPathNotException  {

        InitialConditionInputDO initialConditionInputDO = InitialConditionInputMapper.mapInitialConditionInput(
                initialConditionInputDTO);

        BotCommandSequenceDO botCommandsSequence = botService.callBotWorld(initialConditionInputDO);

        return botCommandsSequence.getBotCommandSequence();
    }

}
