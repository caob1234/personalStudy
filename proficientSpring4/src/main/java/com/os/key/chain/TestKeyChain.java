package com.os.key.chain;

import com.mcdermottroe.apple.OSXKeychain;
import com.mcdermottroe.apple.OSXKeychainException;

public class TestKeyChain {
    public static void main(String[] args) throws OSXKeychainException {
        OSXKeychain keychain = OSXKeychain.getInstance();
        String password = keychain.findGenericPassword("Chrome Safe Storage",
                "Chrome");
        System.out.println(password);
    }
}
