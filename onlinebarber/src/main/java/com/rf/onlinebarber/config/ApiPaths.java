package com.rf.onlinebarber.config;

public class ApiPaths {
    public static final   String VERSION="api/v1/";
    public static  final String AUTH=VERSION+"auth/";
    public static final String APPOINTMENT=VERSION+"appointment/";
    public static  final String BARBER=VERSION+"barber/";
    public static  final String MODEL=VERSION+"model/";
    public static  final String CUSTOMER=VERSION+"customer/";
    public static final String SAVE="save";
    public static final String DELETE="delete/{id}";
    public static final String LIST="list";
    public static final String ADD_MODEL="add/{barberId}";
    public static final String MODEL_BY_BARBER="list/{barberId}";
    public static final String CREATE_APPOINTMENT="create/{customerId}/{modelId}";
    public static final String APPOINTMENT_BY_BARBER="list/barber/{id}";
    public static final String APPOINTMENT_BY_CUSTOMER="list/customer/{id}";
    public static final String GET="/{id}";
    public static final String LOGIN="/login";
    public static final String LOGOUT="/logout";

}
