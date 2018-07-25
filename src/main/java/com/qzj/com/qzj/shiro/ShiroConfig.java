package com.qzj.com.qzj.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //上spring知道有这个
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterMap=new LinkedHashMap<String, String>();
      filterMap.put("/add","authc");
        filterMap.put("/update","authc");


      filterMap.put("/thymeleaf","anon");
      filterMap.put("/login","anon");
        shiroFilterFactoryBean.setSuccessUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean(name="userRealm")
    public  UserRealm getRealm(){
        return  new UserRealm();
    }
}
