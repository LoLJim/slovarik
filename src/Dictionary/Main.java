package Dictionary;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dictionary4lettersLanguage m4lDict = new Dictionary4lettersLanguage(); //Создание словаря, предназначенного для работы со словами длиной 4 символами, состоящими только из букв латинского алфавита
        Dictionary5numLanguage m5nDict = new Dictionary5numLanguage(); //Создание словаря, предназначенного для работы со словами длиной 5 символов, состоящими только из цифр
        TranslateDictionary supportDict = m5nDict; //Текущий словарь
        TranslateDictionary usingDict = m4lDict; //Вспомогательный словарь
        String actionNum = ""; //Хранение номера выбранного действия
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Команды для работы со словарём:");
            System.out.println("1. Сменить словарь. Сейчас используется - " + usingDict.getName());
            System.out.println("2. Добавить запись в словарь");
            System.out.println("3. Удалить запись из словаря по ключу");
            System.out.println("4. Найти запись по ключу");
            System.out.println("5. Вывести содержимое словарей");
            System.out.println("6. Сохранить и выйти. ");
            System.out.print("Введите номер желаемого действия: ");
            while (actionNum.equals("")) {
                actionNum = in.nextLine();
            }

            switch (actionNum) {
                case ("1"): {
                    TranslateDictionary changer = usingDict;
                    usingDict = supportDict;
                    supportDict = changer;
                    break;
                }
                case ("2"): {
                    System.out.println("Введите слово: ");
                    String word = in.next();
                    System.out.println("Введите перевод: ");
                    String translation = in.next();
                    usingDict.addWordAndTranslation(word, translation); //Добавление в словарь
                    break;
                }
                case ("3"): {
                    System.out.println("Введите слово для удаления: ");
                    String word = in.next();
                    usingDict.removeByKey(word);
                    break;
                }
                case ("4"): {
                    System.out.println("Введите слово для поиска: ");
                    String word = in.next();
                    System.out.println("Найденное значение: " + usingDict.findByKey(word));
                    break;
                }
                case ("5"): {
                    usingDict.printAll();
                    supportDict.printAll();
                    break;
                }
                case ("6"): {
                    //MyTranslateDictionaryCore.clearFile();
                    usingDict.saveIntoFile();
                    supportDict.saveIntoFile();
                    break;
                }
            }
            actionNum = ""; //Сброс переменной
        }
    }
}