package com.pedrovsn.repository;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.pedrovsn")
public class RepositoryRulesTest {

    @ArchTest
    static ArchRule repositories_must_be_in_correct_package =
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .should().resideInAPackage("..repository..");
}
