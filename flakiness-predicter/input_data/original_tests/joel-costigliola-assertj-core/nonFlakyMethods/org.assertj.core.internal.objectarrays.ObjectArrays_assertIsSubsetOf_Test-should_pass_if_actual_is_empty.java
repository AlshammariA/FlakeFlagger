@Test public void should_pass_if_actual_is_empty(){
  actual=new String[0];
  arrays.assertIsSubsetOf(someInfo(),actual,newArrayList("Luke","Yoda"));
}
