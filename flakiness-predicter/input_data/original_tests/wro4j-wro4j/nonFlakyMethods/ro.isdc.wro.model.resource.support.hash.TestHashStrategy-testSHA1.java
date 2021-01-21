@Test public void testSHA1() throws Exception {
  final String input="testString";
  fingerprintCreator=new SHA1HashStrategy();
  final String hash=fingerprintCreator.getHash(new ByteArrayInputStream(input.getBytes()));
  assertEquals("956265657d0b637ef65b9b59f9f858eecf55ed6a",hash);
}
