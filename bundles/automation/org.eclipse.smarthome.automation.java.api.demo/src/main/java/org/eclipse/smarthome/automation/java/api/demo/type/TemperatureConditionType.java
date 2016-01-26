/**
 * Copyright (c) 1997, 2015 by ProSyst Software GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.automation.java.api.demo.type;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.smarthome.automation.Visibility;
import org.eclipse.smarthome.automation.type.ConditionType;
import org.eclipse.smarthome.automation.type.Input;
import org.eclipse.smarthome.config.core.ConfigDescriptionParameter;
import org.eclipse.smarthome.config.core.ConfigDescriptionParameter.Type;

/**
 * The purpose of this class is to illustrate how to create {@link ConditionType}
 *
 * @author Ana Dimova - Initial Contribution
 *
 */
public class TemperatureConditionType extends ConditionType {

    public static final String UID = "TemperatureCondition";

    public static final String OPERATOR_HEATING = "heating";
    public static final String OPERATOR_COOLING = "cooling";
    public static final String CONFIG_OPERATOR = "operator";
    public static final String CONFIG_TEMPERATURE = "temperatute";
    public static final String INPUT_CURRENT_TEMPERATURE = "currentTemperatute";

    public static TemperatureConditionType initialize() {
        ConfigDescriptionParameter temperature = new ConfigDescriptionParameter(CONFIG_TEMPERATURE, Type.INTEGER, null,
                null, null, null, true, true, false, null, null, "Temperature", "Targeted room temperature", null, null,
                null, null, null, null);
        List<ConfigDescriptionParameter> config = new ArrayList<ConfigDescriptionParameter>();
        config.add(temperature);

        ConfigDescriptionParameter operator = new ConfigDescriptionParameter(CONFIG_OPERATOR, Type.TEXT, null, null,
                null, null, true, true, false, null, null, "Mode", "Heating/Cooling mode", null, null, null, null, null,
                null);
        config.add(operator);

        Input currentTemperature = new Input(INPUT_CURRENT_TEMPERATURE, Integer.class.getName(), "Current Temperature",
                "Current room temperature", null, true, null, null);
        List<Input> input = new ArrayList<Input>();
        input.add(currentTemperature);
        return new TemperatureConditionType(config, input);
    }

    public TemperatureConditionType(List<ConfigDescriptionParameter> config, List<Input> input) {
        super(UID, config, "Temperature Condition Template", "Template for creation of a Temperature Condition.", null,
                Visibility.VISIBLE, input);
    }
}