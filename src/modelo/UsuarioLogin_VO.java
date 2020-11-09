package modelo;

public class UsuarioLogin_VO {
    String loginID;
    String password;
    int tipo;

    public UsuarioLogin_VO() {
        this.loginID = "";
        this.password = "";
        this.tipo = 0;
    }
    
    public UsuarioLogin_VO(String loginID, String password, int tipo) {
        this.loginID = loginID;
        this.password = password;
        this.tipo = tipo;
    }

    public String getLoginID() {
        return loginID;
    }

    public String getPassword() {
        return password;
    }

    public int getTipo() {
        return tipo;
    }
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }   
}