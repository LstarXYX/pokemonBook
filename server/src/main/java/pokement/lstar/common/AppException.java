package pokement.lstar.common;

/**
 * @author L.star
 * @date 2022/2/26 20:49
 */
public class AppException extends RuntimeException {
    private Integer code;
    public AppException(String msg)
    {
        super(msg);
    }

    public AppException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
