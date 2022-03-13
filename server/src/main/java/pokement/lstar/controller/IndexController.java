package pokement.lstar.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pokement.lstar.common.TokenUtil;
import pokement.lstar.model.Pets;
import pokement.lstar.model.Result;
import pokement.lstar.model.wxRecord;
import pokement.lstar.service.PetsService;
import pokement.lstar.service.wxRecordService;
import pokement.lstar.system.SysConfig;

import java.util.List;
import java.util.Map;

/**
 * @author L.star
 * @date 2022/2/26 19:47
 */
@RestController
public class IndexController {

    @Autowired
    private Cache<String, Object> cache;
    @Autowired
    private Map<Object, Object> staticCache;
    @Autowired
    private PetsService petsService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private wxRecordService wxRecordService;

    public static final String BASE_WX_LOGIN_URL =  "https://api.weixin.qq.com/sns/jscode2session?appid=" + SysConfig.getStr("appid")+"&secret="+SysConfig.getStr("secret")+"grant_type=authorization_code&js_code=";

    @GetMapping("/error")
    public Result error()
    {
        return Result.fail("error 未知错误");
    }

    /**
     * 登陆
     * @param code wx.login返回的code
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody String code){
        String url = BASE_WX_LOGIN_URL+code;
        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url, JSONObject.class);
        if (responseEntity.getStatusCode()!= HttpStatus.OK) {
            return Result.fail("登陆失败");
        }

        JSONObject body = responseEntity.getBody();

        if (body.getInteger("errcode") != 0) {
            return Result.fail(body.getString("errmsg"));
        }


        String unionid = body.getString("unionid");
        Integer userId;
        if (!wxRecordService.exist(unionid))
        {
            wxRecord wxRecord = new wxRecord().setUnionId(unionid);
            userId = wxRecordService.createUser(wxRecord);
        }
        else
        {
            wxRecord wxRecord = wxRecordService.queryOne(new wxRecord().setUnionId(unionid));
            userId = wxRecord.getRecId();
        }
        //创建token 关联oepnid和sessionKey
        String token = TokenUtil.createToken(userId);
        String openid = body.getString("openid");
        String sessionKey = body.getString("session_key");
        cache.put(token, openid+":"+sessionKey);

        return Result.success(token);
    }


    /**
     * 获取所有精灵信息列表
     * @return
     */
    @GetMapping("/pets")
    public Result getAll()
    {
        Object o = staticCache.get("pets");
        if (null == o)
        {
            List<Pets> pets = petsService.queryAll();
            staticCache.put("pets", pets);
            return Result.success(pets);
        }
        return Result.success(o);
    }


}
