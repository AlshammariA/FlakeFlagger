@Test public void should_fail_if_actual_is_null(){
  thrown.expectAssertionError(actualIsNull());
  arrays.assertContainsOnly(someInfo(),null,arrayOf(8d));
}
