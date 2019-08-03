package cn.itsource.common.client;

import cn.itsource.basic.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: aigou-web-demo
 * @Package: cn.itsource.common.client
 * @ClassName: RedisFallBackFactory
 * @Author: Jenoves
 * @Description: ${description}
 * @Date: 2019/8/2 22:41
 * @Version: 1.0
 */
@Component
public class RedisFallBackFactory implements FallbackFactory<RedisClient> {
    @Override
    public RedisClient create(Throwable throwable) {
        return new RedisClient() {
            @Override
            public AjaxResult set(String key, String value) {
                return AjaxResult.me().setSuccess(false).setMessage("系统错误啦！殴打程序员");
            }

            @Override
            public AjaxResult get(String key) {
                return AjaxResult.me().setSuccess(false).setMessage("系统又异常，殴打项目经理");
            }
        };
    }
}
