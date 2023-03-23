package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"x", "y"})
public class Coordinates {
    private final long x;
    private final int y;

    public Coordinates(long x, int y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @XmlElement
    public void setX(long x) {
        this.x = x;
    }

    @XmlElement
    public void setY(int y) {
        this.y = y;
    }
    
}
