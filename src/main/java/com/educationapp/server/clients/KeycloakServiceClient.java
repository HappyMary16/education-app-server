package com.educationapp.server.clients;

import com.educationapp.server.models.KeycloakUser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Slf4j
@Component
@RequiredArgsConstructor
public class KeycloakServiceClient {

    @Value("${keycloak.auth-server-url}")
    private String keycloakUrl;

    @Value("${keycloak.realm}")
    private String realm;

    private final RestOperations restOperations;

    @SneakyThrows
    public KeycloakUser getUserById(final String userId) {
        log.debug("Get KeycloakUser for user with id {}", userId);
        final String getUserUri = keycloakUrl + "/admin/realms/" + realm + "/users/" + userId;

        final ResponseEntity<KeycloakUser> response = restOperations.getForEntity(getUserUri, KeycloakUser.class);

        log.debug("Returned KeycloakUser: {}", response.getBody());

        return response.getBody();
    }
}
