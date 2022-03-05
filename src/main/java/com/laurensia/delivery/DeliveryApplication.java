package com.laurensia.delivery;

import com.laurensia.delivery.item.request.ItemSaveRequest;
import com.laurensia.delivery.item.service.ItemService;
import com.laurensia.delivery.rating.request.RatingSaveRequest;
import com.laurensia.delivery.rating.service.RatingService;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.service.TransactionService;
import com.laurensia.delivery.user.model.User;
import com.laurensia.delivery.user.request.UserSaveRequest;
import com.laurensia.delivery.user.service.UserService;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }
    
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    protected String getSaltNumber() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    protected String getSaltEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr+"@gmail.com";

    }
    
    @Bean
    CommandLineRunner run(UserService userService, ItemService itemService, TransactionService transactionService, RatingService ratingService) {
        return args -> {
            userService.saveUser(new UserSaveRequest(getSaltString(), "Male", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Famale", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Male", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Famale", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Male", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Famale", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Male", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Famale", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Male", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            userService.saveUser(new UserSaveRequest(getSaltString(), "Famale", getSaltNumber(), getSaltNumber(), getSaltEmail(), getSaltString(), "1", "ROLE_CUSTOMER"));
//            
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 100));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 500));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 160));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 130));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 106));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 120));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 700));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 170));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 130));
//            itemService.saveItem(new ItemSaveRequest(getSaltString(), Integer.parseInt(getSaltNumber()), 106));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(1L, 1L, 5, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(1L, 2L, 4, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(1L, 3L, 3, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(1L, 4L, 2, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(1L, 5L, 1, "DEPESAN"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(2L, 1L, 5, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(2L, 2L, 4, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(2L, 3L, 3, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(2L, 4L, 2, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(2L, 5L, 1, "DEPESAN"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(3L, 1L, 5, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(3L, 2L, 4, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(3L, 3L, 3, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(3L, 4L, 2, "DEPESAN"));
//            transactionService.saveTransaction(new TransactionSaveRequest(3L, 5L, 1, "DEPESAN"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(4L, 1L, 5, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(4L, 2L, 4, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(4L, 3L, 3, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(4L, 4L, 2, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(4L, 5L, 1, "SEDANG_MENGANTAR"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(5L, 1L, 5, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(5L, 2L, 4, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(5L, 3L, 3, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(5L, 4L, 2, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(5L, 5L, 1, "SEDANG_MENGANTAR"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(6L, 1L, 5, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(6L, 2L, 4, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(6L, 3L, 3, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(6L, 4L, 2, "SEDANG_MENGANTAR"));
//            transactionService.saveTransaction(new TransactionSaveRequest(6L, 5L, 1, "SEDANG_MENGANTAR"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(7L, 1L, 5, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(7L, 2L, 4, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(7L, 3L, 3, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(7L, 4L, 2, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(7L, 5L, 1, "SELESAI"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(8L, 1L, 5, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(8L, 2L, 4, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(8L, 3L, 3, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(8L, 4L, 2, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(8L, 5L, 1, "SELESAI"));
//            
//            transactionService.saveTransaction(new TransactionSaveRequest(9L, 1L, 5, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(9L, 2L, 4, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(9L, 3L, 3, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(9L, 4L, 2, "SELESAI"));
//            transactionService.saveTransaction(new TransactionSaveRequest(9L, 5L, 1, "SELESAI"));
//            
//            ratingService.saveRating(new RatingSaveRequest(1L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(2L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(3L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(4L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(5L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(6L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(7L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(8L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(9L, 1, getSaltString()));
//            ratingService.saveRating(new RatingSaveRequest(10L, 1, getSaltString()));

        };
    }

}
