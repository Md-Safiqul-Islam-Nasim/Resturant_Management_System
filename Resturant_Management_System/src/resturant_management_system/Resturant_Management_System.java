package resturant_management_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Resturant_Management_System {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        for (int i = 0;; i++) {
            System.out.println("\n\nWelcome TO Burger Point\n\n");

            System.out.println("Enter 1 for Admin Panel");
            System.out.println("Enter 2 for Customer");

            int part = input.nextInt();

            if (part == 1) {
                System.out.println("Enter 1 for Add Item");
                System.out.println("Enter 2 for Delete Item");
                System.out.println("Enter 3 for Update Item");
                System.out.println("Enter 4 for View Item");

                int item = input.nextInt();

                if (item == 1) {
                    System.out.println("Enter 1 for Burger");
                    System.out.println("Enter 2 for Drinks");

                    int in = input.nextInt();

                    if (in == 1) {
                        String name, size;
                        int price;

                        System.out.println("Enter Burger Name");

                        name = input.next();

                        System.out.println("Enter Burger Size");

                        size = input.next();

                        System.out.println("Enter Burger Price");

                        price = input.nextInt();

                        String bburger = "Big";

                        if (size.equals(bburger)) {
                            try {
                                conn c = new conn();
                                String str = "INSERT INTO big_burger values( '" + name + "', '" + size + "', '" + price + "')";

                                c.s.executeUpdate(str);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                conn c = new conn();
                                String str = "INSERT INTO small_burger values( '" + name + "', '" + size + "', '" + price + "')";

                                c.s.executeUpdate(str);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println("\nBurger Add SuccessFuly\n\n");
                    } else if (in == 2) {
                        String drinks;
                        int d_price;

                        System.out.println("Enter Drinks Name");

                        drinks = input.next();

                        System.out.println("Enter Drinks Price");

                        d_price = input.nextInt();

                        try {
                            conn c = new conn();
                            String str = "INSERT INTO drinks values( '" + drinks + "', '" + d_price + "')";

                            c.s.executeUpdate(str);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("\nDrinks Add SuccessFuly\n\n");
                    }
                } 
                //////////////////////////////// Add Option Done ///////////////////////////////////
                /////////////////////////////// Delete Option Begin ///////////////////////////////
                else if (item == 2) {
                    System.out.println("Enter Item Name");

                    String d_item = input.next();
                    String s1 = "Burger";

                    if (s1.equals(d_item)) {
                        System.out.println("Enter 1 for Big Burger");
                        System.out.println("Enter 2 for Small Burger");

                        int choose = input.nextInt();

                        if (choose == 1) {
                            System.out.println("Enter Burger Name");
                            String burger_name = input.next();

                            try {
                                conn con = new conn();
                                String str = "delete from big_burger where b_name = '" + burger_name + "'";
                                con.s.executeUpdate(str);

                            } catch (Exception ex) {
                            }

                        } else if (choose == 2) {
                            System.out.println("Enter Burger Name");
                            String burger_name = input.next();

                            try {
                                conn con = new conn();
                                String str = "delete from small_burger where s_name = '" + burger_name + "'";
                                con.s.executeUpdate(str);

                            } catch (Exception ex) {
                            }
                        }
                        System.out.println("\nBurger Delete Successfuly\n\n");

                    } else {
                        System.out.println("Enter Drink Name");
                        String D_Drinks = input.next();
                        try {
                            conn con = new conn();
                            String str = "delete from drinks where drinks = '" + D_Drinks + "'";
                            con.s.executeUpdate(str);

                        } catch (Exception ex) {
                        }

                        System.out.println("\nDrinks Delete SuccessFuly\n\n");

                    }
                } 
                
                //////////////////////////////// Delete Option Done ///////////////////////////////////
                /////////////////////////////// Update Option Begin ///////////////////////////////
                
                else if (item == 3) {
                    System.out.println("Enter 1 for Burger");
                    System.out.println("Enter 2 for Drinks");

                    int option = input.nextInt();

                    if (option == 1) {

                        System.out.println("Enter 1 for Big Burger");
                        System.out.println("Enter 2 for Small Burger");

                        int hh = input.nextInt();

                        if (hh == 1) {
                            System.out.println("Enter Burger Name");

                            String b_update = input.next();

                            System.out.println("Enter Burger Price");

                            int u_price = input.nextInt();

                            try {
                                conn con = new conn();
                                String str = "update big_burger set b_price='" + u_price + "'where b_name ='" + b_update + "'";
                                con.s.executeUpdate(str);

                            } catch (Exception e) {
                            }
                        } else {
                            System.out.println("Enter Burger Name");

                            String b_update = input.next();

                            System.out.println("Enter Burger Price");

                            int u_price = input.nextInt();

                            try {
                                conn con = new conn();
                                String str = "update small_burger set s_price='" + u_price + "'where s_name ='" + b_update + "'";
                                con.s.executeUpdate(str);

                            } catch (Exception e) {
                            }
                        }
                        System.out.println("\nUpdate Burger Information Successfully\n\n");
                    } 
                    
                    //////////////////////////////// Update Option Done ///////////////////////////////////
                    /////////////////////////////// All Details Option Begin ///////////////////////////////
                    
                    else {
                        System.out.println("Enter Drinks Name");

                        String D_Update = input.next();

                        System.out.println("Enter Drinks Price");

                        int P_D_Price = input.nextInt();

                        try {
                            conn con = new conn();
                            String str = "update drinks set d_price='" + P_D_Price + "'where drinks ='" + D_Update + "'";
                            con.s.executeUpdate(str);

                        } catch (Exception e) {
                        }

                        System.out.println("\nDrinks Information Update Successfuly");
                    }
                } else if (item == 4) {
                    System.out.println("Enter 1 for Big Burger Information");
                    System.out.println("Enter 2 for Small Burger Information");
                    System.out.println("Enter 3 for Dinks Information");

                    int show = input.nextInt();

                    if (show == 1) {
                        System.out.println("                      Big Burger\n");
                        System.out.println("Burger Name            Burger Size      Burger Price");
                        System.out.println("-----------            -----------      ------------");
                        conn con = new conn();
                        String sql = "select * from big_burger";
                        //Statement st = con.createStatement();
                        ResultSet result = con.s.executeQuery(sql);
                        while (result.next()) {
                            System.out.println(result.getString("b_name") + "                "
                                    + result.getString("b_size") + "              "
                                    + result.getString("b_price"));
                        }
                    } else if (show == 2) {
                        System.out.println("                      Small Burger\n");
                        System.out.println("Burger Name            Burger Size      Burger Price");
                        System.out.println("-----------            -----------      ------------");
                        conn con = new conn();
                        String sql = "select * from small_burger";
                        //Statement st = con.createStatement();
                        ResultSet result = con.s.executeQuery(sql);
                        while (result.next()) {
                            System.out.println(result.getString("s_name") + "              "
                                    + result.getString("s_size") + "              "
                                    + result.getString("s_price"));
                        }
                    } else {
                        System.out.println("    Drinks");
                        System.out.println("Drinks Name      Drinks Price");
                        System.out.println("-----------      ------------");
                        conn con = new conn();
                        String sql = "select * from drinks";
                        //Statement st = con.createStatement();
                        ResultSet result = con.s.executeQuery(sql);
                        while (result.next()) {
                            System.out.println(result.getString("drinks") + "              "
                                    + result.getString("d_price"));
                        }
                    }
                }
            } 
            
            ///////////////////////////////Customar Part ////////////////////////////////
            
            else {
                System.out.println("                       Order \n");

                System.out.println("                    Big Burger List\n");
                System.out.println("Burger Name            Burger Size      Burger Price");
                System.out.println("-----------            -----------      ------------");

                conn con = new conn();
                String sql = "select * from big_burger";
                //Statement st = con.createStatement();
                ResultSet result = con.s.executeQuery(sql);
                while (result.next()) {
                    System.out.println(result.getString("b_name") + "                "
                            + result.getString("b_size") + "              "
                            + result.getString("b_price"));
                }

                System.out.println("\n");

                int total_bill = 0;

                System.out.println("Enter 1 for Order Big Burger");
                System.out.println("Enter 2 for Skip This Item");

                int khamu = input.nextInt();

                if (khamu == 1) {
                    System.out.println("Enter Big Burger Name");

                    String Order = input.next();

                    conn conr = new conn();
                    String sqla = "select * from big_burger";

                    ResultSet resultw = conr.s.executeQuery(sqla);
                    String va = null, na;

                    while (resultw.next()) {

                        na = resultw.getString("b_name");
                        va = resultw.getString("b_price");

                        //System.out.println(va);
                        if (na.equals(Order)) {
                            total_bill += Integer.parseInt(va);
                        }
                    }
                }

                System.out.println("                      Small Burger List \n");
                System.out.println("Burger Name            Burger Size      Burger Price");
                System.out.println("-----------            -----------      ------------");

                conn cone = new conn();
                String sq = "select * from small_burger";
                ResultSet results = cone.s.executeQuery(sq);

                while (results.next()) {
                    System.out.println(results.getString("s_name") + "              "
                            + results.getString("s_size") + "              "
                            + results.getString("s_price"));
                }

                System.out.println("\n");

                System.out.println("Enter 1 for Order Small Burger");
                System.out.println("Enter 2 for Skip This Item");

                int khamu2 = input.nextInt();

                if (khamu2 == 1) {
                    System.out.println("Enter Small Burger Name");
                    String Order2 = input.next();

                    conn conr = new conn();
                    String sqla = "select * from small_burger";

                    ResultSet resultw = conr.s.executeQuery(sqla);
                    String va = null, na;

                    while (resultw.next()) {

                        na = resultw.getString("s_name");
                        va = resultw.getString("s_price");

                        //System.out.println(va);
                        if (na.equals(Order2)) {
                            total_bill += Integer.parseInt(va);
                        }
                    }
                }

                System.out.println("Enter Your Drinks Order\n");
                System.out.println("      Drinks List");
                System.out.println("Drinks Name      Drinks Price");
                System.out.println("-----------      ------------");
                conn cons = new conn();
                String sqls = "select * from drinks";
                //Statement st = con.createStatement();
                ResultSet resulte = cons.s.executeQuery(sqls);
                while (resulte.next()) {
                    System.out.println(resulte.getString("drinks") + "              "
                            + resulte.getString("d_price"));
                }

                System.out.println("\n");

                System.out.println("Enter 1 for Order Drink");
                System.out.println("Enter 2 for Skip This Item");

                int sho = input.nextInt();

                if (sho == 1) {
                    String D_Order = input.next();
                    conn conr = new conn();
                    String sqla = "select * from drinks";

                    ResultSet resultw = conr.s.executeQuery(sqla);
                    String va = null, na;

                    while (resultw.next()) {

                        na = resultw.getString("drinks");
                        va = resultw.getString("d_price");

                        //System.out.println(va);
                        if (na.equals(D_Order)) {
                            total_bill += Integer.parseInt(va);
                        }
                    }
                }

                System.out.println("\n Your Order Accepted\n\n");

                System.out.printf("Your Total Bill is  - $%d", total_bill);
            }
        }
    }
}
