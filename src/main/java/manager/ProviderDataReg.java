package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ProviderDataReg {

    @DataProvider
    public Iterator<Object[]> userModelRegListDTO() {
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withName("John")
                .withLastName("News")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("Dfr#12584tre")});
        list.add(new Object[]{new User()
                .withName("Ket")
                .withLastName("News")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("Dfr#12584tre")});
        list.add(new Object[]{new User()
                .withName("Lizi")
                .withLastName("News")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("Dfr#12584tre")});

        return list.iterator();

    }
}
