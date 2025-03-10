package com.tcl.examplespringbootconsumer;

import com.tcl.common.model.User;
import com.tcl.common.service.UserService;
import com.tcl.tclrpcspringbootstarter.annotation.RpcReference;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test() {
        User user = new User();
        user.setName("tcl");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}
