package cp;

import java.util.UUID;

public class Uuid {
    public static void main(String[] args) {
       String uuid= UUID.randomUUID().toString();
        uuid.replaceAll("_"," ");
        String uuid1=uuid.substring(0,12);
        System.out.println(uuid1);
    }
}
