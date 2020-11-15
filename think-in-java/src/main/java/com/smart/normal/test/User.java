
package com.smart.normal.test;

import java.io.Serializable;

/**
 * <p>
 *
 * @author <a href="mailto:caob@smartdot.com.cn">caob</a>
 * @version 1.0, 2020/11/12
 */
public class User implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
