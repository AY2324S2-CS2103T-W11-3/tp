package seedu.address.logic.commands;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.storage.AddressBookStorage;
import seedu.address.storage.JsonAddressBookStorage;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;

public class SampleCommand extends Command {
    public static final String COMMAND_WORD = "sample";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Populates Dook with sample data.\n" +
            "Dook must be empty (no persons or bookings)" +
            "Enter 'clear' to empty Dook.";

    public static final String MESSAGE_SUCCESS = "Sample data added.";
    public static final String MESSAGE_FAILURE = "Error, Dook is not empty, execution aborted.";

    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.isEmpty()) {
            throw new CommandException(MESSAGE_FAILURE);
        }

        Path samplePath = Paths.get("storage/util/sampleAddressBook.json");
        AddressBookStorage sampleAddressBook = new JsonAddressBookStorage(samplePath);

        try {
            ReadOnlyAddressBook sample = sampleAddressBook.readAddressBook().get();
            model.setAddressBook(sample);
        } catch (DataLoadingException e) {
            throw new CommandException("ERROR: Cannot find SAMPLE DATA FILE");
        }

            return new CommandResult(MESSAGE_SUCCESS);
    }
}

