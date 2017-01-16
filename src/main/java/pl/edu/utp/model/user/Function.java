package pl.edu.utp.model.user;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String description;
    private String view;

    @ManyToMany(mappedBy = "functions")
    private Collection<Role> roles;

    public Function(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Function)) return false;

        Function function = (Function) o;

        if (getId() != null ? !getId().equals(function.getId()) : function.getId() != null) return false;
        if (!getCode().equals(function.getCode())) return false;
        if (getDescription() != null ? !getDescription().equals(function.getDescription()) : function.getDescription() != null)
            return false;
        if (!getView().equals(function.getView())) return false;
        return getRoles() != null ? getRoles().equals(function.getRoles()) : function.getRoles() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getCode().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getView().hashCode();
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", view='" + view + '\'' +
//                ", roles=" + roles +
                '}';
    }
}