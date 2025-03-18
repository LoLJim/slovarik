package Dictionary;

public interface iDictionary {
    void printAll();

    void addWordAndTranslation(String wordKey, String translationWord);

    void removeByKey(String keyWord);

    String findByKey(String wordKey);

    void saveIntoFile();

    //static void clearFile(){};
}
