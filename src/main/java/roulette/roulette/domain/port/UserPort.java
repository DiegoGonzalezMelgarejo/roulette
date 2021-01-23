package roulette.roulette.domain.port;

import roulette.roulette.domain.User;

public interface UserPort {

    void createUser(User user);
    User findUserById(String id);

}
