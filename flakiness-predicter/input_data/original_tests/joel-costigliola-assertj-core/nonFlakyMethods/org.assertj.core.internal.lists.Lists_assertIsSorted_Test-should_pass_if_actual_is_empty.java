@Test public void should_pass_if_actual_is_empty(){
  lists.assertIsSorted(someInfo(),newArrayList());
}
