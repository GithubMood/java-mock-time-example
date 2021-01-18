package com.example.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class OldTimeAdaptor {
    public static LocalDateTime toLocalDateTime(Date date) {
        return (date == null) ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date toDate(LocalDateTime localDatetime) {
        return localDatetime == null ? null : Date.from(localDatetime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
