@Test public void should_pass_if_actual_is_normalized(){
  when(actual.normalize()).thenReturn(actual);
  paths.assertIsNormalized(info,actual);
}
