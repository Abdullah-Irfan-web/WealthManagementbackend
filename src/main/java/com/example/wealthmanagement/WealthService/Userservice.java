package com.example.wealthmanagement.WealthService;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.UserMsg;
import com.example.wealthmanagement.WealthDto.UserDto;
import com.example.wealthmanagement.WealthEntities.UserEntity;
import com.example.wealthmanagement.WealthRepo.Userrepositories;

@Service
public class Userservice {
    final Userrepositories UserRepo;
    final ModelMapper modelMapper;
    public Userservice(Userrepositories userRepo, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        UserRepo = userRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }



    final PasswordEncoder passwordEncoder;

  

    public UserMsg createUser(UserDto userdto){

      UserEntity user=UserRepo.findByEmail(userdto.getEmail());

      if(user!=null){
        return  new UserMsg(userdto,"Email Already Exist");
      }

        userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
        UserRepo.save(modelMapper.map(userdto,UserEntity.class));
          return  new UserMsg(userdto,"ok");

    }

    public UserMsg login(UserDto userDto){

      UserEntity user=UserRepo.findByEmail(userDto.getEmail());
      if(user!=null){

          String inputPass=userDto.getPassword();
          String originalPass=user.getPassword();
          boolean isPassCorrect=passwordEncoder.matches(inputPass, originalPass);

          if(isPassCorrect){

            return new UserMsg(modelMapper.map(user,UserDto.class),"Login Successful");

          }
          else{
            return new UserMsg(userDto,"Bad Credentials");
          }



      }
      
        return new UserMsg(userDto,"Email Not Exist");
      
    }
    public UserDto gettotalwealth(String email){
      UserEntity user=UserRepo.findByEmail(email);

      return modelMapper.map(user,UserDto.class);
    }
    

}
