import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.quest.Quests;
import org.dreambot.api.methods.quest.book.FreeQuest;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.interactive.NPC;

import static org.dreambot.api.methods.interactive.Players.getLocal;

public class ErnestTheChicken {
    public static int onLoop(CoffScript s) {
        if ((boolean) State.getInstance().questsDone.get(FreeQuest.ERNEST_THE_CHICKEN) || Inventory.isFull()) {
            State.getInstance().clearActivity();
            return 1000;
        }

        int configValue = PlayerSettings.getConfig(32);

        if (configValue == 3) {
            // Quest done
            State.getInstance().questsDone.put(FreeQuest.ERNEST_THE_CHICKEN, true);
        } else if (configValue == 0) {
            // Quest not started
            if (!Constants.DRAYNOR_MANOR_ENTRANCE.contains(getLocal())) {
                s.log("Walking to Draynor Manor Entrance");
                Walking.walk(Constants.DRAYNOR_MANOR_ENTRANCE.getCenter());
            } else {
                NPC veronica = NPCs.closest("Veronica");
                if (Dialogues.inDialogue()) {
                    Dialogues.chooseOption(1);
                    Dialogues.continueDialogue();
                } else {
                    veronica.interact("Talk-to");
                }
            }
        } else if (!Inventory.contains(Constants.PRESSURE_GAUGE)) {
            if (!Inventory.contains(Constants.POISONED_FISH_FOOD) && !Constants.FOUNTAIN_AREA.contains(getLocal())) {
                if (!Inventory.contains(Constants.FISH_FOOD)) {
                    if (getLocal().getZ() == 0) {
                        if (!Constants.DRAYNOR_MANOR_DOWNSTAIRS.contains(getLocal())) {
                            s.log("Walking to Draynor Manor Downstairs");
                            Walking.walk(Constants.DRAYNOR_MANOR_DOWNSTAIRS);
                        } else {
                            GameObjects.closest(Constants.STAIRCASE).interact("Climb-up");
                        }
                    } else if (!Constants.FISH_FOOD_AREA.contains(getLocal())) {
                        s.log("Walking to fish food area");
                        Walking.walk(Constants.FISH_FOOD_AREA);
                    } else if (GroundItems.closest(Constants.FISH_FOOD) != null) {
                        GroundItems.closest(Constants.FISH_FOOD).interact("Take");
                    } else {
                        s.log("Can't see any fish food");
                    }
                } else if (!Inventory.contains(Constants.POISON)) {
                    if (getLocal().getZ() == 1) {
                        if (!Constants.DRAYNOR_MANOR_UPSTAIRS.contains(getLocal())) {
                            s.log("Walking to Draynor Manor Upstairs");
                            Walking.walk(Constants.DRAYNOR_MANOR_UPSTAIRS.getCenter());
                        } else {
                            GameObjects.closest(Constants.STAIRCASE).interact("Climb-down");
                        }
                    } else if (!Constants.POISON_AREA.contains(getLocal())) {
                        s.log("Walking to poison area");
                        Walking.walk(Constants.POISON_AREA.getCenter());
                    } else if (GroundItems.closest(Constants.POISON) != null) {
                        GroundItems.closest(Constants.POISON).interact("Take");
                    } else {
                        s.log("Can't see any poison");
                    }
                } else {
                    Inventory.get(Constants.POISON).useOn(Inventory.get(Constants.FISH_FOOD));
                }
            } else if (!Inventory.contains(Constants.SPADE)) {
                if (Constants.SPADE_AREA.contains(getLocal())) {
                    GroundItems.closest(Constants.SPADE).interact("Take");
                } else {
                    Walking.walk(Constants.SPADE_AREA);
                }
            } else if (!Constants.FOUNTAIN_AREA.contains(getLocal())) {
                Walking.walk(Constants.FOUNTAIN_AREA);
            } else if (Inventory.contains(Constants.POISONED_FISH_FOOD)) {
                Inventory.get(Constants.POISONED_FISH_FOOD).useOn(GameObjects.closest(Constants.FOUNTAIN));
            } else if (Dialogues.inDialogue()) {
                Dialogues.continueDialogue();
            } else {
                GameObjects.closest(Constants.FOUNTAIN).interact("Search");
                s.sleep(500, 1000);
            }
        } else if (!Inventory.contains(Constants.RUBBER_TUBE)) {
            if (!Inventory.contains(Constants.KEY)) {
                if (!Constants.COMPOST_AREA.contains(getLocal())) {
                    Walking.walk(Constants.COMPOST_AREA);
                } else {
                    GameObjects.closest(Constants.COMPOST_HEAP).interact("Search");
                }
            } else {
                if (!Constants.RUBBER_TUBE_ROOM.contains(getLocal())) {
                    Walking.walk(Constants.RUBBER_TUBE_ROOM);
                } else {
                    GroundItems.closest(Constants.RUBBER_TUBE).interact("Take");
                }
            }
        } else if (!Inventory.contains(Constants.OIL_CAN)) {
            s.log("Getting oil can");
            if (!Constants.BASEMENT_AREA.contains(getLocal())) {
                if (!Constants.LADDER_GROUND_FLOOR.contains(getLocal())) {
                    s.log("Walking to ladder upstairs");
                    if (Constants.BOOKCASE_AREA.contains(getLocal())) {
                        GameObjects.closest(Constants.BOOKCASE).interact("Search");
                    } else Walking.walk(Constants.BOOKCASE_AREA.getCenter());
                } else {
                    GameObjects.closest(Constants.LADDER).interact("Climb-down");
                }
            } else if (!leverFDown()) {
                if (!leverDDown()) {
                    if (leverADown() && leverBDown()) {
                        if (Constants.LEVER_C_D_AREA.contains(getLocal())) {
                            GameObjects.closest(Constants.LEVER_D).interact("Pull");
                            s.sleep(800, 1000);
                        } else {
                            Walking.walk(Constants.LEVER_C_D_AREA);
                        }
                    } else if (!Constants.LEVER_A_B_AREA.contains(getLocal())) {
                        Walking.walk(Constants.LEVER_A_B_AREA);
                    } else if (!leverBDown()) {
                        GameObjects.closest(Constants.LEVER_B).interact("Pull");
                        s.sleep(800, 1000);
                    } else if (!leverADown()) {
                        GameObjects.closest(Constants.LEVER_A).interact("Pull");
                        s.sleep(800, 1000);
                    }
                } else if (!leverBDown() && !leverADown()) {
                    if (Constants.LEVER_E_F_AREA.contains(getLocal())) {
                        GameObjects.closest(Constants.LEVER_F).interact("Pull");
                        s.sleep(800, 1000);
                    } else {
                        Walking.walk(Constants.LEVER_E_F_AREA);
                    }
                } else if (!Constants.LEVER_A_B_AREA.contains(getLocal())) {
                    Walking.walk(Constants.LEVER_A_B_AREA);
                } else if (leverBDown()) {
                    GameObjects.closest(Constants.LEVER_B).interact("Pull");
                    s.sleep(800, 1000);
                } else if (leverADown()) {
                    GameObjects.closest(Constants.LEVER_A).interact("Pull");
                    s.sleep(800, 1000);
                }
            } else if (!leverCDown()) {
                if (!leverEDown()) {
                    if (!Constants.LEVER_E_F_AREA.contains(getLocal())) {
                        Walking.walk(Constants.LEVER_E_F_AREA);
                    } else {
                        GameObjects.closest(Constants.LEVER_E).interact("Pull");
                        s.sleep(800, 1000);
                    }
                } else {
                    if (!Constants.LEVER_C_D_AREA.contains(getLocal())) {
                        Walking.walk(Constants.LEVER_C_D_AREA);
                    } else {
                        GameObjects.closest(Constants.LEVER_C).interact("Pull");
                        s.sleep(800, 1000);
                    }
                }
            } else if (leverEDown()) {
                if (!Constants.LEVER_E_F_AREA.contains(getLocal())) {
                    Walking.walk(Constants.LEVER_E_F_AREA);
                } else {
                    GameObjects.closest(Constants.LEVER_E).interact("Pull");
                    s.sleep(800, 1000);
                }
            } else if (!Constants.OIL_CAN_AREA.contains(getLocal())) {
                Walking.walk(Constants.OIL_CAN_AREA);
            } else {
                GroundItems.closest(Constants.OIL_CAN).interact("Take");
            }
        } else if (Constants.BASEMENT_AREA.contains(getLocal())) {
            if (Constants.BASEMENT_LADDER.contains(getLocal())) {
                GameObjects.closest(Constants.LADDER).interact("Climb-up");
            }
            else Walking.walk(Constants.BASEMENT_LADDER);
        } else if (Constants.LADDER_GROUND_FLOOR.contains(getLocal())) {
            GameObjects.closest(Constants.LEVER).interact("Pull");
        } else if (getLocal().getZ() == 0) {
            if (!Constants.DRAYNOR_MANOR_DOWNSTAIRS.contains(getLocal())) {
                Walking.walk(Constants.DRAYNOR_MANOR_DOWNSTAIRS);
            } else {
                GameObjects.closest(Constants.STAIRCASE).interact("Climb-up");
            }
        } else if (getLocal().getZ() == 1) {
            GameObjects.all(Constants.STAIRCASE).stream().filter(x -> x.hasAction("Climb-up")).findFirst().get().interact("Climb-up");
        } else if (getLocal().getZ() == 2) {
            s.log("Walking to Oddenstein's room");
            if (!Constants.ODDENSTEIN_ROOM.contains(getLocal())) {
                Walking.walk(Constants.ODDENSTEIN_ROOM);
            } else {
                if (Dialogues.inDialogue()) {
                    Dialogues.chooseOption(1);
                    Dialogues.continueDialogue();
                } else {
                    NPCs.closest("Professor Oddenstein").interact("Talk-to");
                }
            }
        }

        return 2000;
    }

    public static boolean leverADown() {
        return PlayerSettings.getBitValue(1788) == 1;
    }

    public static boolean leverBDown() {
        return PlayerSettings.getBitValue(1789) == 1;
    }

    public static boolean leverCDown() {
        return PlayerSettings.getBitValue(1798) == 1;
    }

    public static boolean leverDDown() {
        return PlayerSettings.getBitValue(1802) == 1;
    }

    public static boolean leverEDown() {
        return PlayerSettings.getBitValue(1792) == 1;
    }

    public static boolean leverFDown() {
        return PlayerSettings.getBitValue(1795) == 1;
    }
}
