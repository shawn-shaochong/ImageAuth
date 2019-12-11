package imageauthorizer;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

public class imageaddinfo {
//This will use specific key to encrypt a message into image for varification

	public static void main(String [] args)throws Exception
	{
		
		
		AsymmetricCryptography ac = new AsymmetricCryptography();
		PrivateKey privateKey = ac.getPrivate("KeyPair/privateKey");
		PublicKey publicKey = ac.getPublic("KeyPair/publicKey");
		//type messge to be encrypted (photo info in this case)
		String org_msg = "Image source from SUNY Albany; Date 2019 Dec12; www.albany.edu";
		
		
		String encrypted_msg = ac.encryptText(org_msg, privateKey);
		
		
		
		Steganography sg;
		sg = new Steganography(); 

		sg.encode("I:\\study\\660project\\images\\","hero2.jpg",encrypted_msg);
		System.out.print("The message has been encrypted and added into picture");
		
		
		
		
		String reader_encrypted_message=sg.decode("I:\\study\\660project\\images\\encrypted.png");
		System.out.println(reader_encrypted_message);
		
		
		
		String decrypted_msg = ac.decryptText(reader_encrypted_message, publicKey);
		System.out.println("Original Message: " + org_msg + 
			"\nEncrypted Message: " + encrypted_msg +
			"\nReader Encrypted Message: " + reader_encrypted_message 
			+ "\nDecrypted Message: " + decrypted_msg);

		if (new File("KeyPair/text.txt").exists()) {
			ac.encryptFile(ac.getFileInBytes(new File("KeyPair/text.txt")), 
				new File("KeyPair/text_encrypted.txt"),privateKey);
			ac.decryptFile(ac.getFileInBytes(new File("KeyPair/text_encrypted.txt")),
				new File("KeyPair/text_decrypted.txt"), publicKey);
		} else {
			System.out.println("Create a file text.txt under folder KeyPair");
		}
		
	}
	
	
	
}
