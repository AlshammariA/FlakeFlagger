@Test public void should_pass_if_actual_is_not_in_Iterable(){
  objects.assertIsNotIn(someInfo(),"Luke",values);
}
