import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

public class Constants {
    public static final String[] RESTRICTED = new String[] {
            "Oak logs",
            "Willow logs",
            "Yew logs",
            "Raw shrimps",
            "Shrimps",
            "Raw anchovies",
            "Anchovies",
            "Raw lobster",
            "Lobster",
            "Clay",
            "Soft clay",
            "Copper ore",
            "Tin ore",
            "Iron ore",
            "Silver ore",
            "Gold ore",
            "Coal",
            "Mithril ore",
            "Adamantite ore",
            "Runite ore",
            "Cowhide",
            "Vial",
            "Vial of water",
            "Jug of water",
            "Fishing bait",
            "Feather",
            "Eye of newt",
            "Wine of zamorak",
            "Air rune",
            "Water rune",
            "Earth rune",
            "Fire rune",
            "Mind rune",
            "Chaos rune"
    };
    public static final String ROD = "Fly fishing rod";
    public static final String NET = "Small fishing net";
    public static final String COINS = "Coins";
    public static final String COWHIDE = "Cowhide";
    public static final String FEATHER = "Feather";
    public static final String RAW_SALMON = "Raw salmon";
    public static final String RAW_TROUT = "Raw trout";
    public static final String TIN_ORE = "Tin ore";
    public static final String COPPER_ORE = "Copper ore";
    public static final String IRON_ORE = "Iron ore";
    public static final String STAFF_OF_AIR = "Staff of air";
    public static final String MIND_RUNE = "Mind rune";
    public static final String WATER_RUNE = "Water rune";
    public static final String BRONZE_SPEAR = "Bronze spear";
    public static final String IRON_PLATELEGS = "Iron platelegs";
    public static final String IRON_PLATEBODY = "Iron platebody";
    public static final String RAT_TAIL = "Rat's tail";
    public static final String RAW_BEEF = "Raw beef";
    public static final String BONES = "Bones";
    public static final String COOKED_MEAT = "Cooked meat";
    public static final String BURNT_MEAT = "Burnt meat";
    public static final String ONION = "Onion";
    public static final String EYE_OF_NEWT = "Eye of newt";
    public static final String IRON_SWORD = "Iron sword";
    public static final String MITHRIL_SCIMITAR = "Mithril scimitar";
    public static final String IRON_HELM = "Iron full helm";
    public static final String IRON_SHIELD = "Iron sq shield";
    public static final String FURNACE = "Furnace";
    public static final String RING_OF_FORGING = "Ring of forging";
    public static final String STAIRCASE = "Staircase";
    public static final String FISH_FOOD = "Fish food";
    public static final String POISON = "Poison";
    public static final String PRESSURE_GAUGE = "Pressure gauge";
    public static final String SPADE = "Spade";
    public static final String POISONED_FISH_FOOD = "Poisoned fish food";
    public static final String OIL_CAN = "Oil can";
    public static final String BOOKCASE = "Bookcase";
    public static final String LADDER = "Ladder";
    public static final String LEVER_A = "Lever A";
    public static final String LEVER_B = "Lever B";
    public static final String LEVER_C = "Lever C";
    public static final String LEVER_D = "Lever D";
    public static final String LEVER_E = "Lever E";
    public static final String LEVER_F = "Lever F";
    public static final String LEVER = "Lever";
    public static final String FOUNTAIN = "Fountain";
    public static final String COMPOST_HEAP = "Compost heap";
    public static final String RUBBER_TUBE = "Rubber tube";
    public static final String KEY = "Key";
    public static int SMELTING_ANIMATION_ID = 899;
    public static Area SPADE_AREA = new Area(3120, 3360, 3124, 3355);
    public static Area FURNACE_AREA = new Area(2976, 3370, 2973, 3368);
    public static Area CHICKEN_AREA = new Area(3020, 3296, 3014, 3282, 0);
    public static Area FLY_AREA = new Area(3109, 3434, 3099, 3424, 0);
    public static Area SHRIMP_AREA = new Area(3247, 3161, 3241, 3143, 0);
    public static Area FISHING_STORE_AREA = new Area(3016, 3229, 3012, 3223, 0);
    public static Area STAFF_STORE_AREA = new Area(3201, 3436, 3203, 3432);
    public static Area ARMOUR_STORE_AREA = new Area(3227, 3441, 3232, 3433);
    public static Area TUTORIAL_AREA = new Area(3055, 3060, 3150, 3135, 0);
    public static Area GOBLIN_AREA = new Area(3119, 3438, 3134, 3424);
    public static Area LUMBRIDGE_COW_AREA = new Area(3242, 3294, 3262, 3250);
    public static Area FALADOR_COW_AREA = new Area(3022, 3312, 3041, 3298);
    public static Area MAGIC_STORE_AREA = new Area(3251, 3401, 3254, 3400);
    public static Area WITCH_HOUSE_AREA = new Area(2965, 3207, 2970, 3203);
    public static Area ARCHERY_SHOP_AREA = new Area(2953, 3205, 2960, 3202);
    public static Area SHIELD_SHOP_AREA = new Area(2979, 3384, 2972, 3382);
    public static Area HELM_SHOP_AREA = new Area(3073, 3431, 3077, 3427);
    public static Area REMMINGTON_GENERAL_STORE_AREA = new Area(2950, 3218, 2946, 3211);
    public static Area SWORD_STORE_AREA = new Area(3202, 3401, 3208, 3396, 0);
    public static Area PORT_SARIM_FOOD_STORE_AREA = new Area(3012, 3203, 3015, 3207);
    public static Area PORT_SARIM_MAGIC_SHOP_AREA = new Area(3011, 3261, 3016, 3256);
    public static Area REMMINGTON_FARM = new Area(2946, 3253, 2954, 3248);
    public static Area EAST_FALADOR_BANK = new Area(3009, 3358, 3017, 3353);
    public static Area EDGEVILLE_BANK = new Area(3092, 3498, 3097, 3488);
    public static Area DRAYNOR_MANOR_ENTRANCE = new Area(3106, 3333, 3114, 3327);
    public static Area DRAYNOR_MANOR_DOWNSTAIRS = new Area(3107, 3364, 3110, 3361);
    public static Area DRAYNOR_MANOR_UPSTAIRS = new Area(3107, 3368, 3110, 3364, 1);
    public static Area LADDER_GROUND_FLOOR = new Area(3091, 3363, 3096, 3357);
    public static Area BASEMENT_LADDER = new Area(3118, 9757, 3112, 9750);
    public static Area FISH_FOOD_AREA = new Area(3107, 3360, 3109, 3354, 1);
    public static Area POISON_AREA = new Area(3099, 3364, 3096, 3366);
    public static Area BOOKCASE_AREA = new Area(3091, 3363, 3104, 3357);
    public static Area LEVER_A_B_AREA = new Area(3101, 9756, 3118, 9745);
    public static Area LEVER_C_D_AREA = new Area(3105, 9767, 3112, 9758);
    public static Area LEVER_E_F_AREA = new Area(3095, 9767, 3099, 9763);
    public static Area OIL_CAN_AREA = new Area(3089, 9757, 3098, 9753);
    public static Area ODDENSTEIN_ROOM = new Area(3108, 3370, 3112, 3362, 2);
    public static Area BASEMENT_AREA = new Area(3086, 9769, 3122, 9743);
    public static Area FOUNTAIN_AREA = new Area(3085, 3337, 3090, 3332);
    public static Area COMPOST_AREA = new Area(3084, 3362, 3086, 3359);
    public static Area RUBBER_TUBE_ROOM = new Area(3108, 3368, 3111, 3366);
    public static Tile DROP_TILE = new Tile(3153, 3389);
    public static FarmableMob[] FARMABLE_MOBS = new FarmableMob[] {
            new FarmableMob("Chicken", 1, CHICKEN_AREA, new String[] {
                    FEATHER
            }),
            new FarmableMob("Cow", 20, FALADOR_COW_AREA, new String[] {
                    COWHIDE,
                    RAW_BEEF,
                    BONES
            })
    };
}
