/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.utilities;

/**
 *
 * @author Ashraf_R
 */
public class DatabaseHelper {

    /*
    * tables names
     */
    public final static class PRODUCT {
        public final static String TABLE_NAME = "PRODUCTS";
        public final static String ID = "PRODUCT_ID";
        public final static String NAME = "PRODUCT_NAME";
        public final static String PRICE = "PRICE";
        public final static String DISCOUNT = "DISCOUNT";
        public final static String QUANTITY = "QUANTITY";
        public final static String CATEGORY_ID = "CATEGORY_ID";
        public final static String DESCRIPTION = "DESCRIPTION";
    }
    
    public final static class USER {
        public final static String TABLE_NAME = "USERS";
        public final static String ID = "USER_ID";
        public final static String FIRST_NAME = "FIRST_NAME";
        public final static String LAST_NAME = "LAST_NAME";
        public final static String EMAIL = "EMAIL";
        public final static String BIRTH_DATE = "BIRTH_DATE";
        public final static String PASSWORD = "PASSWORD";
        public final static String JOB = "JOB";
        public final static String ADDRESS = "ADDRESS";
        public final static String CREDIT_LIMIT = "CREDIT_LIMIT";
        public final static String PROFILE_IMAGE = "PROFILE_IMAGE";
        public final static String PHONE = "PHONE";
        public final static String PRIVILEGE = "PRIVILEGE";
    }
    
    public final static class USER_INTERESTS {
        public final static String TABLE_NAME = "USER_INTERESTES";
        public final static String USER_ID = "USER_ID";
        public final static String CATEGORY_ID = "CATEGORY_ID";
        
    }
    public final static class ProductImages {
         public final static String TABLE_NAME = "PRODUCT_IMAGES";
         public final static String ID = "PRODUCT_IMAGE_ID";
         public final static String PRODUCT_ID = "PRODUCT_ID";
         public final static String IMAGE = "IMAGE";
    }
}
