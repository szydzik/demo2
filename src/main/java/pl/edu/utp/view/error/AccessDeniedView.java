package pl.edu.utp.view.error;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent // No SpringView annotation because this view can not be navigated to
@UIScope
public class AccessDeniedView extends VerticalLayout implements View {

    public AccessDeniedView() {
        setMargin(true);
        Label label = new Label("You don't have access to this view. (Nie masz dostępu do tego widoku!)");
        label.addStyleName(ValoTheme.LABEL_FAILURE);
        label.setSizeUndefined();
        addComponent(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
