import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Tests_POST {
    @Test
    public void Test_01_post(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Brayan");
        map.put("job", "SDET");

        System.out.println(map);
    }
}
