package com.aln.esceulamusicabackend.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;

import com.aln.esceulamusicabackend.Data.Person.Users.UsersData;
import com.aln.esceulamusicabackend.Model.Person.User.Users;

import java.sql.Timestamp;
import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {
    @Autowired
    private UsersData usersData;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) {
        OAuth2User oAuth2User = super.loadUser(request);

        String provider = request.getClientRegistration().getRegistrationId();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String avatar = (String) attributes.get("picture");
        String oauthId = (String) attributes.get("sub");

        Users existingUser = usersData.getUserByEmail(email);
        if (existingUser == null) {
            Users newUser = new Users();
            newUser.setEmail(email);
            newUser.setUserName(name);
            newUser.setProvider(provider);
            newUser.setOAuthId(oauthId);
            newUser.setAvatarUrl(avatar);
            newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            newUser.setStatus(true);
            // You should set idPersona and other required fields appropriately
            usersData.addUser(newUser);
        }

        return oAuth2User;
    }


}
