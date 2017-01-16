package pl.edu.utp.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;

/**
 * Created by xxbar on 10.01.2017.
 */
@SpringView(name = AdminSecretView.VIEW_NAME)
public class AdminSecretView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "admin-secret";


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @PostConstruct
    void init() {
        setMargin(true);
        Label label = new Label("Admin Secret View");
        label.addStyleName(ValoTheme.LABEL_LARGE);
        label.setSizeUndefined();
        addComponent(label);
    }
}
