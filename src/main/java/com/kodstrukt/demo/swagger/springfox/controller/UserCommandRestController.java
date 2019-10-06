package com.kodstrukt.demo.swagger.springfox.controller;

import com.kodstrukt.demo.swagger.springfox.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"User Commands"})
@RestController
@RequestMapping("api/user/command")
public class UserCommandRestController {

    @ApiOperation(
            value = "Post Command",
            notes = "Create User Command Operation",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("post")
    public @ResponseBody
    UserPostCommandOutputDto postCommand(@RequestBody UserPostCommandInputDto input){

        UserPostCommandOutputDto output = new UserPostCommandOutputDto();
        output.setId("1");
        output.setFirstName(input.getFirstName());
        output.setLastName(input.getLastName());
        output.setAddress(input.getAddress());

        return output;
    }

    @ApiOperation(
            value = "Put Command",
            notes = "Replace User Command Operation",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping("put")
    public @ResponseBody
    UserPutCommandOutputDto putCommand(@RequestBody UserPutCommandInputDto input){

        UserPutCommandOutputDto output = new UserPutCommandOutputDto();
        output.setId(input.getId());
        output.setFirstName(input.getFirstName());
        output.setLastName(input.getLastName());
        output.setAddress(input.getAddress());

        return output;
    }

    @ApiOperation(
            value = "Patch Command",
            notes = "Update User Command Operation",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PatchMapping("patch")
    public @ResponseBody
    UserPatchCommandOutputDto patchCommand(@RequestBody UserPatchCommandInputDto input){

        UserPatchCommandOutputDto output = new UserPatchCommandOutputDto();
        output.setId(input.getId());
        output.setFirstName(input.getFirstName());
        output.setLastName(input.getLastName());
        output.setAddress(input.getAddress());

        return output;
    }

}
