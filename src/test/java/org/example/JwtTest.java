package org.example;

import com.auth0.jwt.JWT;
import org.junit.jupiter.api.Test;

public class JwtTest {

    @Test
    public void testJWT(){
        JWT.create()
                .withPayload("user");
    }
}
