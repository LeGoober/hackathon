package ch.planner.authenticators;

import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProvider;
import org.keycloak.services.resources.LoginActionsService;

/**
 * This is a fork from https://github.com/sventorben/keycloak-home-idp-discovery
 * Workaround to reuse the logic in FreeMarkerLoginFormsProvider.prepareBaseUriBuilder, so no need to reimplement it.
 */
final class BaseUriLoginFormsProvider extends FreeMarkerLoginFormsProvider {

  public BaseUriLoginFormsProvider(AuthenticationFlowContext context) {
    super(context.getSession());
    super.setAuthenticationSession(context.getAuthenticationSession());
    super.setClientSessionCode(context.generateAccessCode());
  }

  public URI getBaseUriWithCodeAndClientId() {
    UriBuilder baseUriBuilder = super.prepareBaseUriBuilder(false);
    if (accessCode != null) {
      baseUriBuilder.queryParam(LoginActionsService.SESSION_CODE, accessCode);
    }
    return baseUriBuilder.build();
  }
}
