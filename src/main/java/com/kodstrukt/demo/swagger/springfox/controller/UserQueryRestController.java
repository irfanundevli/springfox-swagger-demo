package com.kodstrukt.demo.swagger.springfox.controller;

import com.kodstrukt.demo.swagger.springfox.dto.UserOutputDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"User Queries"})
@RestController
@RequestMapping("api/user/query")
public class UserQueryRestController {

    @ApiOperation(
            value = "Get User Query By First Name",
            notes = "Get User Query By First Name Operation",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @GetMapping("getByFirstName")
    public @ResponseBody
    List<UserOutputDto> queryByFirstName(@RequestParam @ApiParam(name="First Name", example = "John") String firstName){
        UserOutputDto user1 = new UserOutputDto();
        user1.setId("1");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setAddress("London");

        UserOutputDto user2 = new UserOutputDto();
        user2.setId("2");
        user2.setFirstName("John");
        user2.setLastName("Wellington");
        user2.setAddress("Liverpool");

        List userList = new ArrayList<UserOutputDto>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }


    @ApiIgnore
    @ApiOperation(
            value = "Get User Query By Id",
            notes = "Get User Query By ID Operation",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @RequestMapping(method = RequestMethod.GET, path = "getById")
    public @ResponseBody
    UserOutputDto queryById(@RequestParam @ApiParam(example = "1") String id){

        UserOutputDto user1 = new UserOutputDto();
        user1.setId("1");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setAddress("London");

        return user1;
    }

}
