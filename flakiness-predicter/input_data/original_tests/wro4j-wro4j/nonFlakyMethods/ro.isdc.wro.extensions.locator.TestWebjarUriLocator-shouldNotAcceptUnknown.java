@Test public void shouldNotAcceptUnknown(){
  assertFalse(victim.accept("http://www.server.com/path/to/resource.js"));
}
