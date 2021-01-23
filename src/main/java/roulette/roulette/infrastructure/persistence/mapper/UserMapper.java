package roulette.roulette.infrastructure.persistence.mapper;

import roulette.roulette.application.dto.UserDto;
import roulette.roulette.domain.User;
import roulette.roulette.infrastructure.persistence.entities.UserEntity;

public class UserMapper {


    public static User createUser(UserEntity userEntity){
        return  new User(userEntity.getId(),userEntity.getName(), userEntity.getMoney());
    }

    public static  UserEntity createUserEntity(User user){
        return new UserEntity(user.getId(),user.getName(),user.getMoney());
    }
}
