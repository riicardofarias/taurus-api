package br.com.gransistemas.taurus.util;

import br.com.gransistemas.taurus.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ricardo.lima on 22/05/19.
 */
@Component
@RequestScope
public class UserContext {
    private User user;
    private User parentUser;

    public long getId(){
        return user.getId();
    }

    public long getParentId(){
        return parentUser.getId();
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public User getParentUser() { return parentUser; }
    public void setParentUser(User parentUser) { this.parentUser = parentUser; }

    public List<User> getUsers(){
        if(parentUser == null)
            return Collections.singletonList(user);

        return Arrays.asList(user, parentUser);
    }
}
