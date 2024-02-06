package com.project.headbridgeproject.poshStore.repository;

import com.project.headbridgeproject.poshStore.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {
}
