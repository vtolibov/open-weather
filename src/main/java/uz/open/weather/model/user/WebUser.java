package uz.open.weather.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "web_user")
@Accessors(chain = true)
public class WebUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 150)
    private String username;

    @Column(name = "first_name", length = 40)
    private String firstname;

    @Column(name = "last_name", length = 40)
    private String lastname;

    @Column(name = "password", length = 200)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 70)
    private WebUserRole role;

    @Column(name = "is_active")
    private Boolean isActive;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("username", username)
                .append("firstName", firstname)
                .append("lastName", lastname)
                .append("password", password)
                .append("role", role)
                .append("isActive", isActive)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebUser webUser = (WebUser) o;
        return Objects.equals(id, webUser.id) && Objects.equals(username, webUser.username) && Objects.equals(firstname, webUser.firstname) && Objects.equals(lastname, webUser.lastname) && Objects.equals(password, webUser.password) && role == webUser.role && Objects.equals(isActive, webUser.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstname, lastname, password, role, isActive);
    }
}

