package practice.serializer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

//Сериализация из JSON
public class Serialize {
    static void main(String[] args) {
        String json = """
                [ {"id": 1, "name": Alsu, "age": 30},
                {"id": 2, "name": Anna, "age": 13},
                {"id": 3, "name": Mary, "age": 34}]
                """;
        Gson gson = new Gson();
        Type uesrListType = new TypeToken<List<User>>() {
        }.getType();
        List<User> users = gson.fromJson(json, uesrListType);
        List<User> filteredUsers = users.stream().filter(user -> user.getAge() >= 18).toList();
        System.out.println(filteredUsers);
    }
}
