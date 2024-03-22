package com.zero.programmer.be.rent.vehicle.repository;

import com.zero.programmer.be.rent.vehicle.entity.MRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<MRole, Long> {

    Optional<MRole> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
