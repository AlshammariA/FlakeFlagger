@Test public void should_throw_error_if_array_of_values_to_look_for_is_null(){
  thrown.expectNullPointerException(valuesToLookForIsNull());
  iterables.assertContainsOnly(someInfo(),emptyList(),null);
}
