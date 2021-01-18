package com.example.logic;

import com.example.utils.Time;

public class BusinessLogicClass {
    public String getLastUpdatedTime() {
        return "Last Updated At " + Time.currentDateTime();
    }
}
