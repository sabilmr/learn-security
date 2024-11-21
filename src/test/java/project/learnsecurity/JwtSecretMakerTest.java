package project.learnsecurity;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;

public class JwtSecretMakerTest {

    @Test
    public void generateSecretKey() {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\nKey = [%s]\n", encodedKey);
    }
}
