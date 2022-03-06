package pokement.lstar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pokement.lstar.model.User;

/**
 * @author L.star
 * @date 2022/2/27 11:17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
