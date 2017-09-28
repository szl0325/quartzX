package com.szl.quartzx.controller;

import com.szl.quartzx.domain.Result;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    static Logger logger = LogManager.getLogger(JobController.class.getName());

    @RequestMapping("/doLogin")
    @ResponseBody
    public Result doLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> params) throws IOException {
        String userName = MapUtils.getString(params,"username",null);
        String password = MapUtils.getString(params,"password",null);
        if(userName.equals("admin") && password.equals("123")){
            HttpSession session = request.getSession();
            session.setAttribute("user_session_key",userName);
            logger.error("用户{}登录成功！",userName);
            return Result.setSuccess("登录成功！");
        }else {
            logger.error("用户{}登录失败,返回登录页！",userName);
            return Result.setFailure("用户名或密码错误！");
        }
    }

    @RequestMapping(value = "/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        logger.error("用户注销!");
    }
}
