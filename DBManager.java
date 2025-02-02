

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.ResultSet;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {  
 
    private static final String DBDriver = "com.mysql.jdbc.Driver";
    private static final String DBUrl = "jdbc:mysql://localhost/onlineexam";
    private static final String DBUser = "root";
    private static final String DBPassword = "2003";
    
    static {
        try {
            Class.forName(DBDriver);
        } catch (ClassNotFoundException ex) {
           System.out.println(ex);
        }
    }


    
    

    static boolean authenticatefaculty(String UserId, String passwd) {
boolean flag = false;
        try {
            try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword); PreparedStatement st = con.prepareStatement("Select * from users where UserId=? and Passwd=?")) {
                st.setString(1,UserId);
                st.setString(2,passwd);
                try (ResultSet rs = (ResultSet) st.executeQuery()) {
                    if(rs.next()){
                        flag=true;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }  
       

    static FacultyInfo getfacultyId(String facultyId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    static boolean addClass(String ClassName, String Block) {
 boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from class where ClassName=?");
            st1.setString(1,ClassName);
            ResultSet rs = (ResultSet) st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
                try (PreparedStatement st = con.prepareStatement("Insert into class values(?,?)")) {
                    st.setString(1,ClassName);
                    st.setString(2,Block);
    
                    
                    st.executeUpdate();
                }
            con.close();
            flag=true;
            }
        } catch (SQLException ex) {
        } 
        return flag;        }
    
    

    static boolean addLab(String LabName, String Block) {
 boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from lab where LabName=?");
            st1.setString(1,LabName);
            ResultSet rs = (ResultSet) st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
                try (PreparedStatement st = con.prepareStatement("Insert into lab values(?,?)")) {
                    st.setString(1,LabName);
                    st.setString(2,Block);
    
                    
                    st.executeUpdate();
                }
            con.close();
            flag=true;
            }
        } catch (SQLException ex) {
        } 
        return flag;     }
    

    static boolean addExam(String ExamId, String ExamName, String Session,String Day) {
boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from exams where ExamId=?");
            st1.setString(1,ExamId);
            ResultSet rs = (ResultSet) st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
                try (PreparedStatement st = con.prepareStatement("Insert into exams values(?,?,?,?)")) {
                    st.setString(1,ExamId);
                    st.setString(2,ExamName);
    
          st.setString(3,Session);
           st.setString(4,Day);
          

                    
                    st.executeUpdate();
                }
            con.close();
            flag=true;
            }
        } catch (SQLException ex) {
        } 
        return flag;    }

    static int deleteUser(String userId, String passwd) {
 int x=0;
        try {
               try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword)) {
                   PreparedStatement st = con.prepareStatement("Delete from users where UserId=?and passwd=?");
                   st.setString(1,userId);
                   st.setString(2,passwd);
                   x = st.executeUpdate();
               }
        } catch (SQLException ex) {
        }
        return x;    }

    static int deleteLab(String LabName, String Block) {
  int x=0;
        try {
               try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword)) {
                   PreparedStatement st = con.prepareStatement("Delete from lab where LabName=? and Block=?");
                   st.setString(1,LabName);
                   st.setString(2,Block);
                   x = st.executeUpdate();
               }
        } catch (SQLException ex) {
        }
        return x; 
    }

    static int deleteClass(String ClassName, String Block) {
int x=0;
        try {
               try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword)) {
                   PreparedStatement st = con.prepareStatement("Delete from class where ClassName=? and Block=?");
                   st.setString(1,ClassName);
                   st.setString(2,Block);
                   x = st.executeUpdate();
               }
        } catch (SQLException ex) {
        }
        return x; 
    }

 
    public DBManager(){

        Connect();
  }
        private Connection con;
    private PreparedStatement pst;
    private java.sql.ResultSet rs;
   
    
    public final void Connect() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/onlineexam","root","2003");
        System.out.println("Connected to the database");
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger( DBManager .class.getName()).log(Level.SEVERE, null, ex);
        System.err.println("Failed to connect to the database");
    }
    }

    static boolean authenticateStudent(String StudentId, String passwd) {
                boolean flag = false;
        try {
            try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword); PreparedStatement st = con.prepareStatement("Select * from student where StudentId=? and Passwd=?")) {
                st.setString(1,StudentId);
                st.setString(2,passwd);
                try (ResultSet rs = (ResultSet) st.executeQuery()) {
                    if(rs.next()){
                        flag=true;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    
    }
    
    static StudentInfo getStudentInfo(String StudentId) {
        StudentInfo info = null;
        try {
            try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword); PreparedStatement st = con.prepareStatement("Select * from student where StudentId=?")) {
                st.setString(1,StudentId);
                try (ResultSet rs = (ResultSet) st.executeQuery()) {
                    if(rs.next()){
                        info = new StudentInfo();
                        info.setStudentId((String) rs.getString(1));
                        info.setPasswd((String) rs.getString(2));

                        info.setName((String) rs.getString(3));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return info;
    }
  
    
    // method for  save the usere's data in the database.
     public static boolean registerUser(String fname, String userid)
    {
        boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from users where UserId=?");
            st1.setString(1,userid);
            ResultSet rs = (ResultSet) st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
                try (PreparedStatement st = con.prepareStatement("Insert into users(UserId,Name)values(?,?)")) {
                    st.setString(1,userid);


                    st.setString(2,fname);
                    
                    st.executeUpdate();
                }
            con.close();
            flag=true;
            }
        } catch (SQLException ex) {
        } 
        return flag;
    } 
          
               
    
   // method for authentication of user.
   public static boolean authenticateUser(String userId, String passwd) {
        boolean flag = false;
        try {
            try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword); PreparedStatement st = con.prepareStatement("Select * from users where UserId=? and Passwd=?")) {
                st.setString(1,userId);
                st.setString(2,passwd);
                try (ResultSet rs = (ResultSet) st.executeQuery()) {
                    if(rs.next()){
                        flag=true;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }  
   
   //method for getting the information about user from database...
   public static UserInfo getUserInfo(String userId) {
        UserInfo info = null;
        try {
            try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword); PreparedStatement st = con.prepareStatement("Select * from users where UserId=?")) {
                st.setString(1,userId);
                try (ResultSet rs = (ResultSet) st.executeQuery()) {
                    if(rs.next()){
                        info = new UserInfo();
                        info.setUserId((String) rs.getString(1));
                        info.setPasswd((String) rs.getString(2));
                        info.setUserType((String) rs.getString(3));
                        info.setName((String) rs.getString(4));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return info;
    }


    // method for view all the user's test report.

    private static String getDate(Date d){
        
        java.util.Date doe = new java.util.Date(d.getTime());
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMMM-yyyy");
        String str = fmt.format(doe);
        return str;
    }

    /*public static boolean addExam(String ExamId, String ExamName, String Description, String Duration) {
        
      boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from exams where ExamId=?");
            st1.setString(1,ExamId);
            ResultSet rs = (ResultSet) st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
                try (PreparedStatement st = con.prepareStatement("Insert into exams values(?,?,?,?)")) {
                    st.setString(1,ExamId);
                    st.setString(2,ExamName);
    
          st.setString(3,Description);
                    st.setString(4,Duration);
                    
                    st.executeUpdate();
                }
            con.close();
            flag=true;
            }
        } catch (SQLException ex) {
        } 
        return flag;
    }*/

    public static boolean addQuestion(String QuestionId, String Question, String OptionA, String OptionB, String OptionC, String OptionD, String Answer, String ExamId) {
          boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from exams where ExamId=? ");
            st1.setString(1,ExamId);
            ResultSet rs = (ResultSet) st1.executeQuery();
            if(rs.next())
            {
                try (PreparedStatement st = con.prepareStatement("Insert into questions values(?,?,?,?,?,?,?,?)")) {
                    st.setString(1,QuestionId);
                    st.setString(2,Question);
                    st.setString(3,OptionA);
                    st.setString(4,OptionB);
                    st.setString(5,OptionC);
                    st.setString(6,OptionD);
                    st.setString(7,Answer);
                    st.setString(8,ExamId);
                    st.executeUpdate();
                    flag=true;
                }
            con.close();
            }
            else
            {
               flag=false;
            }
        } catch (SQLException ex) {
        } 
        return flag;
    }

    public static UserInfo getData(String name) {
        UserInfo s = null;
        try {
            try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword); 
                    PreparedStatement st = con.prepareStatement("Select * from users where UserId=?")) {
                st.setString(1,name);
                try (ResultSet rs = (ResultSet) st.executeQuery()) {
                    if(rs.next()){
                        s = new UserInfo();
                        s.setPasswd((String) rs.getString(2));
                        s.setUserType((String) rs.getString(3));
                        s.setName((String) rs.getString(4));
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return s;
    }

    public static int updateStudent(StudentInfo s) {
     int x = 0;
        try {
         try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword)) {
             PreparedStatement st = con.prepareStatement("update student set passwd=? where userid=?");
             st.setString(1,s.getPasswd());
             st.setString(2,s.getStudentId());
             x = st.executeUpdate();
         }
        } catch (SQLException ex) {
        }
        return x;
    }

  public static int deleteStudent(String userId, String passwd) {
           int x=0;
        try {
               try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword)) {
                   PreparedStatement st = con.prepareStatement("Delete from users where UserId=?and passwd=?");
                   st.setString(1,userId);
                   st.setString(2,passwd);
                   x = st.executeUpdate();
               }
        } catch (SQLException ex) {
        }
        return x;
  }



    static int updateinfo(ManageUsers.UserInfo s) {
     int x = 0;
        try {
         try (Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword)) {
             PreparedStatement st = con.prepareStatement("update users set passwd=? where userid=?");
             st.setString(1,s.getPasswd());
             st.setString(2,s.getUserId());
             x = st.executeUpdate();
         }
        } catch (SQLException ex) {
        }
        return x;
    }




    static class UserInfo {

      

    private String UserId;
    private String Passwd;
    private String UserType;
    private String Name;

    public UserInfo() {
        }
    
    public UserInfo(String UserId, String Passwd, String UserType, String Name) {
        this.UserId = UserId;
        this.Passwd = Passwd;
        this.UserType = UserType;
        this.Name = Name;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
   
    class StudentInfo {
  
    private String StudentId;
    private String passwd;
    private String name;

    public StudentInfo() {
    }

    public StudentInfo(String userId, String passwd, String name) {
        this.StudentId = userId;
        this.passwd = passwd;

        this.name = name;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

}

    static class StudentInfo {

        public StudentInfo() {
        }
       
  
    private String StudentId;
    private String passwd;
    private String name;

  

    public StudentInfo(String userId, String passwd, String name) {
        this.StudentId = userId;
        this.passwd = passwd;

        this.name = name;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    }

    static class FacultyInfo {

        public FacultyInfo() {
        }
          
    private String FacultyId;
    private String passwd;
    private String facultyname;

    

    public FacultyInfo(String facultyId, String facultyname,String passwd) {
        this.FacultyId = facultyId;
        this.passwd = passwd;

        this.facultyname = facultyname;
    }

    public String getfacultyId() {
        return FacultyId;
    }

    public void setfacultyId(String facultyId) {
        this.FacultyId = facultyId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getfacultyame() {
        return facultyname;
    }

    public void setfacultyame(String facultyname) {
        this.facultyname = facultyname;
    }
    

    }
    }






    
      
 

 