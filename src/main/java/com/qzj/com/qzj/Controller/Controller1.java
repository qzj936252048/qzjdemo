package com.qzj.com.qzj.Controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
    public class Controller1 {
        /**
         * 测试接口
         */
        @RequestMapping("/thymeleaf")
        public String thymeleaf(Model model) {
//把数据放入model
            model.addAttribute("name","qzj");
            //返回text
            return "text";
        }
        
        
@RequestMapping("/login")
        public String login (HttpServletRequest request, Model model){
    String name = request.getParameter("name");
    String password = request.getParameter("password");
            System.out.println("name"+name);
            Subject subject= SecurityUtils.getSubject();
    UsernamePasswordToken token =new UsernamePasswordToken(name,password);
    try {
        subject.login(token);
        return "redirect:/thymeleaf";
    } catch (UnknownAccountException e){
        model.addAttribute("msg","用户名不存在");
        return "login";
    }catch (IncorrectCredentialsException e){
        model.addAttribute("msg","密码错误");
        return "login";
    }
        }







    @RequestMapping("/add")

    public String add(){
        return"user/add";
    }

        @RequestMapping("/delete")

    public String delete(){
            return"user/delete";
        }


    @RequestMapping("/insert")

    public String insert(){
        return"user/insert";
    }


    @RequestMapping("/update")

    public String update(){
        return"user/update";
    }
    @RequestMapping("/app")

    public JSONObject app(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("count", "4");
//粉丝数组是嵌套数组
        JSONObject jsonObject1 =new JSONObject();
        jsonObject1.put("name", "nb55");
        jsonObject1.put("price","66246");
        jsonObject1.put("intro","7554");
        jsonObject1.put("image","https://b-ssl.duitang.com/uploads/item/201508/30/20150830105732_nZCLV.jpeg");

        JSONObject jsonObject2=new JSONObject();
        jsonObject2.put("name", "nb55");
        jsonObject2.put("price","66246");
        jsonObject2.put("intro","7554");
        jsonObject2.put("image","https://b-ssl.duitang.com/uploads/item/201508/30/20150830105732_nZCLV.jpeg");
        JSONObject jsonObject3=new JSONObject();
        jsonObject3.put("name", "nb55");
        jsonObject3.put("price","66246");
        jsonObject3.put("intro","7554");
        jsonObject3.put("image","https://b-ssl.duitang.com/uploads/item/201508/30/20150830105732_nZCLV.jpeg");
        JSONObject jsonObject4=new JSONObject();
        jsonObject4.put("name", "nb55");
        jsonObject4.put("price","66246");
        jsonObject4.put("intro","7554");
        jsonObject4.put("image","https://b-ssl.duitang.com/uploads/item/201508/30/20150830105732_nZCLV.jpeg");




//从此处可以看出list和json可以相互转换
        ArrayList<JSONObject> jsonObjects= new ArrayList<JSONObject>();
        jsonObjects.add(jsonObject1);
        jsonObjects.add(jsonObject2);
        jsonObjects.add(jsonObject3);
        jsonObjects.add(jsonObject4);
        jsonObject.put("commdities", jsonObjects);
        return jsonObject;

    }
    }
