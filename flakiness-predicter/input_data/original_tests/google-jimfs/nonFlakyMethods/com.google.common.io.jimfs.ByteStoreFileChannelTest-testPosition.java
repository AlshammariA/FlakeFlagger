@Test public void testPosition() throws IOException {
  ByteStoreFileChannel channel=channel(store(10),READ);
  assertEquals(0,channel.position());
  assertSame(channel,channel.position(100));
  assertEquals(100,channel.position());
}
