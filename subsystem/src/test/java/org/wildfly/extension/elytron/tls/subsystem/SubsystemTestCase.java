/*
 * Copyright 2019 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wildfly.extension.elytron.tls.subsystem;

import java.io.IOException;

import org.jboss.as.subsystem.test.AbstractSubsystemBaseTest;
import org.jboss.as.subsystem.test.AdditionalInitialization;

/**
 * @author <a href="mailto:kabir.khan@jboss.com">Kabir Khan</a>
 */
public class SubsystemTestCase extends AbstractSubsystemBaseTest {

    public SubsystemTestCase() {
        super(ElytronTlsExtension.SUBSYSTEM_NAME, new ElytronTlsExtension());
    }

    @Override
    protected String getSubsystemXml() throws IOException {
        //test configuration put in standalone.xml
        return readResource("template-subsystem-test.xml");
    }

    @Override
    protected String getSubsystemXsdPath() throws Exception {
        return "schema/elytron-tls-subsystem_1_0.xsd";
    }

    protected AdditionalInitialization createAdditionalInitialization() {
        return AdditionalInitialization.withCapabilities(ElytronTlsExtension.WELD_CAPABILITY_NAME);
    }

}
