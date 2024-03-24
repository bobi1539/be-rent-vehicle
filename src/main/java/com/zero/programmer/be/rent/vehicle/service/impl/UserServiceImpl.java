package com.zero.programmer.be.rent.vehicle.service.impl;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.MUser;
import com.zero.programmer.be.rent.vehicle.exception.AppException;
import com.zero.programmer.be.rent.vehicle.repository.UserRepository;
import com.zero.programmer.be.rent.vehicle.service.BaseService;
import com.zero.programmer.be.rent.vehicle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl extends BaseService implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUserByEmail(String email) {
        MUser user = findUserByEmail(email);
        return mapUserToResponse(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return findUserByEmail(email);
    }

    private MUser findUserByEmail(String email) {
        return userRepository.findByEmailAndIsDeleted(email, false)
                .orElseThrow(() -> new AppException(GlobalMessage.DATA_NOT_FOUND));
    }
}
