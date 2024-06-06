package zkd.codes;

import zkd.codes.domain.Vehicle;
import zkd.codes.generic.GenericDAO;
import zkd.codes.generic.IGenericDAO;
import zkd.codes.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static IGenericDAO database;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        database = new GenericDAO(new Civic(), new Corolla(), new Mustang(), new Aventador());

        String answer = menuOfChoices();

        while(!isValidOption(answer)){
            if(answer.isEmpty() || answer == null){
                close();
            }
            errorMessage();
            answer = menuOfChoices();
        }

        while(isValidOption(answer)){
            if (answer.equals("5")) {
                close();
            } else if(answer.equals("4")){
                seeAllVehicles();
            } else if(answer.equals("3")){
                String value = dataResearch();
                Boolean result = removeVehicle(value);
                validatingResult(result);
            } else if(answer.equals("2")){
                String value = dataResearch();
                searchVehicle(value);
            } else if(answer.equals("1")){
                String value = dataResearch();
                addVehicle(value);
            }
            answer = menuOfChoices();
        }

    }
    private static String menuOfChoices() {
        Scanner s = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.out.println("Digite o número de uma das opções:");
        System.out.println("1 - Adicionar veículo a lista(N° Placa)");
        System.out.println("2 - Consultar veículo na lista(N° Placa)");
        System.out.println("3 - Remover veículo da lista(N° Placa))");
        System.out.println("4 - Ver opções de veículos(Data Bank)");
        System.out.println("5 - Fechar Programa");
        System.out.println("--------------------------------------------");
        return s.nextLine();
    }
    private static boolean isValidOption(String answer) {
        try{
            long answerNumber = Long.parseLong(answer);
            if(answerNumber <= 5 && answerNumber >= 1){
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }
    private static void close(){
        System.out.println("Encerrando programa...");
        System.exit(0);
    }
    private static void errorMessage(){
        System.out.println("********************************************");
        System.out.println("Você digitou um valor inválido!");
        System.out.println("********************************************");
    }
    private static void successMessage(){
        System.out.println("--------------------------------------------");
        System.out.println("Sucesso na operação!");
        System.out.println("--------------------------------------------");
    }
    private static void seeAllVehicles(){
        List<Vehicle> vehicleList = database.seeDataBank();
        for(Vehicle object : vehicleList){
            object.informations();
        }
    }
    private static String dataResearch(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o número da placa:");
        return s.nextLine();
    }
    private static void validatingResult(Boolean result){
        if(result.equals(true)){
            successMessage();
        } else{
            errorMessage();
        }
    }
    private static boolean removeVehicle(String value){
        try{
            Long valueInLong = Long.parseLong(value);
            Vehicle object = database.search(valueInLong);
            if(object != null){
                database.remove(valueInLong);
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }

    }
    private static void searchVehicle(String value){
        try{
            Long valueInLong = Long.parseLong(value);
            Vehicle object = database.search(valueInLong);
            if(object != null){
                object.informations();
            } else{
                System.out.println("--------------------------------------------");
                System.out.println("O veículo não se encontra na lista!");
                System.out.println("É aconselhado rever o código no Data Bank.");
                System.out.println("--------------------------------------------");
            }
        } catch (Exception e){
            errorMessage();
        }

    }
    private static void addVehicle(String value){
        try{
            Long valueInLong = Long.parseLong(value);
            Vehicle object = database.searchDB(valueInLong);
            if(object != null){
                Vehicle isObjectInList = database.search(valueInLong);
                if(isObjectInList == null){
                    Boolean result = database.add(object);
                    if(result.equals(true)){
                        successMessage();
                    }else {
                        System.out.println("Houve algum erro na operação! Por favor, reinicie o programa.");
                        System.exit(0);
                    }
                }else {
                    System.out.println("--------------------------------------------");
                    System.out.println("Veículo já se encrontra na lista!");
                    System.out.println("--------------------------------------------");
                }
            } else{
                System.out.println("--------------------------------------------");
                System.out.println("A númeração veículo não existe no Data Bank!");
                System.out.println("--------------------------------------------");
            }
        } catch (Exception e){
            errorMessage();
        }

    }






}
