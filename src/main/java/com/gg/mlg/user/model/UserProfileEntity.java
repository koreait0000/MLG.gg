package com.gg.mlg.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfileEntity {
    private int profile_no;
    private int user_no;
    private String profile_img;
    private String regdt;
}
