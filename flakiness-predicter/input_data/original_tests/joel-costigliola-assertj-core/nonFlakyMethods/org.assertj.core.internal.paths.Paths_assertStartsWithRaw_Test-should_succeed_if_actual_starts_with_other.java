@Test public void should_succeed_if_actual_starts_with_other(){
  when(actual.startsWith(other)).thenReturn(true);
  paths.assertStartsWithRaw(info,actual,other);
}
