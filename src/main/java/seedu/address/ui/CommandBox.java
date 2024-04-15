package seedu.address.ui;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Region;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The UI component that is responsible for receiving user command inputs.
 */
public class CommandBox extends UiPart<Region> {

    public static final String ERROR_STYLE_CLASS = "error";
    private static final String FXML = "CommandBox.fxml";

    private final CommandExecutor commandExecutor;

    @FXML
    private TextField commandTextField;

    /**
     * Creates a {@code CommandBox} with the given {@code CommandExecutor}.
     */
    public CommandBox(CommandExecutor commandExecutor) {
        super(FXML);
        this.commandExecutor = commandExecutor;

        // calls #setStyleToDefault() whenever there is a change to the text of the command box.
        commandTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.startsWith("> ")) {
                commandTextField.setText("> " + newValue.replaceAll("^> ?", ""));
                commandTextField.positionCaret(commandTextField.getText().length());
            }
            setStyleToDefault();
        });

        commandTextField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY).match(event)
                    || new KeyCodeCombination(KeyCode.C, KeyCombination.META_ANY).match(event)) {
                copyTextWithoutPrompt();
                event.consume();
            } else {
                handleKeyEvents(event);
            }
        });

        commandTextField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            KeyCodeCombination pasteCombination = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY);
            KeyCodeCombination pasteCombinationMac = new KeyCodeCombination(KeyCode.V, KeyCombination.META_ANY);
            if (pasteCombination.match(event) || pasteCombinationMac.match(event)) {
                pasteTextFromClipboard();
                event.consume();
            }
        });

        commandTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                commandTextField.positionCaret(2);
                event.consume();
            }
        });

        commandTextField.setOnMouseClicked(event -> {
            Platform.runLater(() -> {
                if (commandTextField.getCaretPosition() < 2) {
                    commandTextField.positionCaret(2);
                }
            });
        });

        setupScrollingOnCommandTextField();
    }

    /**
     * Handles the Enter button pressed event.
     */
    @FXML
    private void handleCommandEntered() {
        try {
            // Extract the actual command text entered by the user.
            String commandText = commandTextField.getText().substring(2).trim();

            if (!commandText.isEmpty()) {
                commandExecutor.execute(commandText);

                // Clear the command input only if the command is successful.
                commandTextField.setText("> ");
            }
        } catch (CommandException | ParseException e) {
            // If there's an error, indicate command failure without clearing the text
            System.out.println("some ui error detected");
            commandTextField.positionCaret(commandTextField.getText().length());
            setStyleToIndicateCommandFailure();
        } finally {
            commandTextField.positionCaret(commandTextField.getText().length());
        }
    }

    /**
     * Sets the command box style to use the default style.
     */
    private void setStyleToDefault() {
        commandTextField.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        ObservableList<String> styleClass = commandTextField.getStyleClass();

        if (!styleClass.contains(ERROR_STYLE_CLASS)) {
            styleClass.add(ERROR_STYLE_CLASS);
            System.out.println("Error style class added.");
        }

        // Keep the caret at the end of the text
        commandTextField.positionCaret(commandTextField.getText().length());
    }

    /**
     * Handles key press events within the command text field.
     * This method is designed to prevent modification of the command prompt
     * and to manage the caret position correctly. It consumes key events that
     * could move the caret to a position before the prompt or that could modify
     * the prompt itself.
     *
     * @param event The {@code KeyEvent} that occurred within the command text field.
     */
    private void handleKeyEvents(KeyEvent event) {
        int caretPosition = commandTextField.getCaretPosition();
        KeyCode code = event.getCode();

        if (caretPosition <= 2 && (code.isArrowKey()
                || code.isWhitespaceKey() || code.isLetterKey() || code.isDigitKey())) {
            event.consume();
        } else if ((code == KeyCode.BACK_SPACE && caretPosition == 2)
                || (code == KeyCode.DELETE && caretPosition == 1)) {
            event.consume();
        }
    }


    /**
     * Sets up the ability to "scroll" horizontally in the text field using the mouse wheel.
     */
    private void setupScrollingOnCommandTextField() {
        commandTextField.addEventFilter(ScrollEvent.SCROLL, event -> {
            double deltaX = event.getDeltaX();
            double deltaY = event.getDeltaY();
            double effectiveDelta = Math.abs(deltaX) > Math.abs(deltaY) ? deltaX : deltaY;

            int caretPosition = commandTextField.getCaretPosition();
            if (effectiveDelta < 0) { // Scroll left or down
                // Ensures that scrolling does not move the caret before the prompt
                if (caretPosition < commandTextField.getText().length() && caretPosition > 2) {
                    commandTextField.positionCaret(Math.max(caretPosition + 1, 2));
                }
            } else if (effectiveDelta > 0) { // Scroll right or up
                // Prevents scrolling from moving the caret into the prompt
                if (caretPosition > 2) {
                    commandTextField.positionCaret(Math.max(caretPosition - 1, 2));
                }
            }
            event.consume();
        });
    }


    /**
     * Copies the selected text from the command text field to the system clipboard,
     * excluding the prompt ("> ")
     */
    private void copyTextWithoutPrompt() {
        String selectedText = commandTextField.getSelectedText();
        int selectionStart = commandTextField.getSelection().getStart();
        int selectionEnd = commandTextField.getSelection().getEnd();

        if (selectionStart < 2) {
            selectedText = commandTextField.getText().substring(2, selectionEnd);
        }

        ClipboardContent content = new ClipboardContent();
        content.putString(selectedText);
        Clipboard.getSystemClipboard().setContent(content);
    }

    /**
     * Pastes the selected text from the command text field to the system clipboard,
     * excluding the prompt ("> ")
     */
    private void pasteTextFromClipboard() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if (clipboard.hasString()) {
            String clipboardText = clipboard.getString();

            int caretPosition = commandTextField.getCaretPosition();
            if (caretPosition <= 2) {
                commandTextField.positionCaret(commandTextField.getText().length()); // Move the caret to the end
            }

            commandTextField.replaceSelection(clipboardText);
        }
    }

    /**
     * Represents a function that can execute commands.
     */
    @FunctionalInterface
    public interface CommandExecutor {
        /**
         * Executes the command and returns the result.
         *
         * @see seedu.address.logic.Logic#execute(String)
         */
        CommandResult execute(String commandText) throws CommandException, ParseException;
    }

}
