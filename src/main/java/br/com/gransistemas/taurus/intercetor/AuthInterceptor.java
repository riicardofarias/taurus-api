package br.com.gransistemas.taurus.intercetor;

import br.com.gransistemas.taurus.config.SpringContext;
import br.com.gransistemas.taurus.model.User;
import br.com.gransistemas.taurus.util.Success;
import br.com.gransistemas.taurus.util.UserContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    private HttpServletResponse response;
    private UserContext userContext;
    private String[] allows = {};

    public AuthInterceptor() {
        userContext = SpringContext.getBean(UserContext.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.response = response;

        // Check free routes
        for(String route: allows){
            if(request.getRequestURI().matches(route)){
                return true;
            }
        }

        // Token de acesso
        String token = request.getHeader("authorization");

        // Valida o token de acesso
        try{
            userContext.setUser(new User(1L));
        }catch (Exception e){
            return responseWithError();
        }

        return true;
    }

    private boolean responseWithError() throws IOException {
        Success success = new Success();

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write(success.asJson());

        return false;
    }
}
