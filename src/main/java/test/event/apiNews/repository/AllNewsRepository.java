package test.event.apiNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.event.apiNews.entity.NewsAll;

import java.util.List;

public interface AllNewsRepository extends JpaRepository<NewsAll, Long> {

    //sql запрос для получения всех новостей из всех источников и по всем темам
    @Query(value = "select news.id, source, topic, item from  sources join topics on sources.id=topics.id_source  join news on topics.id=news.id_topic", nativeQuery = true)
    List<NewsAll> findAll();

    //sql запрос для получения новостей по источнику
    @Query(value = "select news.id,source, topic, item from sources join topics on sources.id=topics.id_source join news on topics.id=news.id_topic" +
            " where sources.source=:source", nativeQuery = true)
    List<NewsAll> findAllBySource(@Param("source") String source);


}
