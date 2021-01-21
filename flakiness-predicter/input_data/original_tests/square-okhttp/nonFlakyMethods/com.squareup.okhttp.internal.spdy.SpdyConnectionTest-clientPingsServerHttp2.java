@Test public void clientPingsServerHttp2() throws Exception {
  peer.setVariantAndClient(HTTP_20_DRAFT_09,false);
  peer.acceptFrame();
  peer.sendFrame().ping(true,1,5);
  peer.play();
  SpdyConnection connection=connection(peer,HTTP_20_DRAFT_09);
  Ping ping=connection.ping();
  assertTrue(ping.roundTripTime() > 0);
  assertTrue(ping.roundTripTime() < TimeUnit.SECONDS.toNanos(1));
  MockSpdyPeer.InFrame pingFrame=peer.takeFrame();
  assertEquals(0,pingFrame.streamId);
  assertEquals(1,pingFrame.payload1);
  assertEquals(0x4f4b6f6b,pingFrame.payload2);
  assertFalse(pingFrame.ack);
}
