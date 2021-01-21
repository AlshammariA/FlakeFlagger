@Test public void testMD5() throws Exception {
  final String input="testString";
  fingerprintCreator=new MD5HashStrategy();
  final String hash=fingerprintCreator.getHash(new ByteArrayInputStream(input.getBytes()));
  assertEquals("536788f4dbdffeecfbb8f350a941eea3",hash);
}
