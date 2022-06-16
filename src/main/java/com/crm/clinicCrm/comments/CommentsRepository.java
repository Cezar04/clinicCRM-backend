package com.crm.clinicCrm.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsModel, UUID> {
    List<CommentsModel> findByClientId(UUID clientId);
    Optional<CommentsModel> deleteByClientId(UUID clientId);
    void deleteById(UUID commentId);
    boolean existsByClientId(UUID clientId);

}
