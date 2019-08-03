package cn.itsource.common.client;

import cn.itsource.basic.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ProjectName: aigou-web-demo
 * @Package: cn.itsource.common.client
 * @ClassName: StaticPageFallBackFactory
 * @Author: Jenoves
 * @Description: ${description}
 * @Date: 2019/8/2 22:42
 * @Version: 1.0
 */
@Component
public class StaticPageFallBackFactory implements FallbackFactory<StaticPageClient> {
    @Override
    public StaticPageClient create(Throwable throwable) {
        return new StaticPageClient() {
            @Override
            public AjaxResult genStaticPage(Map<String, Object> map) {
                return AjaxResult.me().setSuccess(false).setMessage("系统错误啦!");
            }
        };
    }
}