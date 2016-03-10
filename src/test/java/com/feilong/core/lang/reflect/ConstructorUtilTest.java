/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.lang.reflect;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.tools.jsonlib.JsonUtil;
import com.feilong.test.User;

/**
 * The Class ConstructorUtilTest.
 *
 * @author feilong
 * @version 1.0.7 2014年7月15日 下午1:15:29
 * @since 1.0.7
 */
public class ConstructorUtilTest{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorUtilTest.class);

    /**
     * New instance.
     *
     * @throws ClassNotFoundException
     *             the class not found exception
     */
    @Test
    public void newInstance() throws ClassNotFoundException{
        LOGGER.info(JsonUtil.format(ConstructorUtil.newInstance("com.feilong.test.User")));
        LOGGER.info(JsonUtil.format(ConstructorUtil.newInstance("com.feilong.test.User", 100L)));
        LOGGER.info(JsonUtil.format(ConstructorUtil.newInstance(User.class, Long.parseLong("5"))));
        LOGGER.info(JsonUtil.format(ConstructorUtil.newInstance(User.class, 5, 8)));
    }
}