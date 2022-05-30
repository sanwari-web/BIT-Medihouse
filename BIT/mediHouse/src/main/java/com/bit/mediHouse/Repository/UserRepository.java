package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer> {

    User getById(Integer id);

    void deleteUserById(Integer id);

    Optional<User> findUserById(Integer id);

    User findByEmail(String email);

    User findByRole(String role);

    Optional<User> findUserByEmail(String email);

    @Query("SELECT count(u.id) as count, u.gender,u.role from user u group by u.gender,u.role")
    public List<User> getusercountbygender();

    @Query("SELECT u from user u where u.role ='Patient' ")
    List<User>  getpatient();

    @Query("SELECT u from user u where u.role ='Doctor' ")
    List<User>  getdoctor();

}
