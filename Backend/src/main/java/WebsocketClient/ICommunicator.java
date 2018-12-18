package WebsocketClient;

public interface ICommunicator {

    public void start();

    /**
     * Stop the connection.
     */
    public void stop();

    public void update(CommunicatorMessage message);
}
