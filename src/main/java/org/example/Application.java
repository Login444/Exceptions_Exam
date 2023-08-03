package org.example;




import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {
    private Scanner intInput = new Scanner(System.in);
    private Scanner stringInput = new Scanner(System.in);

    public void startApp(){
        System.out.println("Введите Ваши данные в следующем формате:\n" +
                "Фамиля Имя Отчество дата рождения номер телефона пол\n" +
                "дата рождения в формате дд.мм.гггг\n" +
                "номер телефона в формате ХХХХХХХХХХХ, без разделителей\n" +
                "пол: 'f' - женский, 'm' - мужской");
        String dataString = stringInput.nextLine();
        while (checkDataStringSize(dataString) !=6){
            if (checkDataStringSize(dataString) == -1){
                System.out.println("Чего-то нехватает, проверьте данные и напишите заново в нужном формате:\n" +
                        dataString);
                dataString = stringInput.nextLine();
            }
            if (checkDataStringSize(dataString) == -2){
                System.out.println("Что-то лишнее, проверьте данные и напишите заново в нужном формате:\n" +
                        dataString);
                dataString = stringInput.nextLine();
            }
        }
        String[] stringArray = dataString.split("\s");
        User user = dataStringTransform(stringArray);
        System.out.println(user);
    }

    public int checkDataStringSize(String dataString){
        String[] stringArray = dataString.split("\s");
        if (stringArray.length < 6){
            return -1;
        }
        if (stringArray.length > 6){
            return -2;
        }
        return stringArray.length;
    }

    public User dataStringTransform(String[] stringArray){
        User user = new User(stringArray[0], stringArray[1], stringArray[2], null, null, null);
        user.setDateOfBirth(checkDate(stringArray[3]));
        user.setPhoneNumber(checkPhone(stringArray[4]));
        user.setSex(checkSex(stringArray[5]));
        return user;
    }

    public LocalDate checkDate(String date){
        try{
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return localDate;
        } catch(DateTimeException e){
            System.out.println("Неверный формат даты, введите заново: ");
            String newDate = stringInput.nextLine();
            LocalDate localDate = LocalDate.parse(newDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return localDate;
        }
    }

    public long checkPhone(String phone){
        try {
            long phoneNumber = Long.parseLong(phone);
            return phoneNumber;
        } catch(NumberFormatException e){
            System.out.println("Неверный формат номера, введите заново: ");
            long validNumber = intInput.nextLong();
            return validNumber;
        }
    }
    // TODO: 02.08.2023 результат выполнения проверки charAt(0), придумать как реализовать саму проверку

    public Character checkSex(String sex){
        if (sex.length() == 1 && (sex.equalsIgnoreCase("f") || sex.equalsIgnoreCase("m"))){
            return sex.charAt(0);
        } else {
            System.out.println("Неверно введен пол, попробуйте еще раз: ");
            sex = stringInput.nextLine();
           return checkSex(sex);
        }
    }
}
