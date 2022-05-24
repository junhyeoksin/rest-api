package com.junprogrammer.restapi.model.response;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ListResult<T> extends CommonResult {  // 여러 건일 떄
    private List<T> list;
}