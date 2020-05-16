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
package com.clivern.kangaroo;

import static org.junit.Assert.*;

import org.junit.Test;

/** Schema Draft3 Test Cases */
public class SchemaDraft3Test {

    @Test
    public void testSchemaDraft3_01() {
        SchemaFactory schemaFactory = new SchemaFactory();
        SchemaDraft3 schema = new SchemaDraft3();
        schema.schema = "http://json-schema.org/draft-07/schema#";
        schema.id = "SchemaId";
        schema.type = "object";

        String json = schemaFactory.serialize(schema);

        assertEquals(
                "{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"id\":\"SchemaId\",\"type\":\"object\",\"required\":[],\"properties\":{}}",
                json);
    }

    @Test
    public void testSchemaDraft3_02() {
        SchemaFactory schemaFactory = new SchemaFactory();
        SchemaDraft3 schema = new SchemaDraft3();
        schema.schema = "http://json-schema.org/draft-07/schema#";
        schema.id = "SchemaId";
        schema.type = "object";
        schema.required.add("itemOne");
        schema.required.add("itemTwo");
        schema.required.add("itemThree");

        String json = schemaFactory.serialize(schema);

        assertEquals(
                "{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"id\":\"SchemaId\",\"type\":\"object\",\"required\":[\"itemOne\",\"itemTwo\",\"itemThree\"],\"properties\":{}}",
                json);
    }
}
