package project.learnsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.learnsecurity.entity.MyUserEntity;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUserEntity, Long> {
    Optional<MyUserEntity> findByUsername(String username);
}
