package com.solera.global.qa.junit5test.tests.testsuite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages("com.solera.global.qa.junit5test")
@SuiteDisplayName("Junit5 Test Project")
public class JunitTestSuite {}
