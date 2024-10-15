package com.rf.onlinebarber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Builder design pattern uyguladığımız sınıf
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    private String token;
    @ManyToOne
    @JsonIgnore
    private BaseUser user;

    public Token(TokenBuilder tokenBuilder){
        this.token=tokenBuilder.token;
        this.user=tokenBuilder.user;
    }
 //Builder class
    public static class TokenBuilder{
        private String token;
        private BaseUser user;

        public TokenBuilder Token(String token){
            this.token=token;
            return this;
        }
        public TokenBuilder User(BaseUser user){
            this.user=user;
            return this;
        }
        public Token build(){
            return new Token(this);
        }

    }

}
