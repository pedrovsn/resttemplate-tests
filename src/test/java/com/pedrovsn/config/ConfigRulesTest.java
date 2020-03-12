package com.pedrovsn.config;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.pedrovs")
public class ConfigRulesTest {

    @ArchTest
    static ArchRule config_must_be_in_correct_package =
            classes()
                    .that().areAnnotatedWith("Configuration")
                    .should().resideInAnyPackage("..config..");
}
