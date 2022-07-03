package com.example.dripteens.repository;

import com.example.dripteens.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<UserModel, BigInteger> {

    UserModel findById(int id);

    void deleteById(int id);
}
