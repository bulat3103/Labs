package commands;

import exceptions.WrongAmountOfParametersException;
import managers.CollectionManager;

/**
 * Command 'show'. Shows information about all elements of the collection.
 */
public class ShowCommand extends AbstractCommand{
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести все элементы коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfParametersException();
            System.out.println(collectionManager.toString());
            return true;
        } catch (WrongAmountOfParametersException exception) {
            System.out.println("У этой команды нет параметров!");
        }
        return false;
    }
}
