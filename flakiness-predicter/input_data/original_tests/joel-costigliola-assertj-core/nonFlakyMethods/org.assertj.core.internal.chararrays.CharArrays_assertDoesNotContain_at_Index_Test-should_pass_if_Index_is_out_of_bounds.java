@Test public void should_pass_if_Index_is_out_of_bounds(){
  arrays.assertDoesNotContain(someInfo(),actual,'a',atIndex(6));
}
