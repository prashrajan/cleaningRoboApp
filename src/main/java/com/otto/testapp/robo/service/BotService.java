package com.otto.testapp.robo.service;

import org.springframework.stereotype.*;

import com.otto.testapp.robo.domainobject.*;
import com.otto.testapp.robo.util.CustumPathNotException;

@Service
public class BotService {

    public BotCommandSequenceDO callBotWorld(InitialConditionInputDO initialConditionInputDO) throws CustumPathNotException {
        BotWorld botWorld = new BotWorld(initialConditionInputDO);
        return createBotCommandsSequence(botWorld.solveBotWorld(), initialConditionInputDO);
    }

    private BotCommandSequenceDO createBotCommandsSequence(char[][] botSolutionMatrix,
            InitialConditionInputDO initialConditionInputDO) {
        BotCommandSequenceCreater botCommandSequenceCreater = new BotCommandSequenceCreater(botSolutionMatrix,
                initialConditionInputDO);
        BotCommandSequenceDO botCommandsDO = botCommandSequenceCreater.createBotCommands();
        return botCommandsDO;
    }

}
