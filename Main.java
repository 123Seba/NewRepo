import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnector.connect();
        ResultSet result = QueryExecutor.executeSelect("SELECT * FROM rooms;");
        result.next();
        System.out.println(result.getString("room_type"));
        result = QueryExecutor.executeSelect("SELECT * FROM bookings ;");
        result.next();
        System.out.println(result.getString("customer_name"));
        try
        {
            Scanner sc = new Scanner(System.in);
            int ch,ch2;
            char wish;
            x:
            do{

                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        QueryExecutor.selectSingleroom();
                        break;
                    case 4:
                        QueryExecutor.selectfood();
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.order(ch2-41,4);
                        else if(ch2>30)
                            Hotel.order(ch2-31,3);
                        else if(ch2>10)
                            Hotel.order(ch2-11,2);
                        else if(ch2>0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");

                        break;
                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.deallocate(ch2-41,4);
                        else if(ch2>30)
                            Hotel.deallocate(ch2-31,3);
                        else if(ch2>10)
                            Hotel.deallocate(ch2-11,2);
                        else if(ch2>0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');


        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
    }
}


