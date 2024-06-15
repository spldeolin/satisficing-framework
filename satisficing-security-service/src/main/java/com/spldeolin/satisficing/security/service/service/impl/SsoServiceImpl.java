package com.spldeolin.satisficing.security.service.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.common.hash.Hashing;
import com.spldeolin.satisficing.security.client.exception.UnauthcRequestException;
import com.spldeolin.satisficing.security.client.javabean.LoginSession;
import com.spldeolin.satisficing.security.client.javabean.req.IsLoginReqDto;
import com.spldeolin.satisficing.security.client.javabean.resp.IsLoginRespDto;
import com.spldeolin.satisficing.security.service.entity.UserEntity;
import com.spldeolin.satisficing.security.service.javabean.req.LoginByCodeReqDto;
import com.spldeolin.satisficing.security.service.javabean.req.LoginReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.LoginByCodeRespDto;
import com.spldeolin.satisficing.security.service.javabean.resp.LoginRespDto;
import com.spldeolin.satisficing.security.service.mapper.UserMapper;
import com.spldeolin.satisficing.security.service.service.SsoService;
import com.spldeolin.satisficing.service.exception.BizException;
import com.ulisesbocchio.jasyptspringboot.encryptor.SimpleAsymmetricByteEncryptor;
import com.ulisesbocchio.jasyptspringboot.encryptor.SimpleAsymmetricConfig;
import com.ulisesbocchio.jasyptspringboot.util.AsymmetricCryptography;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Deolin 2024-05-31
 */
@Service
@Slf4j
public class SsoServiceImpl implements SsoService {

    private static final String codeForTokenKeyPrefix = "codeForToken:";

    private static final String loginSessionKeyPrefix = "loginSession:";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedissonClient redissonClient;

    @Value("${satisficing-security.loginExpirationSeconds:7200}")
    private Long loginExpirationSeconds;

    @Override
    public LoginRespDto login(LoginReqDto req) {
        // 获取用户
        UserEntity user = getUserByPrincipal(req.getPrincipal());
        if (user == null) {
            log.info("用户不存在");
            throw new BizException("登录信息或密码错误");
        }

        SimpleAsymmetricConfig config = new SimpleAsymmetricConfig();
        config.setPrivateKey(
                "-----BEGIN PRIVATE KEY-----\n" + "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDIdCjrm0NX0s2v\n"
                        + "8fLufSXvBktF0cdW2PXUy7qrcLxNOy5a95lLYyg71ef84gukdwXwhxaqwbfB8AGh\n"
                        + "F4LgavO9c8e1cckvhmPxBoFCXFe52MGnPR4rGvszoij2R1SrTZp8N6vEUeD4wL4r\n"
                        + "of3NnFb62MdECHL/Buht+63MPP13Geafh/3hbz7LX/d8Fsw+Ici4GlrehGm1x4R0\n"
                        + "gtGqUkokA/MLbZemoPqKcReJNndLv7WEk7y4stmQdXmDCw1YugGQSkS0348AEzC+\n"
                        + "6MZimZ/jag+xJgQh9215CscZchVrBPM5mZD51P00EfzwSjKIin/wcsnFFruakGbU\n"
                        + "F5Im64QnAgMBAAECggEAEi425+eVHAoKjcKr/eVr41n2ycZVBhN3eG1h6Nq4uWh8\n"
                        + "s9NxG91KcOLdv5ng5HHHICGgdKxNNlHGVA4F2MTahnxRyKshTCYsOlgUsSge7MQ0\n"
                        + "DC8G5XH1BqHWhT/C9iZ7tHh4I74pYWZZ2StAEb30RZwTtp/tjiPaQN9qy/NcKckO\n"
                        + "URRwaW7gIuolryqWfvd0+MU3i7h+eb5M9hrSaPM/Pj2BPWyKSiTJZW2qxe6nPeMb\n"
                        + "ST80/fWkoPtx0clAqgGgbIpmHD19+tf2dX67TrHTDCYYPpKiJckc58Uu3gACPvs4\n"
                        + "mZrfyxvw5x2UVFR7DRGRChLMrERTDzR0p27bZMkEAQKBgQD5gcgYjgFLrnWcqHEd\n"
                        + "kIdb/A7zLnOaDZeXS7oUBxnOf2XjDGrIBdJLCchWftDPZQYBnmEWDPNIXcQ4hP4a\n"
                        + "z3B7yEUwUkWm1w74blh80YAD+cJJ9aTcmD8EiuiADIRwKG0f/2bCJFAAE0u3bjaz\n"
                        + "qUDbbJn9W2ynMUreZTtnZG9lZwKBgQDNq5XL68A6s7rH/gPYTTe2zYW0041xf6tU\n"
                        + "rcoYx9gAOvsc9n4sBiUD0luQ/kbEpdlZyM3GJZru+X58B5DN36udSiNJKOgGHxz4\n"
                        + "rr8ciq1Yd+erWH62KcuWt5rtrNj2Rc2Xwc0bEPc00DcioFyREQxk9hJkZi0JlAQ/\n"
                        + "OJ1WXE7zQQKBgQCxE5qfUqk4vShbdnBROzHV5p31mRISU3MyvVviuudl1qTI7xcZ\n"
                        + "vofxGZBFUtt/VYNdwrnEnIxM379THY/6Fx8NuqTgFoO4VQka57WFYGoqaCertdq7\n"
                        + "dJHE95Dqz/duYkKQYwLa5kqgwxEJrf7Eo2qUUA858Ji8UA+CpvXx+yXUIQKBgDzz\n"
                        + "YrtCLH+5D9uA/ea2S5KTKdLC9yHxsfawYjohz3OSByU4L4Agegu95YD8ukBA3j7r\n"
                        + "cYANWPMFYWSkYVeBt7wvYnGl+80En3NbZiuxNVoIftGaskKN9FXAJ9vT46BoY1tc\n"
                        + "BcrFpl0yb4SFfalIIiIxgpXaafJyuSd7QbV8ObGBAoGBAK1DDh4uG4uj63pz2PG9\n"
                        + "LNlnWqGVyVayaEZAqiChWqA7xpNnKexZfty12hVpMd8BFObMPC/ppDwdxpC6LBe5\n"
                        + "vVCjJg6VAPYTBkcF8su+SGyC1XuG7gj5tDU1c0qaGaOdJNP9Fnr++Uv+2dv0gvVJ\n"
                        + "DadTB+mBi+ZOv4YYUs/sw1uy\n" + "-----END PRIVATE KEY-----\n");
        config.setKeyFormat(AsymmetricCryptography.KeyFormat.PEM);
        SimpleAsymmetricByteEncryptor encryptor = new SimpleAsymmetricByteEncryptor(config);
        String inputPassword = new String(encryptor.decrypt(Base64.getDecoder().decode(req.getPassword())),
                StandardCharsets.UTF_8);

        // 匹配密码
        if (!matchPassword(inputPassword, user)) {
            log.info("密码错误");
            throw new BizException("登录信息或密码错误");
        }

        // 创建loginSession
        String token = UUID.randomUUID().toString();
        LoginSession loginSession = new LoginSession();
        loginSession.setToken(token);
        loginSession.setLoginUserUuid(user.getUserUuid());
        loginSession.setLoginUserName(user.getUsername());

        // 缓存loginSession
        RBucket<LoginSession> bucket = redissonClient.getBucket(loginSessionKeyPrefix + token);
        bucket.set(loginSession, loginExpirationSeconds, TimeUnit.SECONDS);

        // 生成code
        String code = generateCode(req.getNeedCode(), token);

        return new LoginRespDto().setCode(code).setToken(token);
    }

    @Override
    public LoginByCodeRespDto loginByCode(LoginByCodeReqDto req) {
        RBucket<String> codeBucket = redissonClient.getBucket(codeForTokenKeyPrefix + req.getCode());
        String token = codeBucket.getAndDelete();
        if (token == null) {
            log.info("token absent, code={}", req.getCode());
            throw new UnauthcRequestException("登录已失效，请重新登录");
        }
        LoginSession loginSession = this.parseToken(token);
        if (loginSession == null) {
            log.info("loginSession absent, code={}", req.getCode());
            throw new UnauthcRequestException("登录已失效，请重新登录");
        }
        return new LoginByCodeRespDto().setToken(token);
    }

    @Override
    public IsLoginRespDto isLogin(IsLoginReqDto req) {
        LoginSession loginSession = this.parseToken(req.getToken());
        String code = this.generateCode(req.getNeedCode(), req.getToken());
        return new IsLoginRespDto().setIsLogin(loginSession != null).setCode(code).setLoginSession(loginSession);
    }

    @Override
    public void logout() {
        if (LoginSession.getCurrent() != null) {
            String token = LoginSession.getCurrent().getToken();
            redissonClient.getKeys().delete(loginSessionKeyPrefix + token);
        }
    }

    private UserEntity getUserByPrincipal(String principal) {
        return userMapper.getByUsernameOrMobile(principal, principal);
    }

    private boolean matchPassword(String password, UserEntity user) {
        return Hashing.sha256().hashString(password + user.getSalt(), StandardCharsets.UTF_8).toString()
                .equals(user.getPassword());
    }

    private LoginSession parseToken(String token) {
        if (token == null) {
            return null;
        }
        RBucket<LoginSession> bucket = redissonClient.getBucket(loginSessionKeyPrefix + token);
        LoginSession loginSession = bucket.get();
        return loginSession;
    }

    private String generateCode(Boolean needCode, String token) {
        String code = null;
        if (needCode != null && needCode) {
            code = UUID.randomUUID().toString();
            redissonClient.getBucket(codeForTokenKeyPrefix + code).set(token, 10, TimeUnit.MINUTES);
        }
        return code;
    }

}
