@SuppressWarnings("unchecked") @Test public void should_throw_error_if_array_of_values_to_look_for_is_empty(){
  thrown.expectIllegalArgumentException(entriesToLookForIsEmpty());
  maps.assertDoesNotContain(someInfo(),actual,new MapEntry[0]);
}
