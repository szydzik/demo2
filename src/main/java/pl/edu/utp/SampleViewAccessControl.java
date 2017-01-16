package pl.edu.utp;

import com.vaadin.spring.access.ViewAccessControl;
import com.vaadin.ui.UI;
import org.springframework.stereotype.Component;
import pl.edu.utp.view.AdminSecretView;

/**
 * This demonstrates how you can control access to views.
 */
@Component
public class SampleViewAccessControl implements ViewAccessControl {

    @Override
    public boolean isAccessGranted(UI ui, String beanName) {
        System.out.println("debug------> beanName: "+beanName);
        if (beanName.equals("adminSecretView")) {
            System.out.println(AdminSecretView.VIEW_NAME+": odmówiono autoryzacji");
            return SecurityUtils.hasRole("ROLE_ADMIN");
        } else {
//            return true;
            return SecurityUtils.hasRole("ROLE_USER");
        }
    }
}
