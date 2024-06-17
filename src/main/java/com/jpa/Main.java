package com.jpa;

import com.jpa.domain.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 16-06-2024, Sunday
 **/
public class Main {
    public static void main(String[] args) {
        try (var sessionFactory = Persistence.createEntityManagerFactory("com.jpa.domain");
             EntityManager entityManager = sessionFactory.createEntityManager()) {
            var tansaction = entityManager.getTransaction();
            tansaction.begin();

            entityManager.persist(new Artist("Muthu Selvan"));

            var artistStream = getArtistBuilder(entityManager,"");

            Map<String, Integer> collect = artistStream
                    .limit(10)
                    .collect(Collectors.toMap(Artist::getArtistName,
                            Artist::getArtistId));


            tansaction.commit();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private static Stream<Artist> getArtistBuilder(EntityManager entityManager, String matchedValue) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Artist>  criteriaQuery = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> root = criteriaQuery.from(Artist.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.like(root.get("artistName"), matchedValue))
                .orderBy(criteriaBuilder.asc(root.get("artistName")));
        return entityManager.createQuery(criteriaQuery).getResultStream();
    }

    private static Stream<Artist> getArtistByNativeQuery(EntityManager entityManager, String matchedValue) {
        var query = entityManager.createNativeQuery(
                "SELECT * FROM music.artists WHERE artist_name like ?1",
                Artist.class
        );
        query.setParameter(1, matchedValue);
        return query.getResultStream();
    }
}
