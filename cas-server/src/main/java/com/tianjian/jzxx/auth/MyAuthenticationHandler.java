// package com.tianjian.jzxx.auth;
//
// import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
// import org.apereo.cas.authentication.PreventedException;
// import org.apereo.cas.authentication.UsernamePasswordCredential;
// import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
// import org.apereo.cas.authentication.principal.PrincipalFactory;
// import org.apereo.cas.services.ServicesManager;
//
// import java.security.GeneralSecurityException;
//
// public class MyAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
//     public MyAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
//         super(name, servicesManager, principalFactory, order);
//     }
//
//     @Override
//     protected AuthenticationHandlerExecutionResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential, String originalPassword) throws GeneralSecurityException, PreventedException {
//         return null;
//     }
// }
