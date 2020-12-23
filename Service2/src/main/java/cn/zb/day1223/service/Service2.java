package cn.zb.day1223.service;

import cn.zb.day1223.constant.MyConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zb
 */
@RequestMapping("/Service2")
@RestController
public class Service2 {
    @GetMapping(path = "/getTwo")
    public String getTwo() {
        int num = MyConstant.sleep();
        return "Name:s2"+ "; TakeTime(Sec):"+num;
    }
}
