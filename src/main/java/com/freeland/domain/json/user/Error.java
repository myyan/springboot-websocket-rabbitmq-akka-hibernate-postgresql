package com.freeland.domain.json.user;

import lombok.Data;

/**
 * Created by chenhao on 2016/9/14.
 */
@Data
public class Error {
    private int code;
    private String message;
    private String field;
}
