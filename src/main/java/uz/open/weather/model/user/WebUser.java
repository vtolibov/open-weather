package uz.open.weather.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "web_user")
@Accessors(chain = true)
public class WebUser {

    @Id
    @Column("id")
    private Long id;

    @Column("username")
    private String username;

    @Column("first_name")
    private String firstname;

    @Column("last_name")
    private String lastname;

    @Column("password")
    private String password;

    @Column("role")
    private WebUserRole role;

    @Column("is_active")
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
        return new EqualsBuilder().append(id, webUser.id).append(username, webUser.username).append(firstname, webUser.firstname).append(lastname, webUser.lastname).append(password, webUser.password).append(role, webUser.role).append(isActive, webUser.isActive).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(username).append(firstname).append(lastname).append(password).append(role).append(isActive).toHashCode();
    }
}

