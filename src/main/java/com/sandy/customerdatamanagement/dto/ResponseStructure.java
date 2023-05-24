package com.sandy.customerdatamanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ResponseStructure<T> {
    private Integer statusCode;
    private T data;
    private String message;
    private LocalDateTime timeStamp;
}
