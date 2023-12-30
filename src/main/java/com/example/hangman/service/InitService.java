package com.example.hangman.service;

import com.example.hangman.model.entity.UserRole;
import com.example.hangman.model.enums.UserRoleEnum;
import com.example.hangman.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public InitService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @PostConstruct
    public void Init() {
        if (userRoleRepository.count() == 0) {
            initRoles();
        }
    }


    private void initRoles() {
        UserRole user = new UserRole().setRole(UserRoleEnum.USER);
        UserRole admin = new UserRole().setRole(UserRoleEnum.ADMIN);

        userRoleRepository.save(user);
        userRoleRepository.save(admin);
    }


}
