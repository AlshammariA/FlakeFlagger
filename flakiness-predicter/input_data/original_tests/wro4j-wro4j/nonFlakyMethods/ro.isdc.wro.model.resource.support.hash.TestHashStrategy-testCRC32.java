@Test public void testCRC32() throws Exception {
  final String input="testString";
  fingerprintCreator=new CRC32HashStrategy();
  final String hash=fingerprintCreator.getHash(new ByteArrayInputStream(input.getBytes()));
  assertEquals("18f4fd08",hash);
}
