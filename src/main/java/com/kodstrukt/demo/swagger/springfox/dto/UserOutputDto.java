package com.kodstrukt.demo.swagger.springfox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserOutputDto implements Serializable {
    private static final long serialVersionUID = -1L;

    @ApiModelProperty(example = "1")
    @JsonProperty("id")
    private String id;

    @ApiModelProperty(example = "John")
    @JsonProperty("first_name")
    private String firstName;

    @ApiModelProperty(example = "Doe")
    @JsonProperty("last_name")
    private String lastName;

    @ApiModelProperty(example = "London")
    @JsonProperty("address")
    private String address;


    public void setId(String id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAddress(String address) {
        this.address = address;
    }
}
