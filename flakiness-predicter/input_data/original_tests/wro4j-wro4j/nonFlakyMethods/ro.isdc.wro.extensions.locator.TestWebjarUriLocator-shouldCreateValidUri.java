@Test public void shouldCreateValidUri(){
  assertEquals("webjar:/path/to/resource.js",WebjarUriLocator.createUri("/path/to/resource.js"));
}
