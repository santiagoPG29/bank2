//clase usuario
package application.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import application.domain.models.enums.UserStatus;


@NoArgsConstructor
@Setter
@Getter
public abstract class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private UserStatus userStatus;


    public void updateStatus() {
        
    }

    public void  viewProfile() {
        
    }
    

}
