package com.addtowishlist.services;

import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;
import com.addtowishlist.repositories.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {
    @Autowired
    private   WishlistItemRepository wishlistItemRepository;



    @Override
    public List<WishlistItem> getWishlistItemsByUser(User user) {
        return wishlistItemRepository.findByUser(user);
    }

    @Override
    public void addWishlistItem(User user, WishlistItem wishlistItem) {
        wishlistItem.setUser(user);
        wishlistItemRepository.save(wishlistItem);
    }

    @Override
    public void deleteWishlistItem(User user, Integer itemId) {
        wishlistItemRepository.deleteByIdAndUser(itemId, user);
    }
}
