package com.niu.authz;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.RealmFactory;
import org.apache.shiro.realm.jndi.JndiRealmFactory;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.session.mgt.*;
import org.apache.shiro.subject.*;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.subject.support.SubjectRunnable;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName AuthTest
 * @Description TODO
 * @Author admin
 * @Date 2019/12/19 10:14
 * @Version 1.0
 **/
@Slf4j
public class AuthTest {

    @Test
    public void testIni() {
        IniRealm realm = new IniRealm();
        Ini ini =Ini.fromResourcePath("classpath:shiro.ini");
        realm.setIni(ini);
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        // 模拟用户
        AuthenticationToken token =new UsernamePasswordToken("Mark","123456",true);    }
}
