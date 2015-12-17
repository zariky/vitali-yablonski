package jmp.module04.utils;

import jmp.module04.actions.Action;
import jmp.module04.adapters.JTextAreaAdapter;

import static javax.swing.JScrollPane.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The Graphic Application
 */
public class GraphicApp {

    /**
     * The {@link Map} all {@link JTextArea} that registers into application
     */
    private Map<String, JTextArea> textAreas;

    /**
     * The {@link Map} all {@link JButton} that registers into application
     */
    private Map<String, JButton> buttons;

    /**
     * The Constructor of {@link GraphicApp} that is PRIVATE because an instance should be created from {@link Builder}
     */
    private GraphicApp() {
        textAreas = new LinkedHashMap<String, JTextArea>();
        buttons = new LinkedHashMap<String, JButton>();
    }

    /**
     * Get a {@link List} of records that associates with {@link JTextArea} by text area name
     * @param name a {@link JTextArea} name
     * @return a {@link List} that associates with {@link JTextArea}
     */
    public List<String> getTextArea(final String name) {
        List<String> textArea = null;

        if (name != null && textAreas.containsKey(name)) {
            textArea = new JTextAreaAdapter(textAreas.get(name));
        }

        return textArea;
    }

    /**
     * Add an {@link Action} to {@link JButton} by button name
     * @param buttonName a {@link JButton} name
     * @param action an {@link Action}
     */
    public void addButtonAction(final String buttonName, final Action action) {
        if (buttonName != null && action != null &&  buttons.containsKey(buttonName)) {
            buttons.get(buttonName).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg) {
                    action.perform();
                }
            });
        }
    }

    /**
     * The Start of application
     */
    public void start() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crateWindow();
            }
        });
    }

    /**
     * Create the main window of application
     */
    private void crateWindow() {
        JPanel rootPanel = new JPanel();
        rootPanel.add(createTextAreasPanel());
        rootPanel.add(createButtonsPanel());

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(rootPanel);
        window.pack();
        window.setVisible(true);
    }

    /**
     * Create {@link JPanel} that contains {@link JTextArea}
     * @return a {@link JPanel}
     */
    private JPanel createTextAreasPanel() {
        JPanel panel = new JPanel();

        for(Map.Entry<String, JTextArea> textArea : textAreas.entrySet()) {
            JScrollPane textAreaScrollPane = new JScrollPane(textArea.getValue(), VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER);
            panel.add(textAreaScrollPane);
        }

        return panel;
    }

    /**
     * Create {@link JPanel} that contains {@link JButton}
     * @return a {@link JPanel}
     */
    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();

        for(Map.Entry<String, JButton> button : buttons.entrySet()) {
            panel.add(button.getValue());
        }

        return panel;
    }

    /**
     * Create new {@link Builder} builder for {@link GraphicApp}
     * @return a {@link Builder}
     */
    public static Builder newBuilder() {
        return new GraphicApp().new Builder();
    }

    /**
     * The Builder of {@link GraphicApp}
     */
    public class Builder {

        /**
         * The Constructor of {@link Builder} that is PRIVATE because an instance should be created from {@link GraphicApp}
         */
        private Builder() {
        }

        /**
         * Add a {@link JTextArea} to application
         * @param name a name of {@link JTextArea}
         * @return the {@link Builder}
         */
        public Builder addTextArea(String name) {
            if (name != null) {
                JTextArea textArea = new JTextArea(7, 14);
                textArea.setLineWrap(true);
                textAreas.put(name, textArea);
            }
            return this;
        }

        /**
         * Add a {@link JButton} to application
         * @param name a name of {@link JButton}
         * @return the {@link Builder}
         */
        public Builder addButton(String name) {
            if (name != null) {
                buttons.put(name, new JButton(name));
            }
            return this;
        }

        /**
         * Build a {@link GraphicApp}
         * @return a {@link GraphicApp}
         */
        public GraphicApp build() {
            return GraphicApp.this;
        }

    }

}