package com.solera.global.qa.junit5test;

import com.solera.global.qa.junit5test.common.utils.PropertyUtils;

public class TestBase {

  protected static final String MSG = PropertyUtils.getInstance().getProperty("msg");
}
