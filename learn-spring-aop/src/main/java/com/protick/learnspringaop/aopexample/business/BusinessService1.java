package com.protick.learnspringaop.aopexample.business;

import com.protick.learnspringaop.aopexample.annotations.TrackTime;
import com.protick.learnspringaop.aopexample.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {
    private final DataService1 dataService1;
    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(dataService1.retrieveData()).max().orElse(0);
    }
}
