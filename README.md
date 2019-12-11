# ImageAuth
Final project report
Shaochong Wang
Project: Image source authentication verifier


main problem to be solved
Today news media are very well developed and self-centered. However, mainstream media station like CNN or FOX in the united states or CCTV in China still holds more reliability than those self reporters. Meanwhile, those self-centered media providers sometimes use untruthful quotes from mainstream media providers which are made up to draw eyeballs or create public panics. It is important that we can verify the date, time the original story for a given picture. Also if the picture is not originally from those so claimed sources, we should be able to detect fake citations.

 major technical solution
This verifier is combining Steganography and asymmetric cryptography technology to provide Image source authentication. 
For each mainstream media station, they will have their unique private key hold on their own. Then they will have their image-specific information prepared in a pre-defined form. {image name;image location;image time;image URL; image notes}.
After the information is ready, it will be encoded using the station holding the private key into an encrypted message. This message will be added to the picture using steganography technology so it does not affect the visualization of the original image. The encryption step is done.
After the encryption, any media can use this image. If a viewer want to verify the truthfulness of this image, they can use the verifier to read the image to get the output information. The user just need to provide the original station name where this image came from, then the verifier will select the matching public key to read the hidden information. If the output does not match the given structure, this means the image is tempered or not from the correct station. Users can also get the original story URL to see if the story matches the one self-centered small media is telling.













Detailed design:

This will be a software that has 3 major functions:
Using a given private key to encrypt message.
Hide the encrypted message into a picture.
Read out the encrypted message given a specific public key.

The program first will generate a keypair in AsymmetricCryptography.java and save them in KeyPair folder as privateKey and publicKey. In the real world, after the key pairs are generated, the trusted publisher such as school officials or news media will keep the private key to themselves and give out the public key to the public. In real application, the trusted publisher can always generate new key pairs and give out a new public key, in case they think the private is leaked somehow to prevent loss.

After the key generation, the publisher now can use their private key to encrypt a message. This message will become an encrypted message that can only be created by the private key holder. The message suggested for this use would include the news title, time, date, location, and some brief extra information that is not a long paragraph. In my program, I set the words limit not to exceed 1024 characters in total. Too many words in the message may affect the quality of the image.

When the encrypted message is created, image steganography will come into play. Now we use image steganography to hide the encrypted message into the original image. This image would be the image that officials can publish to the public.

Now as a general reader or new media creator. As long as no one modifies the original image, the encrypted message will keep hidden inside the image. The best part is that no one but the original owner of this image can edit information inside this image, thus creating the credibility to this image. Any tampering with the original image will remove the information hidden and make it unreadable.

The next step will use a steganography decoder to extract the string hidden inside the image. This string is the encrypted message that only the original publisher can create. After the encrypted message extraction from the image, everyone can use the public key that is given online that everyone can access to decrypt this message. With this message, we can trust that this image is trustable and not modified.



Something may be considered:
It is possible to create store the list of trusted media stations. Then their public keys can be stored in the database. If during the encryption process, code the media station information into the picture will allow us to skip the step that the user needs to provide the station name. The software will automatically read the station name and then use the corresponding public key to read out the message.


Disadvantages:
This encryption method is not robust to jpeg compression. If the image goes through modification of any kind, the message might be lost. This is a disadvantage but may also neglect any temptation of the original image.


How to use the program:
I am using java jre 10.0.2
Make sure in module-info.java , include line “requires java.desktop” because after java 8 the java.awt package is kind of out dated and will not run automatically when system initialize
Run GenerateKeys.java first, this will create a key pair which is private key and public key.
Simply use the imageaddinfo.java to do all operations.
Change theorg_msg to any message you want to add
Change sg.encode to give image file path and image name
Now just run imageaddinfo.java, you will get a image called encrypted.png which is a image that contains the encrypted message
I used a picture from SUNY ALBANY official website as an example, the date this picture is taken is Dec 12 2019.


Some further talk abouts:
This program can provide a trustworthy method to give images “background check”
This still cannot prevent any image modification in the very beginning. If the public official itself is not trustworthy, such as any image modification to do some political propaganda is not preventable by this method. Where actually this method can help strengthen the effect of propaganda since it gives credibility to the source of an image.

Github link:https://github.com/shawn-shaochong/ImageAuth

