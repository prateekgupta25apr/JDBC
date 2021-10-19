package Controller;

import DAO.MarketDetailsDAO;
import DAO.MarketDetailsDAOImplementation;
import DTO.MarketDetailsDTO;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        MarketDetailsDAO dao=new MarketDetailsDAOImplementation();

        Scanner scanner =new Scanner(System.in);

        byte userChoice;
        char userWish;

        do{
            System.out.println("""
                    Enter
                    1. To enter details of a Market
                    2. To read all the records
                    3. To update number of shops by name
                    4. To get details of shop by location
                    5. To delete details of a market by id""");
            userChoice= scanner.nextByte();
            scanner.nextLine();
            switch (userChoice){
                case 1-> {
                    MarketDetailsDTO dto=new MarketDetailsDTO();

                    System.out.println("Enter id for the market");
                    dto.setId(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Enter name of market");
                    dto.setName(scanner.nextLine());

                    System.out.println("Enter location of the market");
                    dto.setLocation(scanner.nextLine());

                    System.out.println("Enter number of shops in the market");
                    dto.setNumberOfShops(scanner.nextInt());
                    scanner.nextLine();

                    if (dao.save(dto)){
                        System.out.println("Saving details of the market successful");
                    }
                    else System.out.println("Saving details of the market failed");
                }
                case 2->dao.getAll();
                case 3->{
                    System.out.println("Enter the name of market for which " +
                            "number of shop is to be updated");
                    if (dao.updateNumberOfShops(scanner.nextLine())){
                        System.out.println("Number of shop updating successful");
                    }
                    else System.out.println("Number of shop updating failed");
                }
                case 4->{
                    System.out.println("Enter the location");
                    dao.getByLocation(scanner.nextLine());
                }
                case 5 ->{
                    System.out.println("Enter the id of the market which you want to delete");
                    int id =scanner.nextInt();
                    scanner.nextLine();
                    if (dao.deleteById(id)){
                        System.out.println("Deletion of details of market successful");
                    }
                    else System.out.println("Deletion of details of market failed");
                }
            }
            System.out.println("Enter Y/y to continue or any other letter to exit");
            userWish=scanner.nextLine().charAt(0);
        }while (userWish=='Y'|userWish=='y');
    }
}

