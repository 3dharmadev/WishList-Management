package com.addtowishlist.controller;

import com.addtowishlist.controllers.WishlistController;
import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;
import com.addtowishlist.services.UserService;
import com.addtowishlist.services.WishlistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    @Mock
    private UserService userService;

    @InjectMocks
    private WishlistController wishlistController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public WishlistControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWishlistItems() {
        // Arrange
        String username = "testUser";
        User user = new User();
        user.setUsername(username);

        WishlistItem item1 = new WishlistItem();
        WishlistItem item2 = new WishlistItem();
        List<WishlistItem> wishlistItems = Arrays.asList(item1, item2);

        when(userService.findByUsername(username)).thenReturn(user);
        when(wishlistService.getWishlistItemsByUser(user)).thenReturn(wishlistItems);

        // Act
        ResponseEntity<List<WishlistItem>> responseEntity = wishlistController.getWishlistItems(username);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(wishlistItems, responseEntity.getBody());
        verify(userService, times(1)).findByUsername(username);
        verify(wishlistService, times(1)).getWishlistItemsByUser(user);
    }

    @Test
    void testAddWishlistItem() throws Exception {
        // Arrange
        String username = "testUser";
        User user = new User();
        user.setUsername(username);

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setItemName("Test Item");

        when(userService.findByUsername(username)).thenReturn(user);

        // Act
        ResponseEntity<String> responseEntity = wishlistController.addWishlistItem(username, wishlistItem);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Wishlist item added successfully", responseEntity.getBody());
        verify(userService, times(1)).findByUsername(username);
        verify(wishlistService, times(1)).addWishlistItem(user, wishlistItem);
    }

    @Test
    void testDeleteWishlistItem() {

        String username = "testUser";
        Integer itemId = 1;
        User user = new User();
        user.setUsername(username);

        when(userService.findByUsername(username)).thenReturn(user);


        ResponseEntity<String> responseEntity = wishlistController.deleteWishlistItem(username, itemId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Wishlist item deleted successfully", responseEntity.getBody());
        verify(userService, times(1)).findByUsername(username);
        verify(wishlistService, times(1)).deleteWishlistItem(user, itemId);
    }

}
