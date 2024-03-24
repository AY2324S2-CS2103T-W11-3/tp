package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.util.SampleDataUtil;


/**
 * Adds sample data to Dook
 */
public class SampleCommand extends Command {
    public static final String COMMAND_WORD = "sample";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Populates Dook with sample data.\n"
            + "Dook must be empty (no persons or bookings)"
            + "Enter 'clear' to empty Dook.";

    public static final String MESSAGE_SUCCESS = "Sample data added.";
    public static final String MESSAGE_FAILURE = "Error, Dook needs to be empty before sample data can be added.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.isEmpty()) {
            throw new CommandException(MESSAGE_FAILURE);
        }

        ReadOnlyAddressBook sampleAddressBook = SampleDataUtil.getSampleAddressBook();
        model.setAddressBook(sampleAddressBook);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}

