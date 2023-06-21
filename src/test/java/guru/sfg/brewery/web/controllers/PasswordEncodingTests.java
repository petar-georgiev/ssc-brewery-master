package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncodingTests {
    static final String PASSWORD1 = "password";
    static final String PASSWORD2 = "tiger";
    static final String PASSWORD3 = "guru";

    @Test
    void testBcrypt(){
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        System.out.println(bcrypt.encode(PASSWORD3));
        System.out.println(bcrypt.encode(PASSWORD3));
    }

    @Test
    void testSha256(){
        PasswordEncoder sha256 = new StandardPasswordEncoder();
        System.out.println(sha256.encode(PASSWORD2));
        System.out.println(sha256.encode(PASSWORD2));
    }

    @Test
    void testLdap(){
        PasswordEncoder ldap = new LdapShaPasswordEncoder();
        System.out.println(ldap.encode(PASSWORD1));
        System.out.println(ldap.encode(PASSWORD1));
    }

}
