package uz.open.weather.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    private String firstName;

    @Column(name = "last_name", length = 40)
    private String lastName;

    @Column(name = "password", length = 200)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 70)
    private uz.open.weather.model.user.WebUserRole role;

    @Column(name = "status")
    private Boolean status;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WebUser{");
        sb.append("webUserId=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role=").append(role);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebUser webUser = (WebUser) o;
        return Objects.equals(id, webUser.id) && Objects.equals(username, webUser.username) && Objects.equals(firstName, webUser.firstName) && Objects.equals(lastName, webUser.lastName) && Objects.equals(password, webUser.password) && role == webUser.role && Objects.equals(status, webUser.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, password, role, status);
    }
}

