@Test public void should_pass_if_actual_has_same_size_as_other(){
  arrays.assertHasSameSizeAs(someInfo(),array("Solo","Leia"),newArrayList("Solo","Leia"));
}
