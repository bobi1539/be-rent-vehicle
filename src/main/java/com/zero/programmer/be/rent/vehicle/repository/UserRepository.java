package com.zero.programmer.be.rent.vehicle.repository;

import com.zero.programmer.be.rent.vehicle.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MUser, Long> {

    Optional<MUser> findByEmailAndIsDeleted(String email, boolean isDeleted);
}
