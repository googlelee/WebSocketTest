package com.example.mywebsockettest;

import android.util.Log;
import java.net.URI;
import java.util.Map;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

/**
 * @description: 客户端
 * @author: haojli
 * @date: 2023/3/2
 */
public class MyWebSocketClient extends WebSocketClient {

    private static final String TAG = MyWebSocketClient.class.getSimpleName();

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    public MyWebSocketClient(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
    }

    public MyWebSocketClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public MyWebSocketClient(URI serverUri, Draft protocolDraft,
            Map<String, String> httpHeaders) {
        super(serverUri, protocolDraft, httpHeaders);
    }

    public MyWebSocketClient(URI serverUri, Draft protocolDraft,
            Map<String, String> httpHeaders, int connectTimeout) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.d(TAG, "onOpen: ");
    }

    @Override
    public void onMessage(String message) {
        Log.d(TAG, "onMessage: ");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.d(TAG, "onClose: ");
    }

    @Override
    public void onError(Exception ex) {
        Log.d(TAG, "onError: " + ex.getMessage());
    }
}
