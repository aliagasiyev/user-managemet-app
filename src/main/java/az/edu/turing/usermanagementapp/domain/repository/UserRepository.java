package az.edu.turing.usermanagementapp.domain.repository;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
