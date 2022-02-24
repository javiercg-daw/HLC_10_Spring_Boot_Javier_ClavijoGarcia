package com.iesrafaelalberti.hlc_10_springboot_javier_clavijogarcia.services;

public class DNIService {
    public static String letraDNI(String numeroDNI) {
        String[] letrasDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        try {
            int modulo = Integer.parseInt(numeroDNI) % 23;
            return letrasDNI[modulo];
        } catch (Exception e) {
            return "Error: DNI incorrecto";
        }
    }

}
