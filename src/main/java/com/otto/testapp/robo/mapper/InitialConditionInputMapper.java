package com.otto.testapp.robo.mapper;

import com.otto.testapp.robo.datatransferobject.*;
import com.otto.testapp.robo.domainobject.*;
import com.otto.testapp.robo.util.CustumInvalidInputParameterException;

public class InitialConditionInputMapper {

    public static InitialConditionInputDO mapInitialConditionInput(InitialConditionInputDTO initialConditionInputDTO) throws CustumInvalidInputParameterException {

        return new InitialConditionInputDO(initialConditionInputDTO.getMatrix(),
                initialConditionInputDTO.getInitialPosition(), initialConditionInputDTO.getFinalPosition(),
                initialConditionInputDTO.getInitialDirection());
    }

}
