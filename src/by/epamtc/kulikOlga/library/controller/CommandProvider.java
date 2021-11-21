package by.epamtc.kulikOlga.library.controller;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.controller.command.CommandName;
import by.epamtc.kulikOlga.library.controller.impl.book.*;
import by.epamtc.kulikOlga.library.controller.impl.user.SignIn;
import by.epamtc.kulikOlga.library.controller.impl.user.Registration;
import by.epamtc.kulikOlga.library.controller.impl.user.SignOut;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.SIGN_OUT, new SignOut());
        repository.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
        repository.put(CommandName.EDIT_BOOK, new EditBook());
        repository.put(CommandName.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandName.FIND_BY_AUTHOR, new FindByAuthor());
        repository.put(CommandName.FIND_BY_GENRE, new FindByGenre());
        repository.put(CommandName.FIND_BY_ID, new FindByID());
        repository.put(CommandName.FIND_BY_TITLE, new FindByTitle());
        repository.put(CommandName.FIND_ALL_BOOKS, new FindAllBooks());
    }

    public void setCommand(CommandName commandName, Command command) {
        repository.put(commandName, command);
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
