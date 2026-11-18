package com.practice.java8.Base64;

import java.util.Base64;

public class EncodingAndDecoding {
    public static void main(String[] args) {
        String encoded = Base64.getEncoder().encodeToString("Bye".getBytes());
        System.out.println(encoded);

        String encodedBye="Qnll";
        String result = new String(Base64.getDecoder().decode(encodedBye));
        System.out.println(result);

    }
}
