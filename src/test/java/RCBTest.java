import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class RCBTest {

    RCBData rcbdata;
    @BeforeClass
    public void getRCBData() {
         rcbdata=Data.getData();
    }

    @Test(description ="Verify team has only 4 Foreign players" )
    public void validateForeignPlayers() {
        int expectedforeignPlayerCount=4;
        int foreignPlayerCount=0;
        List<Player> players= rcbdata.getPlayer();
        for(Player player:players) {
            if(!player.getCountry().equalsIgnoreCase("india")) {
                foreignPlayerCount++;
            }
        }
        Assert.assertEquals(foreignPlayerCount,expectedforeignPlayerCount,"Foreign Player count is more than 4");
    }

    @Test(description = "verify team has atleast one wicket keeper")
    public void validatePresenceOfWicketKeeper() {
        int wikcetKeeper=0;
        List<Player> players= rcbdata.getPlayer();
        for(Player player:players) {
            if(player.getRole().equalsIgnoreCase("Wicket-keeper")) {
                wikcetKeeper++;
            }
        }
        Assert.assertTrue(wikcetKeeper>0,"wikcet Keeper  count is more than 0");
    }
}
