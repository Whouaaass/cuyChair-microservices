package co.edu.unicauca.cuychair.gui.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainViewTest {

    private MainView mainView;

    @BeforeEach
    public void setUp() {
        mainView = new MainView();
    }

    @Test
    public void testMainView() {
        mainView.setVisible(true);
    }
}