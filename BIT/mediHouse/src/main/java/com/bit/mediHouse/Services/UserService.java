package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Repository.UserRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserService implements UserDetailsService {



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("javainuse".equals(username)) {
//            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
//       this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);
       if (user== null){
           log.error("User not found");
           throw new UsernameNotFoundException("User not found");
       }else {
           log.info("Login Success! User found :{}",email);

       }
        Collection <SimpleGrantedAuthority>authorities = new ArrayList<>();

       return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

    public User addUser(User user) {
       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User by id " + email + " was not found"));
    }

    public void deleteUser(Integer id){
        userRepository.deleteUserById(id);
    }

    public User getuserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User getuserByRole(String role) {
        return userRepository.findByRole(role);
    }

    public List<User> getusercountbygender() {
        return userRepository.getusercountbygender();
    }

    public List<User> getpatient() {
        return userRepository.getpatient();
    }

    public List<User> getdoctor() {
        return userRepository.getdoctor();
    }
}
