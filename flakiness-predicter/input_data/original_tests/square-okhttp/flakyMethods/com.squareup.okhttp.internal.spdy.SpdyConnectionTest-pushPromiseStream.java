@Test public void pushPromiseStream() throws Exception {
  peer.setVariantAndClient(HTTP_20_DRAFT_09,false);
  peer.acceptFrame();
  peer.sendFrame().synReply(false,1,headerEntries("a","android"));
  final List<Header> expectedRequestHeaders=Arrays.asList(new Header(Header.TARGET_METHOD,"GET"),new Header(Header.TARGET_SCHEME,"https"),new Header(Header.TARGET_AUTHORITY,"squareup.com"),new Header(Header.TARGET_PATH,"/cached"));
  peer.sendFrame().pushPromise(1,2,expectedRequestHeaders);
  final List<Header> expectedResponseHeaders=Arrays.asList(new Header(Header.RESPONSE_STATUS,"200"));
  peer.sendFrame().synReply(true,2,expectedResponseHeaders);
  peer.sendFrame().data(true,1,data(0));
  peer.play();
  final List events=new ArrayList();
  PushObserver observer=new PushObserver(){
    @Override public boolean onRequest(    int streamId,    List<Header> requestHeaders){
      assertEquals(2,streamId);
      events.add(requestHeaders);
      return false;
    }
    @Override public boolean onHeaders(    int streamId,    List<Header> responseHeaders,    boolean last){
      assertEquals(2,streamId);
      assertTrue(last);
      events.add(responseHeaders);
      return false;
    }
    @Override public boolean onData(    int streamId,    BufferedSource source,    int byteCount,    boolean last) throws IOException {
      events.add(new AssertionError("onData"));
      return false;
    }
    @Override public void onReset(    int streamId,    ErrorCode errorCode){
      events.add(new AssertionError("onReset"));
    }
  }
;
  SpdyConnection connection=connectionBuilder(peer,HTTP_20_DRAFT_09).pushObserver(observer).build();
  SpdyStream client=connection.newStream(headerEntries("b","banana"),false,true);
  assertEquals(-1,client.getSource().read(new OkBuffer(),1));
  assertEquals(TYPE_HEADERS,peer.takeFrame().type);
  assertEquals(2,events.size());
  assertEquals(expectedRequestHeaders,events.get(0));
  assertEquals(expectedResponseHeaders,events.get(1));
}
