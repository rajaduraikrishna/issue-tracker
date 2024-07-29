package com.ezeeinfo.issuemanager.arch;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
class ArchitectureTest {
    @Test
    void some_architecture_rule() {
        JavaClasses serviceClasses = new ClassFileImporter().importPackages("com.ezeeinfo.issuemanager.service");

        fields().that().arePrivate().should().beFinal()
                .check(serviceClasses);
    }
}