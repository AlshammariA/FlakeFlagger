@Test public void should_pass_if_actual_can_read(){
  when(actual.canRead()).thenReturn(true);
  files.assertCanRead(someInfo(),actual);
}
