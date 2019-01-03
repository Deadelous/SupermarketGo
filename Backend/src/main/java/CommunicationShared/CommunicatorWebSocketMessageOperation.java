package CommunicationShared;

public enum CommunicatorWebSocketMessageOperation {
    REGISTERPROPERTY,         // Register a property (client only)
    UPDATEPROPERTY,           // Update property (client and server)
    SUBSCRIBETOPROPERTY,
    CHATPROPERTY
}
