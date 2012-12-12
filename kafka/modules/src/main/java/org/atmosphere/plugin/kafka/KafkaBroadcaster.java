/*
 * Copyright 2012 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.plugin.kafka;


import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.util.AbstractBroadcasterProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * Simple {@link org.atmosphere.cpr.Broadcaster} implementation based on Apache Kafka
 *
 * @author Aleksandar Vidakovic
 */
public class KafkaBroadcaster extends AbstractBroadcasterProxy {

    private static final Logger logger = LoggerFactory.getLogger(org.atmosphere.plugin.kafka.KafkaBroadcaster.class);

    public KafkaBroadcaster(String id, AtmosphereConfig config) {
        this(id, URI.create("http://localhost:6379"), config);
    }

    public KafkaBroadcaster(String id, URI uri, AtmosphereConfig config) {
        super(id, uri, config);
    }

    public void setUp() {
    }

    @Override
    public synchronized void setID(String id) {
        super.setID(id);
        setUp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incomingBroadcast() {
        logger.info("Subscribing to: {}", getID());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void outgoingBroadcast(Object message) {
    }

}
