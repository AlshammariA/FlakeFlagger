@Test public void clientPingsServer() throws Exception {
  peer.acceptFrame();
  peer.sendFrame().ping(true,1,5);
  peer.play();
  SpdyConnection connection=connection(peer,SPDY3);
  Ping ping=connection.ping();
  assertTrue(ping.roundTripTime() > 0);
  assertTrue(ping.roundTripTime() < TimeUnit.SECONDS.toNanos(1));
  MockSpdyPeer.InFrame pingFrame=peer.takeFrame();
  assertEquals(TYPE_PING,pingFrame.type);
  assertEquals(1,pingFrame.payload1);
  assertEquals(0,pingFrame.payload2);
  assertFalse(pingFrame.ack);
}
