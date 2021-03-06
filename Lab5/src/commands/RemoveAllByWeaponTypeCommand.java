package commands;

import data.Weapon;
import exceptions.EmptyCollectionException;
import exceptions.WrongAmountOfParametersException;
import managers.CollectionManager;

import java.util.List;

/**
 * Command 'remove_all_by_weapon_type'. Removes from the collection all items whose value of the weaponType field is equivalent to the specified one.
 */
public class RemoveAllByWeaponTypeCommand extends AbstractCommand{
    private CollectionManager collectionManager;

    public RemoveAllByWeaponTypeCommand(CollectionManager collectionManager) {
        super("remove_all_by_weapon_type <weaponType>", "удалить из коллекции все элементы, значение поля weaponType которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfParametersException();
            if (collectionManager.collectionSize() == 0) throw new EmptyCollectionException();
            Weapon weapon = Weapon.valueOf(argument.toUpperCase());
            List<Integer> keys = collectionManager.getKeyByWeaponType(weapon);
            for (Integer i : keys) {
                collectionManager.removeFromCollection(i);
            }
            return true;
        } catch (WrongAmountOfParametersException exception) {
            System.out.println("Вместе с этой командой должен быть передан параметр! Наберит 'help' для справки");
        } catch (EmptyCollectionException exception) {
            System.out.println("Коллекция пуста!");
        }
        return false;
    }
}
