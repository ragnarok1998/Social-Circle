
import java.sql.*;
import java.util.Scanner;

public class DB {
Connection con=null;

    public Connection getconnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_db", "root", "root");
            System.out.println("connection established");
            }catch (SQLException| ClassNotFoundException e){
            System.out.println(e);
        }
        return con;

    }


//Creation
    public void insert(){
        try{
            String query="insert into contact(full_name,phonenumber,gender,email,dob,location,address,events_of_celebration)values(?,?,?,?,?,?,?,?)";
            PreparedStatement dml =con.prepareStatement(query);
            String val1=null; //f_name
            String val2=null; // phone no
            String val3=null; // gender
            String val4 =null;//email
            String val5=null;//dob
            String val6=null;//location
            String val7=null;//address
            String val8=null;// eoc
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Details of the contact");
            val1=sc.next();
            val2=sc.next();
            val3=sc.next();
            val4=sc.next();
            val5=sc.next();
            val6=sc.next();
            val7=sc.next();
            val8=sc.next();
            dml.setString(1,val1);
            dml.setString(2,val2);
            dml.setString(3,val3);
            dml.setString(4,val4);
            dml.setString(5,val5);
            dml.setString(6,val6);
            dml.setString(7,val7);
            dml.setString(8,val8);
            int insert =dml.executeUpdate();
            if(insert>0){
                System.out.println("Inserted Successfully");
            }
            else{
                System.out.println("INsertion failed");
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }
    //Retrieve data
   public void  display(){
try{
    int id;String name;String phoneno;String gender;String email;String dob;String location;String address;
    String eventsofcelebration;
    Statement stmt=con.createStatement();
    ResultSet rst =stmt.executeQuery("select *from contact");
/*while (rst.next()){
    id= rst.getInt("id");
    name=rst.getString("full_name");
    phoneno=rst.getString("phonenumber");
    gender=rst.getString("gender");
    email=rst.getString("email");
    dob=rst.getString("dob");
    location=rst.getString("location");
    address=rst.getString("address");
    eventsofcelebration=rst.getString("events_of_celebration");
    //System.out.println(id+" "+name+" "+phoneno+" "+gender+" "+email+" "+dob+" "+location+" "+address+" "+eventsofcelebration+" ");


}*/
if(rst.next()){
    System.out.println("id :"+ rst.getInt("id"));
    System.out.println("fullname: "+rst.getString("full_name"));
    System.out.println("phonenumber: "+rst.getString("phonenumber"));
    System.out.println("gender: "+rst.getString("gender"));
    System.out.println("email: "+rst.getString("email"));
    System.out.println("dob: "+rst.getString("dob"));
    System.out.println("location: "+rst.getString("location"));
    System.out.println("address: "+rst.getString("address"));
    System.out.println("event: "+rst.getString("events_of_celebration"));
}else {
    System.out.println("no such user exists");
}

}catch (SQLException e){
    e.getLocalizedMessage();
}
    }
//updation
  /* public void update(){
        try{
            String query ="update contact set ";
        }catch (SQLException e){
e.getMessage();
        }
    }*/
    public void delete(){
      try{
          String query="delete from contact where full_name=?";
          PreparedStatement dml= con.prepareStatement(query);
          String val1=null;
          Scanner sc=new Scanner(System.in);
          System.out.println("enter name ");
          val1=sc.next();
          dml.setString(1,val1);
          int delete = dml.executeUpdate();
          if(delete>0){
              System.out.println("Deletion successfull");
          }
          else{
              System.out.println("deletion failed");
          }
      }catch (SQLException e){
e.getMessage();
      }
    }
    public static void main(String[] args)  {/*throws  ClassNotFoundException, SQLException {
Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/social_db","root","root");
        System.out.println("Connection successful");*/
        DB d= new DB();
        d.getconnection();
    d.display();
  //     d.insert();
      //  d.delete();
    }
}
