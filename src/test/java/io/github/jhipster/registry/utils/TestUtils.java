/*
 * Copyright 2015-2021 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see https://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.registry.utils;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.Serializable;

public abstract class TestUtils {

    public static boolean isValid(String json) {
        try {
            JsonParser.parseString(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }

    public static boolean isSerializable(final Class c) {
        return (Serializable.class.isAssignableFrom(c));
    }

    public static boolean isSerializable(final Object c) {
        return isSerializable(c.getClass());
    }
}
