package com.addtowishlist.services;

import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;

import java.util.List;

public interface WishlistService {

     List<WishlistItem> getWishlistItemsByUser(User user);

    void addWishlistItem(User user, WishlistItem wishlistItem);

    void deleteWishlistItem(User user, Integer itemId);
}
