public interface CommandInterface {
    public boolean isValidate(String query);

    public void process(String query);
}