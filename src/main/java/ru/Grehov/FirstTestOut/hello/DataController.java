package ru.Grehov.FirstTestOut.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
        // Хранилища (создаются один раз при старте приложения)
    private ArrayList<String> arrayList = new ArrayList<>();
    private HashMap<Integer, String> hashMap = new HashMap<>();
    private int mapKey = 0;

    /**
     * 1. GET /update-array?s=значение
     * Добавляет строку в ArrayList.
     */
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam("s") String s) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(s);
        return "Added to ArrayList: " + s + ". Size: " + arrayList.size();
    }

    /**
     * 2. GET /show-array
     * Возвращает все элементы ArrayList.
     */
    @GetMapping("/show-array")
    public String showArrayList() {
        return "ArrayList: " + arrayList.toString();
    }

    /**
     * 3. GET /update-map?s=значение
     * Добавляет строку в HashMap с автоинкрементным ключом.
     */
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam("s") String s) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(mapKey++, s);
        return "Added to HashMap: " + s + ". Size: " + hashMap.size();
    }

    /**
     * 4. GET /show-map
     * Возвращает все элементы HashMap.
     */
    @GetMapping("/show-map")
    public String showHashMap() {
        StringBuilder sb = new StringBuilder("HashMap:\n");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    /**
     * 5. GET /show-all-lenght
     * Возвращает количество элементов в ArrayList и HashMap.
     */
    @GetMapping("/show-all-lenght")
    public String showAllLength() {
        return "ArrayList size: " + arrayList.size() +
               ", HashMap size: " + hashMap.size();
    }
}
