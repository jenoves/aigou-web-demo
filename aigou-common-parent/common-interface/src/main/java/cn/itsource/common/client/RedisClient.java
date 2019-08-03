package cn.itsource.common.client;

import cn.itsource.basic.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: aigou-web-demo
 * @Package: cn.itsource.common.client
 * @ClassName: RedisClient
 * @Author: Jenoves
 * @Description: ${description}
 * @Date: 2019/8/2 22:41
 * @Version: 1.0
 */
@FeignClient(value = "COMMON-SERVICE",fallbackFactory = RedisFallBackFactory.class)
public interface RedisClient {

    @PostMapping("/redis")
    public AjaxResult set(@RequestParam("key") String key, @RequestParam("value")String value);

    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    @GetMapping("/redis")
    public AjaxResult get(@RequestParam("key")String key);

}
