package util;

import model.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class JsonManager {
    private Gson gson;

    public JsonManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Запис університету у файл у форматі JSON
    public void saveUniversityToJson(University university, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
            System.out.println("Університет успішно збережено у файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні у файл: " + e.getMessage());
        }
    }

    // Читання університету з JSON файлу
    public University loadUniversityFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            University university = gson.fromJson(reader, University.class);
            System.out.println("Університет успішно завантажено з файлу: " + filePath);
            return university;
        } catch (IOException e) {
            System.err.println("Помилка при завантаженні з файлу: " + e.getMessage());
            return null;
        }
    }

    // Конвертація університету в JSON строку
    public String universityToJsonString(University university) {
        return gson.toJson(university);
    }

    // Конвертація JSON строки в університет
    public University jsonStringToUniversity(String jsonString) {
        return gson.fromJson(jsonString, University.class);
    }
}