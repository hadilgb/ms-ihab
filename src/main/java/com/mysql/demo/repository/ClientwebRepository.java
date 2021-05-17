package com.mysql.demo.repository;
import com.mysql.demo.model.Clientweb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientwebRepository extends JpaRepository<Clientweb, Long>{
}
