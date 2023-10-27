package vn.vti.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.vti.management.entity.AccessInfo;

import java.util.Optional;

@Repository
public interface AccessInfoRepository extends JpaRepository<AccessInfo, Long> {

    Optional<AccessInfo> findByUsername(String username);

    @Query(value = "Select * from AccessInfo Where username = :username and password = :password and active = 1", nativeQuery = true)
    AccessInfo getAccessInfoByLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "Select * from AccessInfo Where id = :userId and active = 1", nativeQuery = true)
    AccessInfo getAccessInfoById(@Param("userId") Long userId);
}
