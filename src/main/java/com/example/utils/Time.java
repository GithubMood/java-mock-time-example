package com.example.utils;

import java.time.*;
import java.util.TimeZone;

public class Time {
    private static Clock CLOCK = Clock.systemDefaultZone();
    private static final TimeZone REAL_TIME_ZONE = TimeZone.getDefault();

    public static LocalDate currentDate() {
        return LocalDate.now(getClock());
    }

    public static LocalTime currentTime() {
        return LocalTime.now(getClock());
    }

    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now(getClock());
    }

    public static OffsetDateTime currentOffsetDateTime() {
        return OffsetDateTime.now(getClock());
    }

    public static ZonedDateTime currentZonedDateTime() {
        return ZonedDateTime.now(getClock());
    }

    public static Instant currentInstant() {
        return Instant.now(getClock());
    }

    public static long currentTimeMillis() {
        return currentInstant().toEpochMilli();
    }

    public static void useMockTime(LocalDateTime dateTime, ZoneId testZoneId) {
        Instant instant = dateTime.atZone(testZoneId).toInstant();
        CLOCK = Clock.fixed(instant, testZoneId);
        TimeZone.setDefault(TimeZone.getTimeZone(testZoneId));
    }

    public static void useSystemDefaultZoneClock() {
        TimeZone.setDefault(REAL_TIME_ZONE);
        CLOCK = Clock.systemDefaultZone();
    }

    private static Clock getClock() {
        return CLOCK;
    }
}