@Test public void should_throw_error_if_array_of_types_has_null_elements(){
  Class<?>[] types={null,String.class};
  thrown.expectNullPointerException("The given array of types:<[null, java.lang.String]> should not have null elements");
  objects.assertIsNotInstanceOfAny(someInfo(),actual,types);
}
