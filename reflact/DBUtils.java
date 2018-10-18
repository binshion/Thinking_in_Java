package reflact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(ip = "127.0.0.1", database = "tmall_ssm", encoding = "utf8", loginName = "root", password = "admin")
public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException,
            NoSuchMethodException, SecurityException {
        JDBCConfig config = DBUtils.class.getAnnotation(JDBCConfig.class);

        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&useSSL=false&serverTimezone=UTC",
                ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        Connection c = getConnection();
        System.out.println(c);
    }
}
