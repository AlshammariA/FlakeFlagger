@Test public void should_pass_if_index_is_out_of_bounds(){
  lists.assertDoesNotContain(someInfo(),actual,"Yoda",atIndex(6));
}
