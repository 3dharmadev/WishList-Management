package com.addtowishlist.repository;

import com.addtowishlist.models.User;
import com.addtowishlist.models.User;
import com.addtowishlist.models.WishlistItem;
import com.addtowishlist.repositories.WishlistItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@DataJpaTest
public class WishlistItemRepositoryTest {

    @Mock
    private User user;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Test
    void testFindByUser() {

        WishlistItem item1 = new WishlistItem();
        WishlistItem item2 = new WishlistItem();
        List<WishlistItem> expectedWishlist = List.of(item1, item2);

         wishlistItemRepository.saveAll(expectedWishlist);


        List<WishlistItem> actualWishlist = wishlistItemRepository.findByUser(user);


        assertEquals(expectedWishlist.size(), actualWishlist.size());
        assertEquals(expectedWishlist, actualWishlist);
    }
}
