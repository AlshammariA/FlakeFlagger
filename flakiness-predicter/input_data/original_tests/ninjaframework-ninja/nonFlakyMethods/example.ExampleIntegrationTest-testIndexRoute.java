@Test public void testIndexRoute(){
  goTo(getServerAddress());
  assertTrue(pageSource().contains("Integration Test"));
}
