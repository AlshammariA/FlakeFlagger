@Test public void shouldAuthorizeAddedResource(){
  final String resource="/resource.js";
  victim.add(resource);
  assertTrue(victim.isAuthorized(resource));
}
