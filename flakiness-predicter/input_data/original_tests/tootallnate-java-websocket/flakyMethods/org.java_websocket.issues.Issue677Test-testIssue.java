@Test public void testIssue() throws Exception {
  int port=SocketUtil.getAvailablePort();
  WebSocketClient webSocket0=new WebSocketClient(new URI("ws://localhost:" + port)){
    @Override public void onOpen(    ServerHandshake handshakedata){
    }
    @Override public void onMessage(    String message){
    }
    @Override public void onClose(    int code,    String reason,    boolean remote){
      countDownLatch0.countDown();
    }
    @Override public void onError(    Exception ex){
    }
  }
;
  WebSocketClient webSocket1=new WebSocketClient(new URI("ws://localhost:" + port)){
    @Override public void onOpen(    ServerHandshake handshakedata){
    }
    @Override public void onMessage(    String message){
    }
    @Override public void onClose(    int code,    String reason,    boolean remote){
    }
    @Override public void onError(    Exception ex){
    }
  }
;
  WebSocketServer server=new WebSocketServer(new InetSocketAddress(port)){
    @Override public void onOpen(    WebSocket conn,    ClientHandshake handshake){
    }
    @Override public void onClose(    WebSocket conn,    int code,    String reason,    boolean remote){
    }
    @Override public void onMessage(    WebSocket conn,    String message){
    }
    @Override public void onError(    WebSocket conn,    Exception ex){
    }
    @Override public void onStart(){
      countServerDownLatch.countDown();
    }
  }
;
  server.start();
  countServerDownLatch.await();
  webSocket0.connectBlocking();
  assertTrue("webSocket.isOpen()",webSocket0.isOpen());
  webSocket0.close();
  assertTrue("webSocket.isClosing()",webSocket0.isClosing());
  countDownLatch0.await();
  assertTrue("webSocket.isClosed()",webSocket0.isClosed());
  webSocket1.connectBlocking();
  assertTrue("webSocket.isOpen()",webSocket1.isOpen());
  webSocket1.closeConnection(CloseFrame.ABNORMAL_CLOSE,"Abnormal close!");
  assertTrue("webSocket.isClosed()",webSocket1.isClosed());
  server.stop();
}
