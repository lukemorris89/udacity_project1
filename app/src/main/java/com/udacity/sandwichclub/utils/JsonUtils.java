package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject root = new JSONObject(json);

//            Extract details from JSON
            JSONObject nameDetails = root.getJSONObject("name");
            String mainName = nameDetails.getString("mainName");
            JSONArray alsoKnownAsJSON = nameDetails.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i<alsoKnownAsJSON.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJSON.get(i).toString());
            }
            String placeOfOrigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String imageSource = root.getString("image");
            JSONArray ingredientsJSON = root.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i<ingredientsJSON.length(); i++) {
                ingredients.add(ingredientsJSON.get(i).toString());
            }
//            Create sandwich object from JSON details
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, imageSource, ingredients);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
