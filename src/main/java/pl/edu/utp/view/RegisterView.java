package pl.edu.utp.view;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Date;

/**
 * Created by xxbar on 08.01.2017.
 */
@UIScope
@SpringView(name = RegisterView.VIEW_NAME)
public class RegisterView extends CustomComponent implements View {

    public static final String VIEW_NAME = "register";

    private final TextField name;
    private final TextField surname;
    private final TextField email;
    private final PasswordField password;
    private final PopupDateField birthDate;

    private final Button registerButton;



    public RegisterView() {
        setSizeFull();

        // Create the user input field
        email = new TextField("User:");
        email.setWidth("300px");
        email.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        email.setIcon(FontAwesome.ENVELOPE);
        email.setInputPrompt("login@example.com");
        email.setRequired(true);
        email.addValidator(new EmailValidator(
                "Username must be an email address"));
        email.setInvalidAllowed(false);

        // Create the password input field
        password = new PasswordField("Password:");
        password.setInputPrompt("Secret words");
        password.setWidth("300px");
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        password.setIcon(FontAwesome.LOCK);
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");


        // Create the name input field
        name = new TextField("Name:");
        name.setWidth("300px");
        name.setRequired(true);
        name.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        name.setIcon(FontAwesome.USER);
        name.setValue("");
        name.setInputPrompt("eg. John");
        name.setNullRepresentation("");

        // Create the surname input field
        surname = new TextField("Surname:");
        surname.setWidth("300px");
        surname.setRequired(true);
        surname.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        surname.setIcon(FontAwesome.USER);
        surname.setValue("");
        surname.setInputPrompt("eg. Smith");
        surname.setNullRepresentation("");

        birthDate = new PopupDateField("Birth date:");
        surname.setWidth("300px");
        surname.setRequired(true);
        birthDate.setValue(new Date());
        surname.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        surname.setIcon(FontAwesome.CALENDAR);

        // Create login button
        registerButton = new Button("Register");
        registerButton.addClickListener(event -> {
//            TODO
            System.out.println("Register Button clicked");
        });

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(email, password, name, surname, birthDate, registerButton);
//        fields.setCaption("Please login to access the application. (test@test.com/passw0rd)");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(fields);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
