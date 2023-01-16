package test.event.apiNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.event.apiNews.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {



}
