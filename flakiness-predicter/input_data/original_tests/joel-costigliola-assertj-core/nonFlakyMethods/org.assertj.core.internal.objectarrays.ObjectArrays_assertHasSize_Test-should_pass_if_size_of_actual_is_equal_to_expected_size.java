@Test public void should_pass_if_size_of_actual_is_equal_to_expected_size(){
  Byte[] actual=new Byte[2];
  arrays.assertHasSize(someInfo(),actual,2);
}
