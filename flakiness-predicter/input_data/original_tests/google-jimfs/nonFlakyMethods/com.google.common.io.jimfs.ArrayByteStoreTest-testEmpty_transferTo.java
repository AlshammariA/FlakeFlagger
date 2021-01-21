@Test public void testEmpty_transferTo() throws IOException {
  ByteBufferChannel channel=new ByteBufferChannel(100);
  assertEquals(0,store.transferTo(0,100,channel));
}
