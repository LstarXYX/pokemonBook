package pokement.lstar.service;

import pokement.lstar.model.User;

import java.util.List;

/**
 * @author L.star
 * @date 2022/2/27 11:17
 */
public interface UserService {
    public int createUser(String username);

    User queryOne(User user);

    Boolean checkUser(String name, String pwd);

    List<User> listUser();
}
