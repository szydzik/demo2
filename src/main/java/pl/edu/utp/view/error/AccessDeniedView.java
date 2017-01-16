package pl.edu.utp.view.error;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.spring.annotation.PrototypeScope;

import javax.annotation.PostConstruct;

@SpringComponent // No SpringView annotation because this view can not be navigated to
@PrototypeScope
public class AccessDeniedView extends VerticalLayout implements View {

    private Label message;

    @PostConstruct
    void init() {
        setMargin(true);
        message = new Label();
        addComponent(message);
        message.addStyleName(ValoTheme.LABEL_FAILURE);
        message.setContentMode(ContentMode.HTML);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        message.setValue(String.format("Sorry, but you don't have access to the view <b>%s</b>.", event.getViewName()));
    }
}
