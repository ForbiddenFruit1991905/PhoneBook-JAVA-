package sixth.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBookCopy {
    private final TreeMap<String, ArrayList<Integer>> phoneBook;
    public static void main(String[] args) {

        PhoneBookCopy phoneBook = new PhoneBookCopy();
        
            Boolean flagAction = true;
            Scanner scanner = new Scanner(System.in);
            while(flagAction){
                System.out.println("Укажете действие:");
                String action = scanner.nextLine(); 
                
                if (action.equals("1")){
                    System.out.println("Укажете имя контакта:");
                    String name = scanner.nextLine(); 
                    System.out.println("Укажете номер телефона:");
                    int phoneNumber = scanner.nextInt();    
                    System.out.println("Контакт сохранен и/или добавлен доп.номер телефона ---> " + name + ": " + phoneNumber);
                    phoneBook.addContact(name, phoneNumber);
                }
                else if(action.equals("2")){
                    System.out.println("Укажете имя контакта");
                    String searchName = scanner.nextLine(); 
                    System.out.println(phoneBook.getAllContacts(searchName));
                }
                else if(action.equals("3")){
                    System.out.println("Укажете имя контакта");
                    String delName = scanner.nextLine();
                    System.out.println("Удаление контакта: " + phoneBook.removeContact(delName));
                }
                else if(action.equals("4")){                    
                    System.out.println("Список контактов: " + phoneBook.getPhoneBook().toString().replace("{","").replace("}",""));                    
                }            
                else if(action.equals("q")){
                    System.out.println("Выход из программы");
                    flagAction = false;                      
                }
                else{
                    continue;
                }                
            }    
            scanner.close();           
    }      
    
        public PhoneBookCopy() {            
            this.phoneBook = new TreeMap<>(Collections.reverseOrder()/*(a, b) -> b.compareTo(a)*/); 
        }
    
        // Добавление нового контакта и/или номера телефона(вводить через запятую)
        public void addContact(String name, Integer phoneNumber) {
            // phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
            phoneBook.putIfAbsent(name, new ArrayList<>());
            phoneBook.get(name).add(phoneNumber);            
        }
           
        // Получение списка телефонов по имени
        public List<Integer> getAllContacts(String name) {
            return phoneBook.getOrDefault(name, new ArrayList<>());           
        }

        // Удаление контакта
        public List<Integer> removeContact(String name) {
            return phoneBook.remove(name);
        }

        // Функция показывает весь список контактов
        public TreeMap<String, ArrayList<Integer>> getPhoneBook() {   
            // sortByValue 
            // List<Integer> phoneNum = new ArrayList<>(phoneBook.values());
            // Collections.sort(phoneNum.values());                                                                  
            return phoneBook;                    
        }       
}


        