package test.event.apiNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.event.apiNews.entity.Sources;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Sources, Long> {
    // запрос для получения всех источников
    List<Sources> findAll();
}
