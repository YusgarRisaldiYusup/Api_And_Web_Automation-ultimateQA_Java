package helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class utility {
    public static File getJsonSchemaFile (String filename) {
        return new File("src/test/java/helper/JSONSchema/" + filename);
    }

    public static String generateRandomEmail(){
        String allowedChasrs = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
//        untuk membuat panjang email menjadi 10 karakter
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

}
