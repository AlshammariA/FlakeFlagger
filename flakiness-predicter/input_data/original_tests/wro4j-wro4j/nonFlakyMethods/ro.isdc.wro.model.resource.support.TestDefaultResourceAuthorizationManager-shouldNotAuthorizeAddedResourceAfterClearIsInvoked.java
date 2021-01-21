@Test public void shouldNotAuthorizeAddedResourceAfterClearIsInvoked(){
  final String resource="/resource.js";
  victim.add(resource);
  assertTrue(victim.isAuthorized(resource));
  victim.clear();
  assertFalse(victim.isAuthorized(resource));
}
