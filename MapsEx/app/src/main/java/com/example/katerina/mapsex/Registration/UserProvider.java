package com.example.katerina.mapsex.Registration;

import com.datamodel.datamodels.User;
/**
 * Created by Katerina on 20.07.2015.
 */
public class UserProvider{

    /**
     * Created by 1 on 10.07.2015.
     */
        private static UserProvider  instance;
        private static User user;
        private UserProvider (User user){
            this.user = user;
        }
        public static UserProvider  Initialize() {
            return instance;
        }

        public static UserProvider  Initialize(User user){
            if(instance!= null)
                return instance;
            else { instance = new UserProvider (user);return instance;}
        }
        public User getUser(){
            return this.user;
        }

}

