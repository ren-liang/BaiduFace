package com.aiit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
    public String group_id,user_id,user_info;
    public float score;
}
