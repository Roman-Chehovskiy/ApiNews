package test.event.apiNews.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Repository;
import test.event.apiNews.entity.News;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class NewsRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public List<News> findNewsByTopic(String topicName) {
        Query query = entityManager.createQuery("from News where idTopic=(select id from Topic where topic=:topicName)").setParameter("topicName", topicName);
        List<News> newsList = query.getResultList();
        return newsList;
    }

    @Transactional
    public List<News> findNewsBySource(String source) {
        Query query = entityManager.createQuery("from News where idTopic in\n" +
                "(select id from Topic where idSource=(select id from Sources where source=:source))")
                .setParameter("source", source);
        List<News> newsList = query.getResultList();
        return newsList;
    }
}
