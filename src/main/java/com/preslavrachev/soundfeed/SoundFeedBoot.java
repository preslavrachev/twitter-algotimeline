package com.preslavrachev.soundfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by preslavrachev on 05/12/15.
 */

@EnableAutoConfiguration
@ComponentScan
public class SoundFeedBoot {

    public static void main(String[] args) {
        SpringApplication.run(SoundFeedBoot.class, args);
    }

}
