package com.crm.clinicCrm.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository  extends JpaRepository<CommentModel, Long> {
    @Query("SELECT a FROM CommentModel a WHERE a.clientModel.id = :clientId")
    List<CommentModel> findByClientID(UUID clientId);

    @Transactional
    @Query("DELETE FROM CommentModel  WHERE clientModel.id = :clientId")
    void deleteByClientId(UUID clientId);

}
