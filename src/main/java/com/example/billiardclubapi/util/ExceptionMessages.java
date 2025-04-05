package com.example.billiardclubapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessages {
    public static final String WEAPON_NOT_EXISTS = "Weapon with id %d is not exists";
    public static final String WEAPON_REVIEW_NOT_EXISTS = "Weapon review with id %d is not exists";
    public static final String WEAPON_TYPE_NOT_EXISTS = "Weapon type with id %d is not exists";
    public static final String MANUFACTURER_NOT_EXISTS = "Manufacturer with id %d is not exists";
    public static final String ACCESSORY_NOT_EXISTS = "Accessory with id %d is not exists";
    public static final String ACCESSORY_TYPE_NOT_EXISTS = "Accessory type with id %d is not exists";
    public static final String ACCESSORY_REVIEW_NOT_EXISTS = "Accessory review with id %d is not exists";
    public static final String USER_IS_ALREADY_EXISTS = "User with this username %s is already exists";
    public static final String USER_NOT_EXISTS = "User with id %d is not exists";
    public static final String USER_WITH_USERNAME_NOT_EXISTS = "User with username %s is not exists";
    public static final String WEAPON_REVIEWS_NOT_EXISTS = "Reviews for this weapon with id %d are not exists";
    public static final String ACCESSORY_REVIEWS_NOT_EXISTS = "Reviews for this accessory with id %d are not exists";
    public static final String CART_WEAPON_NOT_EXISTS = "Cart weapon with id %d is not exists";
    public static final String CART_ACCESSORY_NOT_EXISTS = "Cart accessory with id %d is not exists";
    public static final String AMOUNT_WEAPON_EXCEEDED = "Amount of weapon to purchase has been exceeded";
    public static final String AMOUNT_ACCESSORY_EXCEEDED = "Amount of accessory to purchase has been exceeded";
}
