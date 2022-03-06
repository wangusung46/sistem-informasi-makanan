package com.laurensia.delivery.transaction.repository;

import com.laurensia.delivery.transaction.model.Transaction;
import com.laurensia.delivery.transaction.response.TransactionDetailResponse;
import com.laurensia.delivery.transaction.response.TransactionDetailTotalResponse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT t.id AS id, u.id AS idUser, u.name AS nameUser, i.id AS idItem, u.email AS emailUser, i.name AS nameItem, "
            + "t.countItem AS countItem, t.status AS status, t.countItem * i.price AS total, "
            + "COALESCE(r.rate, '0') AS rate, "
            + "COALESCE(r.review, 'Not Review') AS review "
            + "FROM Transaction t "
            + "LEFT JOIN User u ON t.idUser = u.id "
            + "LEFT JOIN Item i ON t.idItem = i.id "
            + "LEFT JOIN Rating r ON t.id = r.idTransaction "
            + "WHERE u.email = (:email) "
            + "ORDER BY t.id DESC")
    public List<TransactionDetailResponse> findByUserTransaction(@Param("email") String email);

    @Query(value = "SELECT t.id AS id, u.id AS idUser, u.name AS nameUser, i.id AS idItem, i.name AS nameItem, "
            + "t.countItem AS countItem, t.status AS status, t.countItem * i.price AS total, "
            + "COALESCE(r.rate, '0') AS rate, "
            + "COALESCE(r.review, 'Not Review') AS review "
            + "FROM Transaction t "
            + "LEFT JOIN User u ON t.idUser = u.id "
            + "LEFT JOIN Item i ON t.idItem = i.id "
            + "LEFT JOIN Rating r ON t.id = r.idTransaction "
            + "ORDER BY t.id DESC")
    public List<TransactionDetailResponse> findByAdminTransaction();

    @Query(value = "SELECT t.id AS id, u.id AS idUser, u.name AS nameUser, i.id AS idItem, i.name AS nameItem, "
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

    @Query(value = "SELECT t.id AS id, "
            + "i.name AS nameItem, "
            + "SUM(t.countItem) AS countItem, "
            + "t.status AS status, "
            + "i.price AS price, "
            + "SUM(t.countItem * i.price) AS total, "
            + "((SUM(COALESCE(r.rate, 0))) / (COUNT(r.rate) * 5)) * 5 AS rate "
            + "FROM Transaction t "
            + "LEFT JOIN Item i ON t.idItem = i.id "
            + "LEFT JOIN Rating r ON t.id = r.idTransaction "
            + "WHERE t.status = 'Complete' "
            + "GROUP BY i.id "
            + "ORDER BY r.id DESC")
    public List<TransactionDetailTotalResponse> findByUserTotalRating();

    @Query(value = "SELECT t.id AS id, u.id AS idUser, u.name AS nameUser, u.email AS emailUser, i.id AS idItem, i.name AS nameItem, "
            + "t.countItem AS countItem, t.status AS status, t.countItem * i.price AS total, "
            + "COALESCE(r.rate, '0') AS rate, "
            + "COALESCE(r.review, 'Not Review') AS review "
            + "FROM Transaction t "
            + "LEFT JOIN User u ON t.idUser = u.id "
            + "LEFT JOIN Item i ON t.idItem = i.id "
            + "LEFT JOIN Rating r ON t.id = r.idTransaction "
            + "ORDER BY t.id DESC")
    public List<TransactionDetailResponse> findByStaffTransaction(@Param("email") String email);
}
