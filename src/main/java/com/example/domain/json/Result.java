package com.example.domain.json;

import lombok.Builder;
import lombok.Data;

/**
 * Created by chenhao on 2016/10/28.
 */
@Data
@Builder
public class Result {
    private int code;
    private String message;
}
