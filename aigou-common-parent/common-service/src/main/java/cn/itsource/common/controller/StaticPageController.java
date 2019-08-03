package cn.itsource.common.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.VelocityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ProjectName: aigou-web-demo
 * @Package: cn.itsource.common.controller
 * @ClassName: StaticPageController
 * @Author: Jenoves
 * @Description: ${description}
 * @Date: 2019/8/2 22:52
 * @Version: 1.0
 */
@RestController
public class StaticPageController {

    /**
     * 页面静态化
     * @param map model数据 templatePath模板路径 targetPath目标文件路径
     * @return 结果
     */
    @PostMapping("/genStaticPage")
    public AjaxResult genStaticPage(@RequestBody Map<String,Object> map){
        Object model = map.get("model");
        String templatePath = (String) map.get("templatePath");
        String targetPath = (String) map.get("targetPath");
        try {
            VelocityUtils.staticByTemplate(model,templatePath,targetPath);
            return AjaxResult.me().setSuccess(true).setMessage("成功了！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("失败了！"+e.getMessage());
        }
    }

}
