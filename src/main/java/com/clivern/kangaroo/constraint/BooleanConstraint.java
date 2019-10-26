/*
 * Copyright (C) 2019 Clivern <http://clivern.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.kangaroo.constraint;

import com.clivern.kangaroo.util.Validate;
import java.util.ArrayList;

/**
 * BooleanConstraint Class
 *
 * @see <a href="https://json-schema.org/understanding-json-schema/reference/boolean.html">Boolean
 *     types</a>
 */
public class BooleanConstraint implements ConstraintInterface<Object, Boolean> {

    private String inputName;

    private Object value;

    private ArrayList<String> errors = new ArrayList<String>();

    /** {@inheritDoc} */
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public Boolean getValue() {
        return Validate.isBoolean(this.value) ? (Boolean) this.value : false;
    }

    /** {@inheritDoc} */
    public String getInputName() {
        return this.inputName;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isBoolean(this.value);
    }

    /** {@inheritDoc} */
    public Boolean validate() {
        if (this.isValidType()) {
            return true;
        }

        this.errors.add(String.format("Error! Input %s must be boolean.", this.inputName));
        return false;
    }

    /** {@inheritDoc} */
    public ArrayList<String> getErrors() {
        return this.errors;
    }

    /** {@inheritDoc} */
    public Boolean hasErrors() {
        return this.errors.size() > 0;
    }
}
