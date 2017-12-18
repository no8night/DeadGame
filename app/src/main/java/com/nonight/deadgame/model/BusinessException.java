package com.nonight.deadgame.model;



/**
 * 业务异常类<br>
 * 该类型异常为用户行为导致运算出错，或违反业务操作逻辑造成的异常
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 720264575217922710L;

    /** 替换点位符的参数 */
    private Object[] args;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Throwable cause, Object... args) {
        super(message, cause);
        this.args = args;
    }

    public BusinessException(String message, Object... args) {
        super(message);
        this.args = args;
    }



    public BusinessException(Throwable cause) {
        super(cause);
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }



}
