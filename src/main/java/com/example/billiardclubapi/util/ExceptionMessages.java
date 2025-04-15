package com.example.billiardclubapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessages {
    public static final String CUE_NOT_EXISTS = "Cue with id %d is not exists";
    public static final String CUE_TYPE_NOT_EXISTS = "Cue type with id %d is not exists";
    public static final String MANUFACTURER_NOT_EXISTS = "Manufacturer with id %d is not exists";
    public static final String BILLIARD_TABLE_NOT_EXISTS = "Billiard table with id %d is not exists";
    public static final String BILLIARD_TABLE_TYPE_NOT_EXISTS = "Billiard table type with id %d is not exists";
    public static final String USER_IS_ALREADY_EXISTS = "User with this username %s is already exists";
    public static final String USER_NOT_EXISTS = "User with id %d is not exists";
    public static final String USER_WITH_USERNAME_NOT_EXISTS = "User with username %s is not exists";
    public static final String SELECTED_CUE_NOT_EXISTS = "Selected cue with id %d is not exists";
    public static final String SELECTED_TABLE_NOT_EXISTS = "Selected billiard table with id %d is not exists";
    public static final String AMOUNT_CUE_EXCEEDED = "Amount of cue to reserve has been exceeded";
    public static final String AMOUNT_BILLIARD_TABLE_EXCEEDED = "Amount of billiard tables to reserve has been exceeded";
    public static final String RESERVE_NOT_EXISTS = "Reserve with id %d is not exists";
    public static final String LIMIT_OF_CUES_EXCEEDED = "The limit of cues for reserved has been exceeded, your limit: %d";
}
