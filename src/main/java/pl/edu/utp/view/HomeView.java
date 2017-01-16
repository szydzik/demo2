package pl.edu.utp.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by xxbar on 08.01.2017.
 */
@UIScope
@SpringView(name = HomeView.VIEW_NAME)
public class HomeView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    private Label label;

    public HomeView() {
        setMargin(true);
        Label label = new Label("Home View");
        label.addStyleName(ValoTheme.LABEL_LARGE);
        label.setSizeUndefined();
        addComponent(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
//        username = String.valueOf(getSession().getAttribute("user"));
    }
}
