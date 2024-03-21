package com.zero.programmer.be.rent.vehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class BaseEntity {

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    protected Timestamp createdAt;

    @Column(name = "created_by")
    protected Long createdBy;

    @Column(name = "created_by_name")
    protected String createdByName;

    @Column(name = "updated_at")
    @UpdateTimestamp
    protected Timestamp updatedAt;

    @Column(name = "updated_by")
    protected Long updatedBy;

    @Column(name = "updated_by_name")
    protected String updatedByName;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    protected boolean isDeleted = false;
}
