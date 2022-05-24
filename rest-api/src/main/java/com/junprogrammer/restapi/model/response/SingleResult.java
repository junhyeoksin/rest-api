package com.junprogrammer.restapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends CommonResult {  // 단일 건 일떄
    private T data;
}