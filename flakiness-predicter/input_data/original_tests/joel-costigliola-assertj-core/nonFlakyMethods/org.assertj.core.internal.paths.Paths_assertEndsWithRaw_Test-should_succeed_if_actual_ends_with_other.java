@Test public void should_succeed_if_actual_ends_with_other(){
  when(actual.endsWith(other)).thenReturn(true);
  paths.assertEndsWithRaw(info,actual,other);
}
