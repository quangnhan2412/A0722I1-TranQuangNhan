package codegym.vn.springboot.entity;



import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "SinhVien")
public class Student {
    @Id
    @Column(name = "student_id", columnDefinition = "varchar(10)")
    private String id;
    @NotBlank(message = "{notempty}")
    @Size(min = 5, message = "{name.size}")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classCode", referencedColumnName = "classCode")
    private ClassName className;
    private String email;
    private boolean sex;
    private String phoneNumber;
    @Transient
    private String note;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
