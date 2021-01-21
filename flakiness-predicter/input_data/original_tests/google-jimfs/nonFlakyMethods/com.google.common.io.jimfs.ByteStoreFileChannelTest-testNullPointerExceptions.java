@Test public void testNullPointerExceptions() throws IOException {
  ByteStoreFileChannel channel=channel(store(100),READ,WRITE);
  NullPointerTester tester=new NullPointerTester();
  tester.testAllPublicInstanceMethods(channel);
}
