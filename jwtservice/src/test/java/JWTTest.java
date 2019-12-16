import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.KeyPair;
import java.util.Date;

/**
 * @ClassName JWTTest
 * @Description TODO
 * @Author admin
 * @Date 2019/12/15 22:20
 * @Version 1.0
 **/

public class JWTTest {
    private static String compactJws;
    @Test
    public void testJws() {
        Key key = MacProvider.generateKey();
         compactJws = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        System.out.println(compactJws);
        Claims claims= Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody();
        System.out.println(claims.getSubject());

    }

    @Test
    public void test001() {
        JwtBuilder builder= Jwts.builder().setId("888") .setSubject("小白")
                .setIssuedAt(new Date())//设置签发时间
                .signWith(SignatureAlgorithm.HS256,"xiaocai");//设置签名秘钥
        System.out.println( builder.compact() );
    }

    @Test
    public void genKeys() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512
        // 非对称加密
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256); //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512
        String privKey = new String(keyPair.getPrivate().getEncoded());
        System.out.println(privKey);
        // 公钥生成
        System.out.println(new String(keyPair.getPublic().getEncoded()));
    }

}
