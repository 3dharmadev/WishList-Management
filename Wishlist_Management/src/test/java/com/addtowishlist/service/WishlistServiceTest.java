package com.addtowishlist.service;

import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;
import com.addtowishlist.repositories.WishlistItemRepository;
import com.addtowishlist.services.WishlistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WishlistServiceTest {

    @Mock
    private WishlistItemRepository wishlistItemRepository;

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getWishlistItemsByUser() {

        User user = new User();
        WishlistItem item1 = new WishlistItem();
        WishlistItem item2 = new WishlistItem();
        List<WishlistItem> wishlistItems = new ArrayList<>();
        wishlistItems.add(item1);
        wishlistItems.add(item2);

        when(wishlistItemRepository.findByUser(user)).thenReturn(wishlistItems);

        // Act
        List<WishlistItem> result = wishlistService.getWishlistItemsByUser(user);

        // Assert
        assertEquals(wishlistItems, result);
        verify(wishlistItemRepository, times(1)).findByUser(user);
    }

    @Test
    void addWishlistItem() {

        User user = new User();
        WishlistItem wishlistItem = new WishlistItem();


        wishlistService.addWishlistItem(user, wishlistItem);


        verify(wishlistItemRepository, times(1)).save(wishlistItem);
        assertEquals(user, wishlistItem.getUser());
    }

    @Test
    void deleteWishlistItem() {

        User user = new User();
        Integer itemId = 1;

        wishlistService.deleteWishlistItem(user, itemId);

        verify(wishlistItemRepository, times(1)).deleteByIdAndUser(itemId, user);
    }
}


