@Test public void should_success_if_key_is_null(){
  maps.assertDoesNotContainKey(someInfo(),actual,null);
}
