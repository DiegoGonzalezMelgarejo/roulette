package roulette.roulette.application.mapper;

import org.springframework.stereotype.Component;
import roulette.roulette.application.dto.UserDto;
import roulette.roulette.domain.User;

@Component
public class UserMapper {


    public static User createUser(UserDto userDto){
        return  new User(userDto.getId(),userDto.getName(), userDto.getMoney());
    }

    public static UserDto CreaeteUserDto(User user){
        return new UserDto(user.getId(),user.getName(),user.getMoney());
    }
}
