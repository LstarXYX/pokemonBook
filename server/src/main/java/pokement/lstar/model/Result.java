package pokement.lstar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author L.star
 * @date 2022/2/26 20:44
 */
@Data
@ToString
@Accessors(chain = true)
public class Result implements Serializable {
    private Result(){}

    /**
     * 结果码
     */
    public enum ReturnCode
    {
        //成功
        SUCCESS(0),
        //需要登陆
        NEED_LOGIN(101),
        //失败
        FAIL(100);

        public Integer code;

        ReturnCode(int code) {
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    @JsonProperty(value = "code")
    private int code;
    @JsonProperty(value = "msg")
    private String msg;
    @JsonProperty(value = "data")
    private Object data;

    public static Result success()
    {
        return new Result().setCode(ReturnCode.SUCCESS.code).setMsg("成功");
    }

    public static Result success(String msg)
    {
        return new Result().setCode(ReturnCode.SUCCESS.code).setMsg(msg);
    }

    public static Result success(String msg, Object data) {
        return new Result().setCode(ReturnCode.SUCCESS.code).setMsg(msg).setData(data);
    }

    public static Result success(Object data){
        return new Result().setCode(ReturnCode.SUCCESS.code).setMsg("成功").setData(data);
    }

    public static Result fail()
    {
        return new Result().setCode(ReturnCode.FAIL.code).setMsg("失败");
    }

    public static Result fail(String msg)
    {
        return new Result().setCode(ReturnCode.FAIL.code).setMsg(msg);
    }

}
