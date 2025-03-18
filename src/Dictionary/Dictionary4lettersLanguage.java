package Dictionary;

public class Dictionary4lettersLanguage extends TranslateDictionary {

    Dictionary4lettersLanguage(){
        patternForKey = "[a-zA-Z]{4}";
        openAndReadOrCreateFile();
        name = "Алглобуквенный словарь";
    }

}