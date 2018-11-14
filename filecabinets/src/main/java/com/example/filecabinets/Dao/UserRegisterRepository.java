package com.example.filecabinets.Dao;

import com.example.filecabinets.Model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRegisterRepository  extends JpaRepository<UserRegister,Integer>{
    public List<UserRegister> findByCompany(String company);
    public List<UserRegister> findByPhone(String company);
}
