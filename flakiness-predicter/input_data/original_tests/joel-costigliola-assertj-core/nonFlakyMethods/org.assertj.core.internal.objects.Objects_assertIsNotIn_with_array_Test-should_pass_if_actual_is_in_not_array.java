@Test public void should_pass_if_actual_is_in_not_array(){
  objects.assertIsNotIn(someInfo(),"Luke",values);
}
