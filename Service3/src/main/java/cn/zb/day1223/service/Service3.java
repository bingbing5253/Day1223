package cn.zb.day1223.service;

import cn.zb.day1223.constant.MyConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zb
 */
@RequestMapping("/Service3")
@RestController
public class Service3 {
    @GetMapping(path = "/getThree")
    public String getThree() {
        int num = MyConstant.sleep();
        return "Name:s3"+ "; TakeTime(Sec):"+num;
    }
}
