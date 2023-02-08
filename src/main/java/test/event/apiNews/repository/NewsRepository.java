package test.event.apiNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.event.apiNews.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "select * from news where id_topic in (select id from topics where id_source=(select id from sources where source=:source))", nativeQuery = true)
    List<News> findNewsBySource(@Param("source") String source);

    @Query(value = "select * from news where id_topic=(select id from topics where topic=:topicName)", nativeQuery = true)
    List<News> findNewsByTopic(@Param("topicName") String topicName);
}
