package com.fullstack.test1.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor

@NoArgsConstructor
public class UserDto {

    private String Email;
}
