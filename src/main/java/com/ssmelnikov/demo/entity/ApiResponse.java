package com.ssmelnikov.demo.entity;

public class ApiResponse {
    public static final Integer SUCCESS_CODE = 0;
    public static final Integer INTERNAL_SERVER_CODE = 10;

    public static final String SUCCESS_DESC = "Successfull";

    private Integer code;
    private String description;

    public ApiResponse() {
    }

    public ApiResponse(final Integer code, final String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
