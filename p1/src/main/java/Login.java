import org.apache.commons.codec.digest.DigestUtils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = in.next();
        System.out.println("请输入密码");
        String pw = in.next();

        // 获取路径
        String filePath = Login.class.getClassLoader().getResource("user.txt").getFile();
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));
        String userExist = dis.readLine();
        String pwExist = dis.readLine();

        if(!user.equals(userExist)){
            System.out.println("用户不存在");
        }else if (!(sha256hex(pw)).equals(pwExist)){
            System.out.println("密码错误");
        }else {
            System.out.println("登陆成功");
        }

    }
    static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
