@Test public void should_pass_if_actual_is_not_empty(){
  Map<?,?> actual=mapOf(entry("name","Yoda"));
  maps.assertNotEmpty(someInfo(),actual);
}
