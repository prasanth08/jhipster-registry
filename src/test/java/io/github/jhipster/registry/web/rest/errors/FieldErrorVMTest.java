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
package io.github.jhipster.registry.web.rest.errors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldErrorVMTest {

    @Test
    public void getObjectNameTest() {
        FieldErrorVM vm = new FieldErrorVM(null, null, null);
        assertThat(vm.getObjectName()).isNull();
        vm = new FieldErrorVM("dto", "field", "message");
        assertThat(vm.getObjectName()).isEqualTo("dto");
    }

    @Test
    public void getFieldTest() {
        FieldErrorVM vm = new FieldErrorVM(null, null, null);
        assertThat(vm.getField()).isNull();
        vm = new FieldErrorVM("dto", "field", "message");
        assertThat(vm.getField()).isEqualTo("field");
    }

    @Test
    public void getMessageTest() {
        FieldErrorVM vm = new FieldErrorVM(null, null, null);
        assertThat(vm.getMessage()).isNull();
        vm = new FieldErrorVM("dto", "field", "message");
        assertThat(vm.getMessage()).isEqualTo("message");
    }

}
