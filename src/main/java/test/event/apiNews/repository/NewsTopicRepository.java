package test.event.apiNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.event.apiNews.entity.NewsTopic;

import java.util.List;

@Repository
public interface NewsTopicRepository extends JpaRepository<NewsTopic, Long> {

    //sql запрос для получения новостей по теме
    @Query(value = "select news.id, topic, item from topics join news on topics.id=news.id_topic" +
            " where topics.topic=:topic", nativeQuery = true)
    List<NewsTopic> findAllByTopic (@Param("topic") String topic);
}
