@Test public void should_pass_if_each_element_satisfies_condition(){
  actual=array("Yoda","Luke");
  arrays.assertAre(someInfo(),actual,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
