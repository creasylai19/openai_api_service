package com.creasy.openai;

import org.junit.jupiter.api.Test;

public class JavaTest {

    @Test
    public void testAPIKEY(){
        String token = System.getenv("OPENAI_TOKEN");
        System.out.printf(token);
    }

}
