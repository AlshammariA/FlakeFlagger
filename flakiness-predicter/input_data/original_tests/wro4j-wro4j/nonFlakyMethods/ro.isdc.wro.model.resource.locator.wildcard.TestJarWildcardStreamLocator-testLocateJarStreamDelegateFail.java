@Test(expected=IOException.class) public void testLocateJarStreamDelegateFail() throws IOException {
  jarStreamLocator.locateStream("com/test/app/*.js",new File("test.jpg"));
}
