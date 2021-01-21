@Test public void headersOnlyStreamIsClosedAfterReplyHeaders() throws Exception {
  peer.acceptFrame();
  peer.sendFrame().synReply(false,1,headerEntries("b","banana"));
  peer.play();
  SpdyConnection connection=connection(peer,SPDY3);
  SpdyStream stream=connection.newStream(headerEntries("a","android"),false,false);
  assertEquals(1,connection.openStreamCount());
  assertEquals(headerEntries("b","banana"),stream.getResponseHeaders());
  assertEquals(0,connection.openStreamCount());
}
