package org.example.tools.geographies;

import org.example.model.Geography;
import org.example.tools.abstractions.IParse;

public class GeographyParser implements IParse<Geography> {


    @Override
    public Geography parse(String line) {
        line = line.trim();
        String[] parts = line.split(";");
        Geography geography = new Geography();
        geography.setId(Integer.parseInt(parts[0]));
        geography.setType(parts[1]);
        geography.setName(parts[2]);
        geography.setCode(parts[3]);
        if(parts[4].equalsIgnoreCase("null")){
            geography.setParentId(null);
        } else {
            geography.setParentId(Integer.parseInt(parts[4]));
        }

        return geography;
    }
}
