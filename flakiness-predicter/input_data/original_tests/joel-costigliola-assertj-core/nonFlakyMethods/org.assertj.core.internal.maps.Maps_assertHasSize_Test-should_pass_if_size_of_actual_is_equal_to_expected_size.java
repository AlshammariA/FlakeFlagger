@Test public void should_pass_if_size_of_actual_is_equal_to_expected_size(){
  Map<?,?> actual=mapOf(entry("name","Yoda"),entry("job","Yedi Master"));
  maps.assertHasSize(someInfo(),actual,2);
}
