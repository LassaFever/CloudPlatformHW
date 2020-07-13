package com.fish.repository;

import com.fish.domain.KlassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KlassRepository extends JpaRepository<KlassInfo, Long> {

    public KlassInfo findByName(String name);

    public Optional<KlassInfo> findById(Long id);

}
