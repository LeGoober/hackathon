package ch.planner.authenticators;

import java.util.Optional;
import org.keycloak.models.AuthenticatorConfigModel;

/**
 * This is a fork from https://github.com/sventorben/keycloak-home-idp-discovery
 */
final class HomeIdpDiscoveryConfig {

  static final String FORWARD_TO_LINKED_IDP = "forwardToLinkedIdp";
  static final String BYPASS_LOGIN_PAGE = "bypassLoginPage";
  static final String USER_ATTRIBUTE = "userAttribute";
  static final String FORWARD_UNVERIFIED_ATTRIBUTE = "forwardUnverifiedEmail";
  static final String FORWARD_TO_FIRST_MATCH = "forwardToFirstMatch";

  private final AuthenticatorConfigModel authenticatorConfigModel;

  HomeIdpDiscoveryConfig(AuthenticatorConfigModel authenticatorConfigModel) {
    this.authenticatorConfigModel = authenticatorConfigModel;
  }

  boolean forwardToLinkedIdp() {
    return Optional
      .ofNullable(authenticatorConfigModel)
      .map(it -> Boolean.parseBoolean(it.getConfig().getOrDefault(FORWARD_TO_LINKED_IDP, "false")))
      .orElse(false);
  }

  boolean bypassLoginPage() {
    return Optional
      .ofNullable(authenticatorConfigModel)
      .map(it -> Boolean.parseBoolean(it.getConfig().getOrDefault(BYPASS_LOGIN_PAGE, "false")))
      .orElse(false);
  }

  String userAttribute() {
    return Optional
      .ofNullable(authenticatorConfigModel)
      .map(it -> it.getConfig().getOrDefault(USER_ATTRIBUTE, "email").trim())
      .orElse("email");
  }

  boolean forwardUserWithUnverifiedEmail() {
    return Optional
      .ofNullable(authenticatorConfigModel)
      .map(it -> Boolean.parseBoolean(it.getConfig().getOrDefault(FORWARD_UNVERIFIED_ATTRIBUTE, "false")))
      .orElse(false);
  }

  boolean forwardToFirstMatch() {
    return Optional
      .ofNullable(authenticatorConfigModel)
      .map(it -> Boolean.parseBoolean(it.getConfig().getOrDefault(FORWARD_TO_FIRST_MATCH, "true")))
      .orElse(true);
  }
}
