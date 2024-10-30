package com.bharath.ws.soap.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UTPasswordCallBack implements CallbackHandler {

    private Map<String, String> usernameToPassword = new HashMap<>();

    // felhasználónév jelszó párosok (inmemory database)
    public UTPasswordCallBack() {
        usernameToPassword.put("admin", "admin");
        usernameToPassword.put("laci", "laci");
    }
    @Override
    // megkeressük a felhasználót és a password callbacknek visszadjuk, így nyerünk autentikációt
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        for(Callback callback : callbacks) {
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
            String password = usernameToPassword.get(passwordCallback.getIdentifier());
            if(password != null) {
                passwordCallback.setPassword(password);
                return;
            }
        }
    }
}
