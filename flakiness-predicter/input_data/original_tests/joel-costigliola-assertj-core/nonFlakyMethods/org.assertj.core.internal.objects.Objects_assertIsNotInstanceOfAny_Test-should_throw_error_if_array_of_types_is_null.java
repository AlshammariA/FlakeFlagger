@Test public void should_throw_error_if_array_of_types_is_null(){
  thrown.expectNullPointerException("The given array of types should not be null");
  objects.assertIsNotInstanceOfAny(someInfo(),actual,null);
}
