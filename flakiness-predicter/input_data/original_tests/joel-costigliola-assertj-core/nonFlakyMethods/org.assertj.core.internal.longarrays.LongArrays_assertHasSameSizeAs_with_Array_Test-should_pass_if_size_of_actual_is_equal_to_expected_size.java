@Test public void should_pass_if_size_of_actual_is_equal_to_expected_size(){
  arrays.assertHasSameSizeAs(someInfo(),actual,array("Solo","Leia","Luke"));
}
