import java.io.*;
import java.util.HashMap;

public abstract class TranslateDictionary implements IDictionary {
    HashMap<String, String> dictKeyWord = new HashMap<>();; // словарь
    static File file = new File("dictionaryBase.txt");
    String patternForKey = "";    // рег. выражение для слов языка
    String name = "";
    static boolean appendSavingFile = false;

    protected void openAndReadOrCreateFile(){
        //создание или открытие файла
        try {
            if (file.createNewFile())
                System.out.println("Файл словаря создан");
            else{
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                boolean keyFounded = false;

                String line = reader.readLine();
                while (line != null) {
                    char[] lineArray = line.toCharArray();
                    String key ="";
                    String word = "";
                    for (char ch:lineArray) {
                        if (!keyFounded){
                            if (ch!='\t'){
                                key+=ch;
                            }
                            else{
                                keyFounded=true;
                            }
                        }
                        else{
                            word+=ch;
                        }
                    }
                    if (key.matches(patternForKey)){
                        dictKeyWord.put(key, word);
                    }
                    keyFounded = false;
                    line = reader.readLine();
                }
                System.out.println("Файл открыт и загружен");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void printAll(){

        for (HashMap.Entry entry: dictKeyWord.entrySet()) {
            System.out.println(entry);
        }
    }

    public void addWordAndTranslation(String wordKey, String translationWord) {
        if (wordKey.matches(patternForKey)){
            dictKeyWord.put(wordKey, translationWord);
        }
    }

    public String findByKey(String keyWord) {
        return dictKeyWord.get(keyWord);
    }

    public void removeByKey(String keyWord) {
        dictKeyWord.remove(keyWord);
    }

    public void saveIntoFile() {
        //сохранение в файл

        try(FileWriter writer = new FileWriter(file, appendSavingFile))
        {

            for (HashMap.Entry entry: dictKeyWord.entrySet()) {
                String keyForSave = entry.getKey().toString();
                String translationForSave = entry.getValue().toString();
                String strForSave = keyForSave +'\t'+translationForSave+"\r\n";
                writer.write(strForSave);
            }
            appendSavingFile=!appendSavingFile;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void clearFile(){
        try {
            //пересоздание файла
            if (file.exists()){
                file.delete();
            }
            if (file.createNewFile())
                System.out.println("Файл словаря очищен");
            else{
                System.out.println("Файл не был создан!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName(){
        return name;
    }
}
