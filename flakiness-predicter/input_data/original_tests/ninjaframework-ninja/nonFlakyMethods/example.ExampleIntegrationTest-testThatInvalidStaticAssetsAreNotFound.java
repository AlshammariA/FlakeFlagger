@Test public void testThatInvalidStaticAssetsAreNotFound(){
  goTo(getServerAddress() + "/assets/css/INVALID_FILE");
  assertTrue(pageSource().isEmpty());
}
