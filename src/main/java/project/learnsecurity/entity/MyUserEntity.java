package project.learnsecurity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.learnsecurity.util.CommonUtil;

@Entity
@Getter
@Setter
public class MyUserEntity {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;

    @PrePersist
    protected void generateId() {
        if (this.id == null) {
            this.id = CommonUtil.getUUID();
        }
    }
}
