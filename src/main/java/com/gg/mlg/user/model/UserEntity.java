package com.gg.mlg.user.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private int user_no;
    private String uid;
    private String upw;
    private String lname;
    private String provider;
}
