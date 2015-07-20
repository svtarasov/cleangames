package com.example.katerina.mapsex.Registration;

import com.example.katerina.mapsex.datamodels.User;
/**
 * Created by Katerina on 20.07.2015.
 */
public class UserProvider_temp {

    /**
     * Created by 1 on 10.07.2015.
     */
        private static UserProvider_temp  instance;
        private static User user;
        private UserProvider_temp (User user){
            this.user = user;
        }
        public static UserProvider_temp  Initialize() {
            return instance;
        }

        public static UserProvider_temp  Initialize(User user){
            if(instance!= null)
                return instance;
            else { instance = new UserProvider_temp (user);return instance;}
        }
        public User getUser(){
            return this.user;
        }

}

