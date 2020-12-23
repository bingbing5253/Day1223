package cn.zb.day1223.service;

import cn.zb.day1223.constant.MyConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zb
 */
@RequestMapping("/Service4")
@RestController
public class Service4 {
    @GetMapping(path = "/getFour")
    public String getFour() {
        int num = MyConstant.sleep();
        return "Name:s4"+ "; TakeTime(Sec):"+num;
    }
}
