@Test public void should_success_if_key_is_null(){
  maps.assertContainsKeys(someInfo(),actual,(String)null);
}
