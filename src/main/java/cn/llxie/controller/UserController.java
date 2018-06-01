package cn.llxie.controller;

import cn.llxie.config.SystemConfigbean;
import com.github.pagehelper.PageInfo;
import cn.llxie.domain.User;
import cn.llxie.base.ResponseEntity;
import cn.llxie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SystemConfigbean systemConfigbean;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id,@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum) {

        System.out.println("getUser --------user pageNum..."+pageNum);//此处验证参数传递 @PathVariable @RequestParam
        User user = userService.findUserById(id);
        if (user != null){
            return new ResponseEntity.Builder()
                    .status(HttpStatus.OK.value())
                    .body(user)
                    .build();
        }else {
            System.out.println("user not found...");
            return new ResponseEntity.Builder()
                    .status(HttpStatus.OK.value())
                    .body("")
                    .build();
        }
    }

    //ResponseBody 直接将return对象放入response中，该对象必须是bean形式有get和set
    @ResponseBody
    @GetMapping("/all")
    public ResponseEntity<PageInfo<User>> findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        System.out.println("ip "+systemConfigbean.getIp()+" port "+systemConfigbean.getPort());
        return new ResponseEntity.Builder()
                .status(HttpStatus.OK.value())
                .body(userService.findAllUser(pageNum, pageSize))
                .build();
    }
}
