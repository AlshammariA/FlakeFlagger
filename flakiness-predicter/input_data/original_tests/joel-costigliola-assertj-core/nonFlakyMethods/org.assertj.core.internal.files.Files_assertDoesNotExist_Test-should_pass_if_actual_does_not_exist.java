@Test public void should_pass_if_actual_does_not_exist(){
  when(actual.exists()).thenReturn(false);
  files.assertDoesNotExist(someInfo(),actual);
}
