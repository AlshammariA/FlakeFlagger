@Test public void should_pass_if_size_of_actual_is_equal_to_expected_size(){
  maps.assertHasSameSizeAs(someInfo(),actual,mapOf(entry("name","Solo"),entry("job","Smuggler")));
}
