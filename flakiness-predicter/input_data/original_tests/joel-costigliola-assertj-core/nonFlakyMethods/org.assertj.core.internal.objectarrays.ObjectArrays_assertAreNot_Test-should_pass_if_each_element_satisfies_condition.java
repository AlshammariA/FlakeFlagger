@Test public void should_pass_if_each_element_satisfies_condition(){
  actual=array("Solo","Leia");
  arrays.assertAreNot(someInfo(),actual,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
