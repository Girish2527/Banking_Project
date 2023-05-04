import java.sql.*;

public class Bank {
    public void displayAllSavingsAccount() {
        String query = "select * from savings_account_customers";
        Connection con = DbConnection.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("account no : "+rs.getInt(1)+" customer name : "+rs.getString(2)+
                        " Address : "+rs.getString(3)+" contact no : "+rs.getInt(4) );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean customerVerification(int number, String name){
        String query ="SELECT * FROM savings_account_customers WHERE customer_account_no = ? AND customer_name = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean customerFound = false;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1,number);
            pst.setString(2, name);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(rs.next()) {
               customerFound= true;
             //  System.out.println("a/c no "+rs.getInt(1)+"name : "+rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return customerFound;
    }




}
