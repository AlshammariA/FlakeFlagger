@Test public void should_pass_if_actual_can_write(){
  when(actual.canWrite()).thenReturn(true);
  files.assertCanWrite(someInfo(),actual);
}
