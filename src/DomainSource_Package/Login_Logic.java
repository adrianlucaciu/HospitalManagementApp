package DomainSource_Package;

import DataSource_Package.LoginMapper;

public class Login_Logic {

    public static boolean verifyLoginMedic(String username, String password){
        return LoginMapper.getLoginMedic(username,password);
    }

    public static boolean verifyLoginPacient(String username, String password){
        return LoginMapper.getLoginPacient(username,password);
    }

    public static int getRole(boolean medic, boolean pacient){
        if (medic){
            return 1;
        }
        if (pacient) {
            return 2;
        }
        return -1;
    }

    public static Login getLoginByUsername(String username) {
        System.out.println("S:Username" + username);
        return LoginMapper.getLoginByUsername(username);
    }

}
