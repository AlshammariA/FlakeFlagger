@Test public void shouldAcceptKnownUri(){
  assertTrue(victim.accept(WebjarUriLocator.createUri("/path/to/resource.js")));
}
