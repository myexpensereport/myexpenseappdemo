package com.sp.myexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.myexpense.entity.PayoutHistoryTest;


@Repository
public interface PayoutHistoyRepo  extends JpaRepository<PayoutHistoryTest, Long> {

}
