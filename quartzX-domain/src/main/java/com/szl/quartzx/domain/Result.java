package com.szl.quartzx.domain;

public class Result {
    private String message;
    private boolean success;
    private Object datas;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public static Result setSuccess(String message) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(message);

        return result;
    }

    public static Result setFailure(String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);

        return result;
    }
}
