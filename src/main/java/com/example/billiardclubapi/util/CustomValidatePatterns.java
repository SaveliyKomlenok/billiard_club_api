package com.example.billiardclubapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomValidatePatterns {
    public static final String NAME_PATTERN = "^[а-яА-Я]{2,}\\s?-?[а-яА-Я]{2,}$";
}

