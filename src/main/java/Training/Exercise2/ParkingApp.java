package Training.Exercise2;

import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) {
        ParkingDAO parkingDAO =  new ParkingDAOImpl();
        Scanner scanner = new Scanner(System.in);
        boolean isWorking = true;

        while (isWorking){
            System.out.println("Aplikacja parkingowa");
            System.out.println("Wybierz opcje");
            System.out.println("1. Utworz parking");
            System.out.println("2. Usun parking");
            System.out.println("3. Dodaj puste miejsce");
            System.out.println("4. Dodaj puste miejsce dla niepelosprawnych");
            System.out.println("5. Usun miejsce");
            System.out.println("6. Zajmij miejsce");
            System.out.println("7. Zwolnij miejsce");
            System.out.println("8. Oznacz miejsce jak odpowiednie dla niepelnosprawnych");
            System.out.println("9. Oznacz miejsce jak odpowiednie dla wszystkich");
            System.out.println("10. Pokaz status miejsca");
            System.out.println("11. Pokaz caly parking");
            System.out.println("0. Wyjdz");
            int option = scanner.nextInt();
            switch (option){
                case 0: {
                    return;
                }
                case 1:{
                    parkingDAO.crateParking();
                    break;
                }
                case 2:{
                    parkingDAO.deleteParking();
                    break;
                }
                case 3:{
                    parkingDAO.createEmptySpot(new ParkingSpot(true,true));
                    break;
                }
                case 4:{
                    parkingDAO.createEmptySpot(new ParkingSpot(true,false));
                    break;
                }
                case 5:{
                    System.out.println("Podaj numer miejsca do usuniecia");
                    int removeX = scanner.nextInt();
                    parkingDAO.deleteSpot(removeX);
                    break;
                }
                case 6:{
                    System.out.println("Podaj numer miejsca do zajecia");
                    int markX = scanner.nextInt();
                    parkingDAO.changeSpotStatus(markX, false);
                    break;
                }
                case 7:{
                    System.out.println("Podaj numer miejsca do zwolnienia");
                    int markY = scanner.nextInt();
                    parkingDAO.changeSpotStatus(markY, true);
                    break;
                }
                case 8:{
                    System.out.println("Podaj numer miejsca które zmienic");
                    int typeX = scanner.nextInt();
                    parkingDAO.changeSpotType(typeX, false);
                    break;
                }
                case 9:{
                    System.out.println("Podaj numer miejsca które zmienic");
                    int typeY = scanner.nextInt();
                    parkingDAO.changeSpotType(typeY, true);
                    break;
                }
                case 10:{
                    System.out.println("Podaj numer miejsca do isnpekcji");
                    int find = scanner.nextInt();
                    System.out.println(parkingDAO.findById(find));
                    break;
                }
                case 11:{
                    System.out.println(parkingDAO.findAll());
                }



            }

        }

    }
}
