@Test public void should_throw_error_if_array_of_entries_to_look_for_is_null(){
  thrown.expectNullPointerException(entriesToLookForIsNull());
  maps.assertContains(someInfo(),actual,null);
}
