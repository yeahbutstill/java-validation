package com.yeahbutstill.javavalidation.service;

import com.yeahbutstill.javavalidation.constrain.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(
            // disini dihitung dari parameter keberapa
            passwordParam = 1,
            retypePasswordParam = 2
    )
    public void register(@NotBlank(message = "username can not blank") String username,
                         @NotBlank(message = "passowrd can not blank") String password,
                         @NotBlank(message = "retype password can not blank") String retypePassword) {
        // TODO register
    }

}
