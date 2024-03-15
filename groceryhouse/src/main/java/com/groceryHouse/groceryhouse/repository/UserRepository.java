package com.groceryHouse.groceryhouse.repository;

import com.groceryHouse.groceryhouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



    public User findByEmail(String username);

}
