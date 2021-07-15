package com.gg.mlg.user;

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
    private String Lname;
    private String Pname;
    private String provider;

}
