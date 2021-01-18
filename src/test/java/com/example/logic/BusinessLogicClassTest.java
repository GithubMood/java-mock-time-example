package com.example.logic;

import com.example.extension.MockTimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockTimeExtension.class)
class BusinessLogicClassTest {
    private BusinessLogicClass businessLogicClass = new BusinessLogicClass();

    @Test
    void getLastUpdatedTime_returnMockTime() {
        //WHEN
        String lastUpdatedTime = businessLogicClass.getLastUpdatedTime();

        //THEN
        assertThat(lastUpdatedTime).isEqualTo("Last Updated At 2020-04-01T12:45");
    }
}