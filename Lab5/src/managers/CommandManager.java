package managers;

import commands.AbstractCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private final int COMMAND_HISTORY_MAX_VALUE = 14;

    private String[] commandHistory = new String[COMMAND_HISTORY_MAX_VALUE];
    private List<AbstractCommand> commands = new ArrayList<>();
    private AbstractCommand helpCommand;
    private AbstractCommand infoCommand;
    private AbstractCommand showCommand;
    private AbstractCommand insertCommand;
    private AbstractCommand updateCommand;
    private AbstractCommand removeKeyCommand;
    private AbstractCommand clearCommand;
    private AbstractCommand saveCommand;
    private AbstractCommand executeScriptCommand;
    private AbstractCommand exitCommand;
    private AbstractCommand removeGreaterCommand;
    private AbstractCommand historyCommand;
    private AbstractCommand removeLowerKeyCommand;
    private AbstractCommand removeAllByWeaponTypeCommand;
    private AbstractCommand sumOfHealthCommand;
    private AbstractCommand averageOfHeartCountCommand;

    public CommandManager(AbstractCommand helpCommand, AbstractCommand infoCommand, AbstractCommand showCommand, AbstractCommand insertCommand, AbstractCommand updateCommand, AbstractCommand removeKeyCommand, AbstractCommand clearCommand, AbstractCommand saveCommand, AbstractCommand executeScriptCommand, AbstractCommand exitCommand, AbstractCommand removeGreaterCommand, AbstractCommand historyCommand, AbstractCommand removeLowerKeyCommand, AbstractCommand removeAllByWeaponTypeCommand, AbstractCommand sumOfHealthCommand, AbstractCommand averageOfHeartCountCommand) {
        this.helpCommand = helpCommand;
        commands.add(helpCommand);
        this.infoCommand = infoCommand;
        commands.add(infoCommand);
        this.showCommand = showCommand;
        commands.add(showCommand);
        this.insertCommand = insertCommand;
        commands.add(insertCommand);
        this.updateCommand = updateCommand;
        commands.add(updateCommand);
        this.removeKeyCommand = removeKeyCommand;
        commands.add(removeKeyCommand);
        this.clearCommand = clearCommand;
        commands.add(clearCommand);
        this.saveCommand = saveCommand;
        commands.add(saveCommand);
        this.executeScriptCommand = executeScriptCommand;
        commands.add(executeScriptCommand);
        this.exitCommand = exitCommand;
        commands.add(exitCommand);
        this.removeGreaterCommand = removeGreaterCommand;
        commands.add(removeGreaterCommand);
        this.historyCommand = historyCommand;
        commands.add(historyCommand);
        this.removeLowerKeyCommand = removeLowerKeyCommand;
        commands.add(removeLowerKeyCommand);
        this.removeAllByWeaponTypeCommand = removeAllByWeaponTypeCommand;
        commands.add(removeAllByWeaponTypeCommand);
        this.sumOfHealthCommand = sumOfHealthCommand;
        commands.add(sumOfHealthCommand);
        this.averageOfHeartCountCommand = averageOfHeartCountCommand;
        commands.add(averageOfHeartCountCommand);
    }

    public void addToHistory(String commandToAdd) {
        for (AbstractCommand command : commands) {
            if (command.getName().split(" ")[0].equals(commandToAdd)) {
                for (int i = COMMAND_HISTORY_MAX_VALUE - 1; i > 0; i--) {
                    commandHistory[i] = commandHistory[i - 1];
                }
                commandHistory[0] = commandToAdd;
            }
        }
    }

    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (AbstractCommand command : commands) {
                System.out.println(command.getName() + ": " + command.getDescription());
            }
            return true;
        } else return false;
    }

    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    public boolean insert(String argument) {
        return insertCommand.execute(argument);
    }

    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    public boolean removeKey(String argument) {
        return removeKeyCommand.execute(argument);
    }

    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    public boolean removeGreater(String argument) {
        return removeGreaterCommand.execute(argument);
    }

    public boolean history(String argument) {
        if (historyCommand.execute(argument)) {
            if (commandHistory.length == 0) {
                System.out.println("Ни одной команды еще не было использовано!");
                return false;
            }
            System.out.println("Последние использованные команды:");
            for (int i = 0; i < commandHistory.length; i++) {
                if (commandHistory[i] != null) System.out.println(" " + commandHistory[i]);
            }
            return true;
        }
        return false;
    }

    public boolean removeLowerKey(String argument) {
        return removeLowerKeyCommand.execute(argument);
    }

    public boolean removeAllByWeaponType(String argument) {
        return removeAllByWeaponTypeCommand.execute(argument);
    }

    public boolean averageOfHeartCount(String argument) {
        return averageOfHeartCountCommand.execute(argument);
    }

    public boolean sumOfHealth(String argument) {
        return sumOfHealthCommand.execute(argument);
    }

    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }
}
