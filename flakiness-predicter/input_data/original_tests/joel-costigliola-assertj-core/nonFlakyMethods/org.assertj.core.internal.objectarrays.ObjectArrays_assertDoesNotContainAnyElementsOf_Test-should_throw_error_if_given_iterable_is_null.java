@Test public void should_throw_error_if_given_iterable_is_null(){
  thrown.expectNullPointerException(iterableValuesToLookForIsNull());
  arrays.assertDoesNotContainAnyElementsOf(someInfo(),actual,null);
}
