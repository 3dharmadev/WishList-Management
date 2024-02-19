package com.addtowishlist.repositories;

import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WishlistItemRepository  extends JpaRepository<WishlistItem, Integer> {
    List<WishlistItem> findByUser(User user);

    void deleteByIdAndUser(Integer itemId, User user);
}
