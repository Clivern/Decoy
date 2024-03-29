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
package com.clivern.decoy;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Schema Draft6 Class
 *
 * @see <a
 *     href="https://json-schema.org/understanding-json-schema/reference/object.html">Understanding
 *     JSON Schema</a>
 */
public class SchemaDraft6 implements SchemaInterface {

    @SerializedName("$schema")
    public String schema;

    @SerializedName("$id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("type")
    public String type;

    @SerializedName("required")
    public ArrayList<String> required = new ArrayList<String>();

    @SerializedName("properties")
    public HashMap<String, NodeDraft6> properties = new HashMap<String, NodeDraft6>();
}
