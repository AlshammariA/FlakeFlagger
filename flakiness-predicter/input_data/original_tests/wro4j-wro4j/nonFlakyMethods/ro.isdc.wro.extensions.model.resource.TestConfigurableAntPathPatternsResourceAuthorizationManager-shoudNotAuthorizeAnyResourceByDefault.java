@Test public void shoudNotAuthorizeAnyResourceByDefault(){
  assertFalse(victim.isAuthorized("/any"));
}
