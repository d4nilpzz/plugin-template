package dev.d4nilpzz.pluginTemplate;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import revxrsal.commands.annotation.Command;

public class LaunchCommand {

    /*
    * Launch the player with the given power
    * @param power the power of the launch
    * */
    @Command("launch")
    public void launch(Player sender, Double power) {
        sender.setVelocity(new Vector(0, getPower(power), 0));
    }

    /*
    * Calculate the power of the launch
    * */
    public int getPower(Double power) {
        return (int)(2 * power);
    }
}
