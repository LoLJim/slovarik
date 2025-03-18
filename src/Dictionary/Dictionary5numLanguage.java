package Dictionary;

public class Dictionary5numLanguage extends TranslateDictionary {

    Dictionary5numLanguage(){
        patternForKey = "\\d{5}";
        openAndReadOrCreateFile();
        name = "Цифровой словарь";
    }

}
