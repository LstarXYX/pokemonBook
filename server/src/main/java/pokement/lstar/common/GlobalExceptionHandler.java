package pokement.lstar.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pokement.lstar.model.Result;

/**
 * @author L.star
 * @date 2022/2/26 20:52
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public Result appExceptionHandler(AppException e)
    {
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result allException(Exception e)
    {
        return Result.fail(e.getMessage());
    }

}
