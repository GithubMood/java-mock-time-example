package com.example;

import com.example.utils.OldTimeAdaptor;
import com.example.utils.Time;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.time.*;
import java.util.Date;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(
        packages = "com.example",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class ArchitectureRulesTest {
    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_OLD_DATE_API = classes()
            .that().areNotAssignableTo(OldTimeAdaptor.class)
            .should().onlyAccessClassesThat().areNotAssignableTo(Date.class)
            .because("java.util.Date is class from the old Date API. " +
                    "Please use new Date API from the package java.time.* " +
                    "In case when you need current date/time use wrapper class com.swift.tsp.portal.utils.Time");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_LOCAL_DATE_TIME_NOW = noClasses()
            .should().callMethod(LocalDateTime.class, "now")
            .because("Use Time.currentDateTime methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_LOCAL_DATE_NOW = noClasses()
            .should().callMethod(LocalDate.class, "now")
            .because("Use Time.currentDate methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_LOCAL_TIME_NOW = noClasses()
            .should().callMethod(LocalTime.class, "now")
            .because("Use Time.currentTime methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_OFFSET_DATE_TIME_NOW = noClasses()
            .should().callMethod(OffsetDateTime.class, "now")
            .because("Use Time.currentOffsetDateTime methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_ZONED_DATE_TIME_NOW = noClasses()
            .should().callMethod(ZonedDateTime.class, "now")
            .because("Use Time.currentZonedDateTime methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_INSTANT_NOW = noClasses()
            .should().callMethod(Instant.class, "now")
            .because("Use Time.currentInstant methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_TIME_MOCKING = noClasses()
            .should().callMethod(Time.class, "useMockTime", LocalDateTime.class, ZoneId.class)
            .because("Method Time.useMockTime designed only for test purpose and can be used only in the tests");
}
