/**
 *
 */
package com.laurensia.delivery.item.repository;

import com.laurensia.delivery.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
