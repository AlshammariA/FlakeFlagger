@Test public void should_fail_if_actual_is_not_normalized(){
  when(actual.normalize()).thenReturn(mock(Path.class));
  try {
    paths.assertIsNormalized(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeNormalized(actual));
  }
}
