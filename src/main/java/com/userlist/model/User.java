package com.userlist.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User extends BaseEntity{
    private String userName;
    private String email;
    private String phoneNumber;
    private String status;




//    Create a User List with the following
//    parameters (Username, Email, Phone Number, Date Created, Status
}
