//clase comprador 
package application.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Setter
public abstract class Buyer extends User {
    private String mainAddress;
    private String tradingStatus;
    private User user;
;

  
    public void Addaddress() {
        
    }

    public void Placeanorder() {
        
    }

    public void Vieworderhistory() {
        
    }
    
}
