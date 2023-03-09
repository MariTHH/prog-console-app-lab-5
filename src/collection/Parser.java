package collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class Parser {
    public Parser() {
    }

    public static void convertToXML(PersonCollection collection, String filename) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(PersonCollection.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filename));
        marshaller.marshal(collection, bufferedOutputStream);
        bufferedOutputStream.close();
    }
}
