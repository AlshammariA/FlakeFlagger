@Test public void should_success_if_value_is_null(){
  maps.assertDoesNotContainValue(someInfo(),actual,null);
}
