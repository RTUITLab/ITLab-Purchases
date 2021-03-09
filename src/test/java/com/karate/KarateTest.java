package com.karate;

import com.intuit.karate.junit5.Karate;

class KarateTest {

    @Karate.Test
    Karate testCheck() {
       return Karate.run("testingFunctional").relativeTo(getClass());
    }

}