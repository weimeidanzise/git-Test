package cn.itcast.domain;

public class Userr {
    private Integer id;
    private String username;
    private String pwd;
    private String addrss;
    private String email;
    private String imgName;

    @Override
    public String toString() {
        return "Userr{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", addrss='" + addrss + '\'' +
                ", email='" + email + '\'' +
                ", imgName='" + imgName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddrss() {
        return addrss;
    }

    public void setAddrss(String addrss) {
        this.addrss = addrss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
