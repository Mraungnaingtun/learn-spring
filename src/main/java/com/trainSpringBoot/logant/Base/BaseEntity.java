package com.trainSpringBoot.logant.Base;

import java.time.LocalDateTime;

import com.trainSpringBoot.logant.Enum.RecordStatus;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

   @Column(name = "record_status", nullable = false)
   private int recordStatus;

   @Column(name = "last_modified_date", nullable = false, updatable = true)
   private LocalDateTime updatedDate;

   @Column(name = "created_date", nullable = false, updatable = false)
   private LocalDateTime createdDate;

   @PrePersist
   protected void onCreate() {
      this.createdDate = LocalDateTime.now();
      this.updatedDate = LocalDateTime.now();
   }

   @PreUpdate
   protected void onUpdate() {
      this.updatedDate = LocalDateTime.now();
   }

   public RecordStatus getRecordStatus() {
      return RecordStatus.fromValue(recordStatus);
   }

   public void setRecordStatus(RecordStatus recordStatus) {
      this.recordStatus = recordStatus.getValue();
   }
}
