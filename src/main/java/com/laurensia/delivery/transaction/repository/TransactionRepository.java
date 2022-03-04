package com.laurensia.delivery.transaction.repository;

import com.laurensia.delivery.transaction.model.Transaction;
import com.laurensia.delivery.transaction.response.TransactionDetailResponse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT t.id AS id, u.name AS nameUser, i.name AS nameItem, "
            + "t.countItem AS countItem, t.status AS status, t.countItem * i.price AS total, "
            + "COALESCE(r.rate, '0') AS rate, "
            + "COALESCE(r.review, 'Not Review') AS review "
            + "FROM Transaction t "
            + "LEFT JOIN User u ON t.idUser = u.id "
            + "LEFT JOIN Item i ON t.idItem = i.id "
            + "LEFT JOIN Rating r ON t.id = r.idTransaction "
            + "WHERE t.status = 'Complete' AND u.id = (:userId) "
            + "ORDER BY t.id DESC")
    public List<TransactionDetailResponse> findByUserAndStatus(@Param("userId") Long userId);

    @Query(value = "SELECT t.id AS id, u.name AS nameUser, i.name AS nameItem, "
            + "t.countItem AS countItem, t.status AS status, t.countItem * i.price AS total, "
            + "COALESCE(r.rate, '0') AS rate, "
            + "COALESCE(r.review, 'Not Review') AS review "
            + "FROM Transaction t "
            + "LEFT JOIN User u ON t.idUser = u.id "
            + "LEFT JOIN Item i ON t.idItem = i.id "
            + "LEFT JOIN Rating r ON t.id = r.idTransaction "
            + "WHERE t.status = 'Complete' "
            + "ORDER BY t.id DESC")
    public List<TransactionDetailResponse> findByUser();
}
