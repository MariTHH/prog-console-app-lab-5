package commands;

public abstract class Command {
    private Object argument;

    public abstract void execute(String[] args) throws JAXBException, IOException, FileNotFoundException;
    public Object getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
