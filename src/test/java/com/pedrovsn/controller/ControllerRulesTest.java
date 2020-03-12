package com.pedrovsn.controller;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.pedrovsn")
public class ControllerRulesTest {

    @ArchTest
    static ArchRule rest_resources_must_be_in_correct_package =
            classes()
                    .that().areAnnotatedWith("RestController")
                    .should().resideInAnyPackage("..controller..");
}
