package com.masai.model;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User {

   @NotNull(message = "username cannot be null")
   @Size(min=4 , max = 10 , message = "length of username must be between 4 & 10")
   private String username;
   
   @NotNull(message = "password cannot be null")
   @Size(min=6 , max = 10 , message = "length of password must be between 6 & 10")
   private String password;
   
   private String address;
   
   @NotNull(message = "mobile number cannot be null")
   @Pattern(regexp = "[789]{1}[0-9]{9}",message = "invalid mobile number")
   private String mobileNumber;
   
   @Email
   private String email;
   
  // private LocalDate dateOfCreation = LocalDate.now();

}
