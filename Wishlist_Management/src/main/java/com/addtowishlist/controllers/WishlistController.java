package com.addtowishlist.controllers;

import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;
import com.addtowishlist.services.UserService;
import com.addtowishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<List<WishlistItem>> getWishlistItems(@PathVariable String username) {
        User user = userService.findByUsername(username);
        List<WishlistItem> wishlistItems = wishlistService.getWishlistItemsByUser(user);
        return new ResponseEntity<>(wishlistItems, HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> addWishlistItem(@PathVariable String username, @RequestBody WishlistItem wishlistItem) {
        User user = userService.findByUsername(username);
        wishlistService.addWishlistItem(user, wishlistItem);
        return new ResponseEntity<>("Wishlist item added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}/{itemId}")
    public ResponseEntity<String> deleteWishlistItem(@PathVariable String username, @PathVariable Integer itemId) {
        User user = userService.findByUsername(username);
        wishlistService.deleteWishlistItem(user, itemId);
        return new ResponseEntity<>("Wishlist item deleted successfully", HttpStatus.OK);
    }
}
