@Test public void should_pass_if_all_satisfies_condition_(){
  actual=array("Yoda","Luke","Obiwan");
  arrays.assertAreAtLeast(someInfo(),actual,2,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
