package pl.edu.utp;

import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import pl.edu.utp.model.user.Function;
import pl.edu.utp.model.user.Role;
import pl.edu.utp.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * This demonstrates how you can control access to views.
 */
@VaadinSessionScope
@SpringView(name = AccessControlView.VIEW_NAME)
public class AccessControlView extends VerticalLayout implements View, ViewAccessControl {

    public static final String VIEW_NAME = "access";

    private final Set<String> allowedViews = new HashSet<>();

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    RoleRepository roleRepository;

    @PostConstruct
    void init() {

        setMargin(true);
        setSpacing(true);
        addComponent(new Label("Here you can control the access to the different views within this particular UI. Uncheck a few boxes and try to navigate to their corresponding views. " +
                "In a real application, you would probably base the access decision on the current user's role or something similar."));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role != null && role.getFunctions() != null){
            for (Function f : role.getFunctions()){
                allowedViews.add(f.getView());
                if (!f.getView().equals("access")) {addComponent(createViewCheckbox(f.getCode(), f.getView()));}
            }
        }
    }

    private CheckBox createViewCheckbox(String caption, final String viewName) {
        final CheckBox checkBox = new CheckBox(caption, true);
        checkBox.addValueChangeListener((Property.ValueChangeListener) event -> {
            if (checkBox.getValue()) {
                allowedViews.add(viewName);
            } else {
                allowedViews.remove(viewName);
            }
        });
        return checkBox;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @Override
    public boolean isAccessGranted(UI ui, String beanName) {
        final SpringView annotation = applicationContext.findAnnotationOnBean(beanName, SpringView.class);
        if (annotation != null) {
            return allowedViews.contains(annotation.name());
        } else {
            return false;
        }
    }

}
