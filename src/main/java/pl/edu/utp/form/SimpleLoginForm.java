package pl.edu.utp.form;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by xxbar on 08.01.2017.
 */
//@UIScope
//@SpringView(name = SimpleLoginView.VIEW_NAME)
public class SimpleLoginForm extends VerticalLayout {// implements View {

//    public static final String VIEW_NAME = "login";

    private final TextField email;
    private final PasswordField password;

    private final Button loginButton;
    private final Button facebookButton;
    private final Button googleButton;
    private final Button gitHubButton;

    public SimpleLoginForm(LoginCallback callback) {
        setSizeFull();

        // Create the email input field
        email = new TextField("User:");
        email.setWidth("300px");
        email.setRequired(true);
        email.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        email.setIcon(FontAwesome.ENVELOPE);
        email.setInputPrompt("Email");
//        email.addValidator(new EmailValidator(
//                "Username must be an email address"));
        email.setInvalidAllowed(false);

        // Create the password input field
        password = new PasswordField("Password:");
        password.setWidth("300px");
        password.setRequired(true);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        password.setIcon(FontAwesome.LOCK);
        password.setInputPrompt("Password");
//        password.setValue("");
        password.setNullRepresentation("");

        // Create login button
        loginButton = new Button("Login", evt -> {
            String pword = password.getValue();
            password.setValue("");
            if (!callback.login(email.getValue(), pword)) {
                Notification.show("Login failed");
                email.focus();
            }
        });
        loginButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        loginButton.setWidth("300px");
        loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

        facebookButton = new Button("Log in with Facebook", FontAwesome.FACEBOOK);
        facebookButton.setWidth("300px");
        facebookButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        facebookButton.addClickListener(event -> {
            getUI().getPage().setLocation("/login/facebook");

        });

        googleButton = new Button("Log in with Google", FontAwesome.GOOGLE);
        googleButton.setWidth("300px");
        googleButton.addClickListener(event -> {});
        googleButton.setStyleName(ValoTheme.BUTTON_DANGER);

        gitHubButton = new Button("Log in with Github", FontAwesome.GITHUB);
        gitHubButton.setWidth("300px");
        gitHubButton.addClickListener(event -> {
            getUI().getPage().setLocation("/login/github");
        });

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(email, password, loginButton, facebookButton, googleButton, gitHubButton);
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        setSizeFull();
        addComponent(fields);
        setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        setStyleName(Reindeer.LAYOUT_BLUE);

    }

    @FunctionalInterface
    public interface LoginCallback {

        boolean login(String username, String password);
    }

}
