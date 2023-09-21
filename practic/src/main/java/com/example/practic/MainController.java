package com.example.practic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField text;

    @FXML
     void onButtonClick( ActionEvent event) {
        CaesarCipher ca = new CaesarCipher();
        int offset = 1;
        System.out.println(ca.cipher(String.valueOf(text.getText()),offset));
    }

        public class CaesarCipher {
            StringBuilder cipher(String text, int offset) {
                StringBuilder result = new StringBuilder();
                for (char character : text.toCharArray()) {
                    if (character != ' ') {
                        int originalAlphabetPosition = character - 'a';
                        int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                        char newCharacter = (char) ('a' + newAlphabetPosition);
                        result.append(newCharacter);
                    } else {
                        result.append(character);
                    }
                }
                return result;
            }


    }

}