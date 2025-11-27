import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        try {
            // 1. Menentukan alamat database
            String url = "jdbc:mysql://localhost:3306/db_kampus"; // perhatikan nama databasenya
            String user = "root"; // username default XAMPP
            String pass = ""; // password default XAMPP (biasanya kosong)
            
            // 2. Memanggil driver yang tadi ditambahkan di Libraries
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // Catatan: Jika error di baris atas, coba ganti jadi: new com.mysql.jdbc.Driver()
            
            // 3. Mencoba terhubung
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            // System.out.println("Koneksi Berhasil!"); // Untuk ngetes di output
            
        } catch (Exception e) {
            // Jika gagal, tampilkan pesan error
            JOptionPane.showMessageDialog(null, "Gagal Koneksi ke Database:\n" + e.getMessage());
        }
        return mysqlconfig;
    }
}