package com.qzj.com.qzj.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
       String name="qzj";
       String password="123";
        UsernamePasswordToken token =(UsernamePasswordToken)arg0;
        if(!token.getUsername().equals(name)){
            return null;//shiro会抛出unknowaccountexception
        }

        return new SimpleAuthenticationInfo("",password,"");
    }
}
