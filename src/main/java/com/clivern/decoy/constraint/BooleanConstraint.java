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
package com.clivern.decoy.constraint;

import com.clivern.decoy.util.Validate;
import java.util.ArrayList;

/**
 * Boolean Constraint Class
 *
 * @see <a href="https://json-schema.org/understanding-json-schema/reference/boolean.html">Boolean
 *     types</a>
 */
public class BooleanConstraint implements ConstraintInterface<Object, Boolean> {

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
    public Boolean getValue() {
        return Validate.isBoolean(this.value) ? (Boolean) this.value : false;
    }

    /** {@inheritDoc} */
    public String getFieldName() {
        return this.fieldName;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isBoolean(this.value);
    }

    /** {@inheritDoc} */
    public Boolean validate() {
        Boolean status = true;

        if (this.required != null && this.required && this.value == null) {
            status &= false;
            this.errors.add(String.format("Error! Field %s is required.", this.fieldName));
        }

        if (!this.isValidType()) {
            status &= false;
            this.errors.add(String.format("Error! Field %s must be boolean.", this.fieldName));
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
