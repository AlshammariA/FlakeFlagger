@Test(timeout=2000) public void testIssue() throws Exception {
  final int port=SocketUtil.getAvailablePort();
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
      try {
        for (int i=0; i < 10; i++) {
          TestWebSocket tw=new TestWebSocket(port);
          tw.connect();
        }
      }
 catch (      Exception e) {
        Assert.fail("Exception during connect!");
      }
    }
  }
;
  server.start();
  countDownLatchConnect.await();
  server.broadcast("Hello world!");
  countDownLatchString.await();
  server.broadcast("Hello world".getBytes());
  countDownLatchBytebuffer.await();
  countDownLatchBytebuffer=new CountDownLatch(10);
  server.broadcast(ByteBuffer.wrap("Hello world".getBytes()));
  countDownLatchBytebuffer.await();
  countDownLatchString=new CountDownLatch(5);
  ArrayList<WebSocket> specialList=new ArrayList<WebSocket>(server.getConnections());
  specialList.remove(8);
  specialList.remove(6);
  specialList.remove(4);
  specialList.remove(2);
  specialList.remove(0);
  server.broadcast("Hello world",specialList);
  countDownLatchString.await();
  countDownLatchBytebuffer=new CountDownLatch(5);
  server.broadcast("Hello world".getBytes());
  countDownLatchBytebuffer.await();
}
