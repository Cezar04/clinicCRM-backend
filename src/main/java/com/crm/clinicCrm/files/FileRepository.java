package com.crm.clinicCrm.files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;



public interface FileRepository extends JpaRepository<FileModel, Long> {

    @Query("SELECT a FROM FileModel a WHERE a.name = :filename")
    FileModel findByFileName(String filename);

    @Query("SELECT a FROM FileModel a WHERE a.clientId = :clientId")
    List<FileModel> findAllFilesByClientId(UUID clientId);

    @Transactional
    @Modifying
    @Query("DELETE FROM FileModel a WHERE a.name = :filename")
    void deleteByFilename(String filename);
}
