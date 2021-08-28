package com.example.httpheaderauth.security.handler;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class HttpHeaderAuthenticationSuccessHandler
//        extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
////    private ObjectMapper objectMapper = new ObjectMapper();
//    private final RequestCache requestCache = new HttpSessionRequestCache();
//    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request,
//                                        HttpServletResponse response, Authentication authentication) throws IOException {
////            throws IOException, ServletException {
////
//////        writeHeaderAndAccountToHttpServletResponse(
//////                configureHttpServletResponse(httpServletResponse),
//////                retrieveAccountFromAuthentication(authentication)
//////        );
////        setDefaultTargetUrl("https://www.google.com");
//
////        SavedRequest savedRequest = requestCache.getRequest(request, response);
////        if (savedRequest != null) {
////            String targetUrl = savedRequest.getRedirectUrl();
////            redirectStrategy.sendRedirect(request, response, targetUrl);
////        }
////        else {
////            redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
////        }
//    }
////
//////    // TODO: replace Account with UserWithRoles or something else.
//////    private void writeHeaderAndAccountToHttpServletResponse(HttpServletResponse httpServletResponse, Account account) throws IOException {
//////        objectMapper.writeValue(httpServletResponse.getWriter(), account);
//////    }
////
////    private HttpServletResponse configureHttpServletResponse(HttpServletResponse httpServletResponse) {
////        httpServletResponse.setStatus(HttpStatus.OK.value());
////        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
////
////        return httpServletResponse;
////    }
////
//////    private Account retrieveAccountFromAuthentication(Authentication authentication) {
//////        return (Account) authentication.getPrincipal();
//////    }
//
////    public class RefererRedirectionAuthenticationSuccessHandler
////            extends SimpleUrlAuthenticationSuccessHandler
////            implements AuthenticationSuccessHandler {
//
//
//
//}
