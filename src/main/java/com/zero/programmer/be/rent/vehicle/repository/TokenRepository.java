package com.zero.programmer.be.rent.vehicle.repository;

import com.zero.programmer.be.rent.vehicle.entity.MToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<MToken, Long> {

    Optional<MToken> findByTokenAndIsVerifiedAndIsDeleted(String token, boolean isVerified, boolean isDeleted);
}
