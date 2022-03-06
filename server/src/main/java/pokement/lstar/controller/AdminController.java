package pokement.lstar.controller;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pokement.lstar.common.TokenUtil;
import pokement.lstar.model.Pets;
import pokement.lstar.model.Result;
import pokement.lstar.model.User;
import pokement.lstar.service.PetsService;
import pokement.lstar.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author L.star
 * @date 2022/2/27 11:32
 */
@RestController("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private PetsService petsService;
    @Autowired
    private Cache<String, Object> cache;
    @Autowired
    private Map<Object, Object> staticCache;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        userService.checkUser(user.getName(), user.getPwd());

        user = userService.queryOne(user);

        String token = TokenUtil.createToken(user.getName());
        cache.put("admin:"+token, user);
        return Result.success(token);
    }

    @PostMapping("/user")
    public Result createUser(@RequestBody User user)
    {
        return Result.success(userService.createUser(user.getName()));
    }

    @PostMapping("/pet")
    public Result addPet(@RequestBody Pets pets) {
        int recId = petsService.insertPet(pets);
        List<Pets> allPets = petsService.queryAll();
        staticCache.put("pets", allPets);
        return Result.success(recId);
    }

    @PutMapping("/pet")
    public Result updatePet(@RequestBody Pets pets) {
        int success = petsService.updatePet(pets);
        return success == 1 ? Result.success() : Result.fail();
    }

    @DeleteMapping("/pet")
    public Result delPet(Integer recId) {
        int success = petsService.delPet(recId);
        return success == 1 ? Result.success() : Result.fail();
    }

}
