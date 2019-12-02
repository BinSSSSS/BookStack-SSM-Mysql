package cn.tblack.bookstack.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookUser implements Serializable {
    private Long account;

    private String username;

    private Integer id;

    private String password;

    private String gender;

    private Date birthday;

    private String phoneNumber;

    private String homeland;

    private Short age;

    private String personalSignature;

    private String job;

    private String email;

    private static final long serialVersionUID = 1L;

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer userId) {
        this.id = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNum() {
        return phoneNumber;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNumber = phoneNum == null ? null : phoneNum.trim();
    }

    public String getHomeland() {
        return homeland;
    }

    public void setHomeland(String homeland) {
        this.homeland = homeland == null ? null : homeland.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature == null ? null : personalSignature.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	@Override
	public String toString() {
		return "BookUser [account=" + account + ", username=" + username + ", userId=" + id + ", password="
				+ password + ", gender=" + gender + ", birthday=" + birthday + ", phoneNum=" + phoneNumber + ", homeland="
				+ homeland + ", age=" + age + ", personalSignature=" + personalSignature + ", job=" + job + ", email="
				+ email + "]";
	}
    
    
}