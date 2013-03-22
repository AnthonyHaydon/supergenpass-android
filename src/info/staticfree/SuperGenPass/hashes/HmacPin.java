package info.staticfree.SuperGenPass.hashes;

import info.staticfree.SuperGenPass.PasswordGenerationException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import android.content.Context;

public class HmacPin extends DomainBasedHash {
	
    public HmacPin(DomainResolver resolver) {
		super(resolver);
	}

	@Override
    public String generate(String masterPass, String domain, int length)
            throws PasswordGenerationException {
        try {
            final Mac mac = Mac.getInstance("hmac");
            final PBEKeySpec pbeKey = new PBEKeySpec(masterPass.toCharArray());
            final Key k = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(pbeKey);

            mac.init(k);
            // TODO figure out how to use PBEKey here

        } catch (final NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
