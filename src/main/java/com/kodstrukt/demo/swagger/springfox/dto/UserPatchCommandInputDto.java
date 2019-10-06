package com.kodstrukt.demo.swagger.springfox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@Validated
public class UserPatchCommandInputDto implements Serializable {

    private static final long serialVersionUID = -1L;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "1")
    @JsonProperty("id")
    private String id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 40)
    @ApiModelProperty(example = "John")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 40)
    @ApiModelProperty(example = "Doe")
    @JsonProperty("last_name")
    private String lastName;

    @ApiModelProperty(example = "London")
    @JsonProperty("address")
    private String address;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
