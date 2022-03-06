package pokement.lstar.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pokement.lstar.common.AppException;
import pokement.lstar.mapper.UserMapper;
import pokement.lstar.model.User;
import pokement.lstar.service.UserService;
import pokement.lstar.system.SysConfig;

import java.util.List;

/**
 * @author L.star
 * @date 2022/2/27 11:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int createUser(String username) {
        String salt = RandomUtil.randomString(SysConfig.getInt("random_salt_length", 10));
        User user = new User().setName(username)
                .setSalt(salt)
                .setPwd(DigestUtils.md5DigestAsHex((username+salt).getBytes()));
        return userMapper.insert(user);
    }

    @Override
    public User queryOne(User user) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("name", user.getName()));
    }

    @Override
    public Boolean checkUser(String name, String pwd) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", name));
        if (user == null) {
            throw new AppException("用户名或密码错误");
        }

        if (!checkPwd(pwd, user.getSalt(), user.getPwd())){
            throw new AppException("用户名或密码错误");
        }
        return true;
    }

    //验证密码
    public static Boolean checkPwd(String loginPwd, String salt, String pwd)
    {
        return DigestUtils.md5DigestAsHex((loginPwd + salt).getBytes()).equals(pwd);
    }


    @Override
    public List<User> listUser() {
        return userMapper.selectList(null);
    }
}
