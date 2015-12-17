package jmp.module04;

import jmp.module04.actions.impl.MoveAction;
import jmp.module04.utils.GraphicApp;

import java.util.List;

/**
 * The Main class
 */
public class Main {

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) {
        final String LEFT_TEXT_AREA = "The Left Text Area";
        final String RIGHT_TEXT_AREA = "The Right Text Area";
        final String LEFT_BUTTON = "To The Left";
        final String RIGHT_BUTTON = "To The Right";

        GraphicApp gApp = GraphicApp.newBuilder()
                                    .addTextArea(LEFT_TEXT_AREA)
                                    .addTextArea(RIGHT_TEXT_AREA)
                                    .addButton(LEFT_BUTTON)
                                    .addButton(RIGHT_BUTTON)
                                    .build();

        List<String> leftTextArea = gApp.getTextArea(LEFT_TEXT_AREA);
        List<String> rightTextArea = gApp.getTextArea(RIGHT_TEXT_AREA );

        gApp.addButtonAction(LEFT_BUTTON, new MoveAction(leftTextArea, rightTextArea));
        gApp.addButtonAction(RIGHT_BUTTON, new MoveAction(rightTextArea, leftTextArea));

        leftTextArea.add("1");
        leftTextArea.add("2");

        rightTextArea.add("3");
        rightTextArea.add("4");

        gApp.start();
    }

}