@Test public void testErrorInParameterLocatorNotCompact() throws Exception {
  String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxyz";
  testErrorInParameterLocator(alphabet + alphabet + alphabet);
}
