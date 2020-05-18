/*
 * Copyright (C) 2020 Clivern <http://clivern.com>
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
 * Integer Constraint Class
 *
 * @see <a href="https://json-schema.org/understanding-json-schema/reference/numeric.html">Numeric
 *     types</a>
 */
public class IntegerConstraint implements ConstraintInterface<Object, Integer> {

    private String fieldName;

    private Object value;

    private Boolean required;

    private ArrayList<String> errors = new ArrayList<String>();

    /** {@inheritDoc} */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public Integer getValue() {
        return Validate.isInteger(this.value) ? (Integer) this.value : 0;
    }

    /** {@inheritDoc} */
    public String getFieldName() {
        return this.fieldName;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isInteger(this.value);
    }

    /** {@inheritDoc} */
    public Boolean validate() {
        Boolean status = true;

        if (!this.isValidType()) {
            status &= false;
            this.errors.add(String.format("Error! Field %s must be an integer.", this.fieldName));
        }

        return status;
    }

    /**
     * Set Required
     *
     * @param required whether required or not
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * Get Required
     *
     * @return whether required or not
     */
    public Boolean getRequired() {
        return this.required;
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
