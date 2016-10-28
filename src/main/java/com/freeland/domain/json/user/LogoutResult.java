package com.freeland.domain.json.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenhao on 2016/9/13.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutResult {
    private String code;
    private String message;
}
