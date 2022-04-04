package entity;

public class UserEntity {
    private int num;
    private String name;
    private String studentID;
    private String password;
    private String department;
    private String birth;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String detail_address;
    private String authority;

    /* 회원목록 */
    public UserEntity(String studentID, String password) {
        this.studentID = studentID;
        this.password = password;
    }

    /* 회원목록 */
    public UserEntity(int num, String name, String studentID, String department) {
        this.num = num;
        this.name = name;
        this.studentID = studentID;
        this.department = department;
    }

    /*회원가입*/
    public UserEntity(int num, String name, String studentID, String password, String department, String birth,
                      String gender, String email, String phone, String address, String detail_address, String authority) {
        this.num = num;
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.department = department;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.detail_address = detail_address;
        this.authority = authority;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", studentID='" + studentID + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", detail_address='" + detail_address + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
