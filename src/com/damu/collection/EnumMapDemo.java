package com.damu.collection;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        // 🔥 EnumMap = High-performance, memory-efficient Map for enum keys
        // ✅ Faster than HashMap for enums
        // ✅ Maintains insertion order based on enum declaration (ordinal order)
        // ✅ Uses internal array (no hashing, no collisions)
        // ❌ Null keys NOT allowed
        // ✅ Null values allowed
        // ❌ Not thread-safe (wrap with Collections.synchronizedMap if needed)

        // Example: Creating a map with enum as key
        Map<Day, String> map = new EnumMap<>(Day.class);

        // ✅ Put values – internally stored based on Day.ordinal()
        map.put(Day.TUESDAY, "Gym");
        map.put(Day.MONDAY, "Walk");

        // ✅ Get value
        String s = map.get(Day.TUESDAY);

        // 🧠 Output will be in enum order: {MONDAY=Walk, TUESDAY=Gym}
        System.out.println(map);
    }
}

// ✅ Enum used as key for EnumMap
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
