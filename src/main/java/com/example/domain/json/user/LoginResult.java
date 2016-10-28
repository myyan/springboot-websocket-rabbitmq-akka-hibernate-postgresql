package com.example.domain.json.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenhao on 2016/9/13.
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LoginResult {
    private String code;
    private String message;
    private Integer authority;
}
